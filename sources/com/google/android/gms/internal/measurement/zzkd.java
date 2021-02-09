package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkd implements zzdb<zzkc> {
    private static zzkd zza = new zzkd();
    private final zzdb<zzkc> zzb;

    public static boolean zzb() {
        return ((zzkc) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkc) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzkc) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzkc) zza.zza()).zzd();
    }

    public static boolean zzf() {
        return ((zzkc) zza.zza()).zze();
    }

    private zzkd(zzdb<zzkc> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkd() {
        this(zzda.zza(new zzkf()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkc zza() {
        return this.zzb.zza();
    }
}
