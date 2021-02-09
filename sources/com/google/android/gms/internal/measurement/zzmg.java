package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmg implements zzdb<zzmj> {
    private static zzmg zza = new zzmg();
    private final zzdb<zzmj> zzb;

    public static boolean zzb() {
        return ((zzmj) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzmj) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzmj) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzmj) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzmj) zza.zza()).zze();
    }

    private zzmg(zzdb<zzmj> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmg() {
        this(zzda.zza(new zzmi()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmj zza() {
        return this.zzb.zza();
    }
}
