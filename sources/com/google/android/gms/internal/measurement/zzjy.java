package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjy implements zzdb<zzkb> {
    private static zzjy zza = new zzjy();
    private final zzdb<zzkb> zzb;

    public static boolean zzb() {
        return ((zzkb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkb) zza.zza()).zzb();
    }

    private zzjy(zzdb<zzkb> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjy() {
        this(zzda.zza(new zzka()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkb zza() {
        return this.zzb.zza();
    }
}
