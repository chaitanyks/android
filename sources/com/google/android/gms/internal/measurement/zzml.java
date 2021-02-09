package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzml implements zzdb<zzmk> {
    private static zzml zza = new zzml();
    private final zzdb<zzmk> zzb;

    public static boolean zzb() {
        return ((zzmk) zza.zza()).zza();
    }

    private zzml(zzdb<zzmk> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzml() {
        this(zzda.zza(new zzmn()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmk zza() {
        return this.zzb.zza();
    }
}
