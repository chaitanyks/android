package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkk implements zzdb<zzkn> {
    private static zzkk zza = new zzkk();
    private final zzdb<zzkn> zzb;

    public static boolean zzb() {
        return ((zzkn) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkn) zza.zza()).zzb();
    }

    private zzkk(zzdb<zzkn> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkk() {
        this(zzda.zza(new zzkm()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkn zza() {
        return this.zzb.zza();
    }
}
