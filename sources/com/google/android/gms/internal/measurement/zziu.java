package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziu implements zzdb<zzix> {
    private static zziu zza = new zziu();
    private final zzdb<zzix> zzb;

    public static boolean zzb() {
        return ((zzix) zza.zza()).zza();
    }

    private zziu(zzdb<zzix> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zziu() {
        this(zzda.zza(new zziw()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzix zza() {
        return this.zzb.zza();
    }
}
