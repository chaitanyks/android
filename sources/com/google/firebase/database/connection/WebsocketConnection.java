package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class WebsocketConnection {
    private static final long CONNECT_TIMEOUT_MS = 30000;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 45000;
    private static final int MAX_FRAME_SIZE = 16384;
    private static long connectionId = 0;
    private WSClient conn;
    private ScheduledFuture<?> connectTimeout;
    private final ConnectionContext connectionContext;
    private Delegate delegate;
    private boolean everConnected = false;
    private final ScheduledExecutorService executorService;
    private StringListReader frameReader;
    private boolean isClosed = false;
    private ScheduledFuture<?> keepAlive;
    private final LogWrapper logger;
    private long totalFrames = 0;

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface Delegate {
        void onDisconnect(boolean z);

        void onMessage(Map<String, Object> map);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface WSClient {
        void close();

        void connect();

        void send(String str);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public class WSClientTubesock implements WSClient, WebSocketEventHandler {
        private WebSocket ws;

        private WSClientTubesock(WebSocket ws2) {
            this.ws = ws2;
            ws2.setEventHandler(this);
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onOpen() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass1 */

                public void run() {
                    WebsocketConnection.this.connectTimeout.cancel(false);
                    WebsocketConnection.this.everConnected = true;
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("websocket opened", new Object[0]);
                    }
                    WebsocketConnection.this.resetKeepAlive();
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onMessage(WebSocketMessage msg) {
            final String str = msg.getText();
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper logWrapper = WebsocketConnection.this.logger;
                logWrapper.debug("ws message: " + str, new Object[0]);
            }
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass2 */

                public void run() {
                    WebsocketConnection.this.handleIncomingFrame(str);
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onClose() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass3 */

                public void run() {
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("closed", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onError(final WebSocketException e) {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass4 */

                public void run() {
                    if (e.getCause() == null || !(e.getCause() instanceof EOFException)) {
                        WebsocketConnection.this.logger.debug("WebSocket error.", e, new Object[0]);
                    } else {
                        WebsocketConnection.this.logger.debug("WebSocket reached EOF.", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onLogMessage(String msg) {
            if (WebsocketConnection.this.logger.logsDebug()) {
                LogWrapper logWrapper = WebsocketConnection.this.logger;
                logWrapper.debug("Tubesock: " + msg, new Object[0]);
            }
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void send(String msg) {
            this.ws.send(msg);
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void close() {
            this.ws.close();
        }

        private void shutdown() {
            this.ws.close();
            try {
                this.ws.blockClose();
            } catch (InterruptedException e) {
                WebsocketConnection.this.logger.error("Interrupted while shutting down websocket threads", e);
            }
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void connect() {
            try {
                this.ws.connect();
            } catch (WebSocketException e) {
                if (WebsocketConnection.this.logger.logsDebug()) {
                    WebsocketConnection.this.logger.debug("Error connecting", e, new Object[0]);
                }
                shutdown();
            }
        }
    }

    public WebsocketConnection(ConnectionContext connectionContext2, HostInfo hostInfo, String optCachedHost, Delegate delegate2, String optLastSessionId) {
        this.connectionContext = connectionContext2;
        this.executorService = connectionContext2.getExecutorService();
        this.delegate = delegate2;
        long connId = connectionId;
        connectionId = 1 + connId;
        Logger logger2 = connectionContext2.getLogger();
        this.logger = new LogWrapper(logger2, "WebSocket", "ws_" + connId);
        this.conn = createConnection(hostInfo, optCachedHost, optLastSessionId);
    }

    private WSClient createConnection(HostInfo hostInfo, String optCachedHost, String optLastSessionId) {
        URI uri = HostInfo.getConnectionUrl(optCachedHost != null ? optCachedHost : hostInfo.getHost(), hostInfo.isSecure(), hostInfo.getNamespace(), optLastSessionId);
        Map<String, String> extraHeaders = new HashMap<>();
        extraHeaders.put("User-Agent", this.connectionContext.getUserAgent());
        return new WSClientTubesock(new WebSocket(this.connectionContext, uri, null, extraHeaders));
    }

    public void open() {
        this.conn.connect();
        this.connectTimeout = this.executorService.schedule(new Runnable() {
            /* class com.google.firebase.database.connection.WebsocketConnection.AnonymousClass1 */

            public void run() {
                WebsocketConnection.this.closeIfNeverConnected();
            }
        }, CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    public void start() {
    }

    public void close() {
        if (this.logger.logsDebug()) {
            this.logger.debug("websocket is being closed", new Object[0]);
        }
        this.isClosed = true;
        this.conn.close();
        ScheduledFuture<?> scheduledFuture = this.connectTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.keepAlive;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void send(Map<String, Object> message) {
        resetKeepAlive();
        try {
            String[] segs = splitIntoFrames(JsonMapper.serializeJson(message), 16384);
            if (segs.length > 1) {
                this.conn.send("" + segs.length);
            }
            for (String str : segs) {
                this.conn.send(str);
            }
        } catch (IOException e) {
            this.logger.error("Failed to serialize message: " + message.toString(), e);
            shutdown();
        }
    }

    private void appendFrame(String message) {
        this.frameReader.addString(message);
        long j = this.totalFrames - 1;
        this.totalFrames = j;
        if (j == 0) {
            try {
                this.frameReader.freeze();
                Map<String, Object> decoded = JsonMapper.parseJson(this.frameReader.toString());
                this.frameReader = null;
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("handleIncomingFrame complete frame: " + decoded, new Object[0]);
                }
                this.delegate.onMessage(decoded);
            } catch (IOException e) {
                LogWrapper logWrapper2 = this.logger;
                logWrapper2.error("Error parsing frame: " + this.frameReader.toString(), e);
                close();
                shutdown();
            } catch (ClassCastException e2) {
                LogWrapper logWrapper3 = this.logger;
                logWrapper3.error("Error parsing frame (cast error): " + this.frameReader.toString(), e2);
                close();
                shutdown();
            }
        }
    }

    private void handleNewFrameCount(int numFrames) {
        this.totalFrames = (long) numFrames;
        this.frameReader = new StringListReader();
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("HandleNewFrameCount: " + this.totalFrames, new Object[0]);
        }
    }

    private String extractFrameCount(String message) {
        if (message.length() <= 6) {
            try {
                int frameCount = Integer.parseInt(message);
                if (frameCount <= 0) {
                    return null;
                }
                handleNewFrameCount(frameCount);
                return null;
            } catch (NumberFormatException e) {
            }
        }
        handleNewFrameCount(1);
        return message;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleIncomingFrame(String message) {
        if (!this.isClosed) {
            resetKeepAlive();
            if (isBuffering()) {
                appendFrame(message);
                return;
            }
            String remaining = extractFrameCount(message);
            if (remaining != null) {
                appendFrame(remaining);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetKeepAlive() {
        if (!this.isClosed) {
            ScheduledFuture<?> scheduledFuture = this.keepAlive;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("Reset keepAlive. Remaining: " + this.keepAlive.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
                }
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Reset keepAlive", new Object[0]);
            }
            this.keepAlive = this.executorService.schedule(nop(), KEEP_ALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    private Runnable nop() {
        return new Runnable() {
            /* class com.google.firebase.database.connection.WebsocketConnection.AnonymousClass2 */

            public void run() {
                if (WebsocketConnection.this.conn != null) {
                    WebsocketConnection.this.conn.send("0");
                    WebsocketConnection.this.resetKeepAlive();
                }
            }
        };
    }

    private boolean isBuffering() {
        return this.frameReader != null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onClosed() {
        if (!this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.conn = null;
        ScheduledFuture<?> scheduledFuture = this.keepAlive;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private void shutdown() {
        this.isClosed = true;
        this.delegate.onDisconnect(this.everConnected);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void closeIfNeverConnected() {
        if (!this.everConnected && !this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("timed out on connect", new Object[0]);
            }
            this.conn.close();
        }
    }

    private static String[] splitIntoFrames(String src, int maxFrameSize) {
        if (src.length() <= maxFrameSize) {
            return new String[]{src};
        }
        ArrayList<String> segs = new ArrayList<>();
        int i = 0;
        while (i < src.length()) {
            segs.add(src.substring(i, Math.min(i + maxFrameSize, src.length())));
            i += maxFrameSize;
        }
        return (String[]) segs.toArray(new String[segs.size()]);
    }
}
