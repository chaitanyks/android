package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public enum zzir {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdw.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzir(Object obj) {
        this.zzj = obj;
    }
}
