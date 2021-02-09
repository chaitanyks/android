package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjg implements zzdb<zzjj> {
    private static zzjg zza = new zzjg();
    private final zzdb<zzjj> zzb;

    public static boolean zzb() {
        return ((zzjj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjj) zza.zza()).zzb();
    }

    private zzjg(zzdb<zzjj> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjg() {
        this(zzda.zza(new zzji()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjj zza() {
        return this.zzb.zza();
    }
}
