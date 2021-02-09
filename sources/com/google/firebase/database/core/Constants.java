package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class Constants {
    public static final ChildKey DOT_INFO = ChildKey.fromString(".info");
    public static final ChildKey DOT_INFO_AUTHENTICATED = ChildKey.fromString("authenticated");
    public static final ChildKey DOT_INFO_CONNECTED = ChildKey.fromString("connected");
    public static final ChildKey DOT_INFO_SERVERTIME_OFFSET = ChildKey.fromString(com.google.firebase.database.connection.Constants.DOT_INFO_SERVERTIME_OFFSET);
    public static final String WIRE_PROTOCOL_VERSION = "5";
}
