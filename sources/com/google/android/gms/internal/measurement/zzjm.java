package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjm implements zzdb<zzjp> {
    private static zzjm zza = new zzjm();
    private final zzdb<zzjp> zzb;

    public static boolean zzb() {
        return ((zzjp) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjp) zza.zza()).zzb();
    }

    private zzjm(zzdb<zzjp> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjm() {
        this(zzda.zza(new zzjo()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjp zza() {
        return this.zzb.zza();
    }
}
