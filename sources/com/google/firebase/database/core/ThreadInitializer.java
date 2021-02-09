package com.google.firebase.database.core;

import java.lang.Thread;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface ThreadInitializer {
    public static final ThreadInitializer defaultInstance = new ThreadInitializer() {
        /* class com.google.firebase.database.core.ThreadInitializer.AnonymousClass1 */

        @Override // com.google.firebase.database.core.ThreadInitializer
        public void setName(Thread t, String name) {
            t.setName(name);
        }

        @Override // com.google.firebase.database.core.ThreadInitializer
        public void setDaemon(Thread t, boolean isDaemon) {
            t.setDaemon(isDaemon);
        }

        @Override // com.google.firebase.database.core.ThreadInitializer
        public void setUncaughtExceptionHandler(Thread t, Thread.UncaughtExceptionHandler handler) {
            t.setUncaughtExceptionHandler(handler);
        }
    };

    void setDaemon(Thread thread, boolean z);

    void setName(Thread thread, String str);

    void setUncaughtExceptionHandler(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
