package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface ListenHashProvider {
    CompoundHash getCompoundHash();

    String getSimpleHash();

    boolean shouldIncludeCompoundHash();
}
