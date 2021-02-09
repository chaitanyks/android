package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkq implements zzdb<zzkt> {
    private static zzkq zza = new zzkq();
    private final zzdb<zzkt> zzb;

    public static boolean zzb() {
        return ((zzkt) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkt) zza.zza()).zzb();
    }

    private zzkq(zzdb<zzkt> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkq() {
        this(zzda.zza(new zzks()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkt zza() {
        return this.zzb.zza();
    }
}
