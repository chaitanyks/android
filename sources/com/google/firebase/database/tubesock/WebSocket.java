package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class WebSocket {
    static final byte OPCODE_BINARY = 2;
    static final byte OPCODE_CLOSE = 8;
    static final byte OPCODE_NONE = 0;
    static final byte OPCODE_PING = 9;
    static final byte OPCODE_PONG = 10;
    static final byte OPCODE_TEXT = 1;
    private static final int SSL_HANDSHAKE_TIMEOUT_MS = 60000;
    private static final String THREAD_BASE_NAME = "TubeSock";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static ThreadInitializer intializer = new ThreadInitializer() {
        /* class com.google.firebase.database.tubesock.WebSocket.AnonymousClass1 */

        @Override // com.google.firebase.database.tubesock.ThreadInitializer
        public void setName(Thread t, String name) {
            t.setName(name);
        }
    };
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private final int clientId;
    private WebSocketEventHandler eventHandler;
    private final WebSocketHandshake handshake;
    private final Thread innerThread;
    private final LogWrapper logger;
    private final WebSocketReceiver receiver;
    private volatile Socket socket;
    private final String sslCacheDirectory;
    private volatile State state;
    private final URI url;
    private final WebSocketWriter writer;

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public enum State {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    static ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    static ThreadInitializer getIntializer() {
        return intializer;
    }

    public static void setThreadFactory(ThreadFactory threadFactory2, ThreadInitializer intializer2) {
        threadFactory = threadFactory2;
        intializer = intializer2;
    }

    public WebSocket(ConnectionContext context, URI url2) {
        this(context, url2, null);
    }

    public WebSocket(ConnectionContext context, URI url2, String protocol) {
        this(context, url2, protocol, null);
    }

    public WebSocket(ConnectionContext context, URI url2, String protocol, Map<String, String> extraHeaders) {
        this.state = State.NONE;
        this.socket = null;
        this.eventHandler = null;
        this.clientId = clientCount.incrementAndGet();
        this.innerThread = getThreadFactory().newThread(new Runnable() {
            /* class com.google.firebase.database.tubesock.WebSocket.AnonymousClass2 */

            public void run() {
                WebSocket.this.runReader();
            }
        });
        this.url = url2;
        this.sslCacheDirectory = context.getSslCacheDirectory();
        Logger logger2 = context.getLogger();
        this.logger = new LogWrapper(logger2, "WebSocket", "sk_" + this.clientId);
        this.handshake = new WebSocketHandshake(url2, protocol, extraHeaders);
        this.receiver = new WebSocketReceiver(this);
        this.writer = new WebSocketWriter(this, THREAD_BASE_NAME, this.clientId);
    }

    public void setEventHandler(WebSocketEventHandler eventHandler2) {
        this.eventHandler = eventHandler2;
    }

    /* access modifiers changed from: package-private */
    public WebSocketEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public synchronized void connect() {
        if (this.state != State.NONE) {
            this.eventHandler.onError(new WebSocketException("connect() already called"));
            close();
            return;
        }
        ThreadInitializer intializer2 = getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer2.setName(innerThread2, "TubeSockReader-" + this.clientId);
        this.state = State.CONNECTING;
        getInnerThread().start();
    }

    public synchronized void send(String data) {
        send(OPCODE_TEXT, data.getBytes(UTF8));
    }

    public synchronized void send(byte[] data) {
        send(OPCODE_BINARY, data);
    }

    /* access modifiers changed from: package-private */
    public synchronized void pong(byte[] data) {
        send(OPCODE_PONG, data);
    }

    private synchronized void send(byte opcode, byte[] data) {
        if (this.state != State.CONNECTED) {
            this.eventHandler.onError(new WebSocketException("error while sending data: not connected"));
        } else {
            try {
                this.writer.send(opcode, true, data);
            } catch (IOException e) {
                this.eventHandler.onError(new WebSocketException("Failed to send frame", e));
                close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleReceiverError(WebSocketException e) {
        this.eventHandler.onError(e);
        if (this.state == State.CONNECTED) {
            close();
        }
        closeSocket();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.tubesock.WebSocket$3  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State = iArr;
            try {
                iArr[State.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[State.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public synchronized void close() {
        int i = AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[this.state.ordinal()];
        if (i == 1) {
            this.state = State.DISCONNECTED;
        } else if (i == 2) {
            closeSocket();
        } else if (i == 3) {
            sendCloseHandshake();
        } else if (i == 4) {
        } else {
            if (i == 5) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onCloseOpReceived() {
        closeSocket();
    }

    private synchronized void closeSocket() {
        if (this.state != State.DISCONNECTED) {
            this.receiver.stopit();
            this.writer.stopIt();
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.state = State.DISCONNECTED;
            this.eventHandler.onClose();
        }
    }

    private void sendCloseHandshake() {
        try {
            this.state = State.DISCONNECTING;
            this.writer.stopIt();
            this.writer.send(OPCODE_CLOSE, true, new byte[0]);
        } catch (IOException e) {
            this.eventHandler.onError(new WebSocketException("Failed to send close frame", e));
        }
    }

    private Socket createSocket() {
        String scheme = this.url.getScheme();
        String host = this.url.getHost();
        int port = this.url.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException uhe) {
                throw new WebSocketException("unknown host: " + host, uhe);
            } catch (IOException ioe) {
                throw new WebSocketException("error while creating socket to " + this.url, ioe);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            throw new WebSocketException("unsupported protocol: " + scheme);
        } else {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sessionCache = null;
            try {
                if (this.sslCacheDirectory != null) {
                    sessionCache = new SSLSessionCache(new File(this.sslCacheDirectory));
                }
            } catch (IOException e) {
                this.logger.debug("Failed to initialize SSL session cache", e, new Object[0]);
            }
            try {
                SSLSocket sslSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(SSL_HANDSHAKE_TIMEOUT_MS, sessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sslSocket.getSession())) {
                    return sslSocket;
                }
                throw new WebSocketException("Error while verifying secure socket to " + this.url);
            } catch (UnknownHostException uhe2) {
                throw new WebSocketException("unknown host: " + host, uhe2);
            } catch (IOException ioe2) {
                throw new WebSocketException("error while creating secure socket to " + this.url, ioe2);
            }
        }
    }

    public void blockClose() throws InterruptedException {
        if (this.writer.getInnerThread().getState() != Thread.State.NEW) {
            this.writer.getInnerThread().join();
        }
        getInnerThread().join();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        r0 = new java.io.DataInputStream(r0.getInputStream());
        r3 = r0.getOutputStream();
        r3.write(r16.handshake.getHandshake());
        r4 = false;
        r6 = new byte[1000];
        r7 = 0;
        r8 = new java.util.ArrayList<>();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r4 != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r9 = r0.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r9 == -1) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r6[r7] = (byte) r9;
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r6[r7 - 1] != 10) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        if (r6[r7 - 2] != 13) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        r10 = new java.lang.String(r6, com.google.firebase.database.tubesock.WebSocket.UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        if (r10.trim().equals("") == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0078, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        r8.add(r10.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        r6 = new byte[1000];
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
        if (r7 == 1000) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        r10 = new java.lang.String(r6, com.google.firebase.database.tubesock.WebSocket.UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a9, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Unexpected long line in handshake: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Connection closed before handshake was complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
        r10 = 0;
        r16.handshake.verifyServerStatusLine(r8.get(0));
        r8.remove(0);
        r9 = new java.util.HashMap<>();
        r11 = r8.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ce, code lost:
        if (r11.hasNext() == false) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d0, code lost:
        r13 = r11.next().split(": ", 2);
        r9.put(r13[r10].toLowerCase(java.util.Locale.US), r13[1].toLowerCase(java.util.Locale.US));
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f3, code lost:
        r16.handshake.verifyServerHandshakeHeaders(r9);
        r16.writer.setOutput(r3);
        r16.receiver.setInput(r0);
        r16.state = com.google.firebase.database.tubesock.WebSocket.State.CONNECTED;
        r16.writer.getInnerThread().start();
        r16.eventHandler.onOpen();
        r16.receiver.run();
     */
    private void runReader() {
        try {
            Socket socket2 = createSocket();
            synchronized (this) {
                this.socket = socket2;
                if (this.state == State.DISCONNECTED) {
                    try {
                        this.socket.close();
                        this.socket = null;
                        close();
                        return;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (WebSocketException wse) {
            this.eventHandler.onError(wse);
        } catch (Throwable th) {
            close();
            throw th;
        }
        close();
    }

    /* access modifiers changed from: package-private */
    public Thread getInnerThread() {
        return this.innerThread;
    }
}
