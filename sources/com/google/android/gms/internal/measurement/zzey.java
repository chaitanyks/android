package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final /* synthetic */ class zzey {
    static final /* synthetic */ int[] zza;
    static final /* synthetic */ int[] zzb;

    static {
        int[] iArr = new int[zzfo.values().length];
        zzb = iArr;
        try {
            iArr[zzfo.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzb[zzfo.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzb[zzfo.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        int[] iArr2 = new int[zzfb.values().length];
        zza = iArr2;
        try {
            iArr2[zzfb.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zza[zzfb.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zza[zzfb.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
