package com.google.firebase.database.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
class ThreadPoolEventTarget implements EventTarget {
    private final ThreadPoolExecutor executor;

    public ThreadPoolEventTarget(final ThreadFactory wrappedFactory, final ThreadInitializer threadInitializer) {
        this.executor = new ThreadPoolExecutor(1, 1, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            /* class com.google.firebase.database.core.ThreadPoolEventTarget.AnonymousClass1 */

            public Thread newThread(Runnable r) {
                Thread thread = wrappedFactory.newThread(r);
                threadInitializer.setName(thread, "FirebaseDatabaseEventTarget");
                threadInitializer.setDaemon(thread, true);
                return thread;
            }
        });
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void postEvent(Runnable r) {
        this.executor.execute(r);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void shutdown() {
        this.executor.setCorePoolSize(0);
    }

    @Override // com.google.firebase.database.core.EventTarget
    public void restart() {
        this.executor.setCorePoolSize(1);
    }
}
