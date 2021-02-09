package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkp implements zzdb<zzko> {
    private static zzkp zza = new zzkp();
    private final zzdb<zzko> zzb;

    public static boolean zzb() {
        return ((zzko) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzko) zza.zza()).zzb();
    }

    private zzkp(zzdb<zzko> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkp() {
        this(zzda.zza(new zzkr()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzko zza() {
        return this.zzb.zza();
    }
}
