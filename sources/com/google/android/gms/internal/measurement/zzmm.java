package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmm implements zzdb<zzmp> {
    private static zzmm zza = new zzmm();
    private final zzdb<zzmp> zzb;

    public static boolean zzb() {
        return ((zzmp) zza.zza()).zza();
    }

    private zzmm(zzdb<zzmp> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmm() {
        this(zzda.zza(new zzmo()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmp zza() {
        return this.zzb.zza();
    }
}
