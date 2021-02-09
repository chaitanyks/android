package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmr implements zzdb<zzmq> {
    private static zzmr zza = new zzmr();
    private final zzdb<zzmq> zzb;

    public static boolean zzb() {
        return ((zzmq) zza.zza()).zza();
    }

    private zzmr(zzdb<zzmq> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmr() {
        this(zzda.zza(new zzmt()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmq zza() {
        return this.zzb.zza();
    }
}
