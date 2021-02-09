package com.google.firebase.database.logging;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface Logger {

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE
    }

    Level getLogLevel();

    void onLogMessage(Level level, String str, String str2, long j);
}
