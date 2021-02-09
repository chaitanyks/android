package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkw implements zzdb<zzkz> {
    private static zzkw zza = new zzkw();
    private final zzdb<zzkz> zzb;

    public static boolean zzb() {
        return ((zzkz) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzkz) zza.zza()).zzb();
    }

    private zzkw(zzdb<zzkz> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzkw() {
        this(zzda.zza(new zzky()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkz zza() {
        return this.zzb.zza();
    }
}
