package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface EventTarget {
    void postEvent(Runnable runnable);

    void restart();

    void shutdown();
}
