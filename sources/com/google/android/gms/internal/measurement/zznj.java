package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zznj implements zzdb<zzni> {
    private static zznj zza = new zznj();
    private final zzdb<zzni> zzb;

    public static boolean zzb() {
        return ((zzni) zza.zza()).zza();
    }

    private zznj(zzdb<zzni> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zznj() {
        this(zzda.zza(new zznl()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzni zza() {
        return this.zzb.zza();
    }
}
