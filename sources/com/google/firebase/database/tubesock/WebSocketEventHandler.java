package com.google.firebase.database.tubesock;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface WebSocketEventHandler {
    void onClose();

    void onError(WebSocketException webSocketException);

    void onLogMessage(String str);

    void onMessage(WebSocketMessage webSocketMessage);

    void onOpen();
}
