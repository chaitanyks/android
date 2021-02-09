package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkj implements zzdb<zzki> {
    private static zzkj zza = new zzkj();
    private final zzdb<zzki> zzb;

    public static boolean zzb() {
        return ((zzki) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzki) zza.zza()).zzb();
    }

    private zzkj(zzdb<zzki> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkj() {
        this(zzda.zza(new zzkl()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzki zza() {
        return this.zzb.zza();
    }
}
