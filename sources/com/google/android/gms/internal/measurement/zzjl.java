package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjl implements zzdb<zzjk> {
    private static zzjl zza = new zzjl();
    private final zzdb<zzjk> zzb;

    public static boolean zzb() {
        return ((zzjk) zza.zza()).zza();
    }

    private zzjl(zzdb<zzjk> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjl() {
        this(zzda.zza(new zzjn()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjk zza() {
        return this.zzb.zza();
    }
}
