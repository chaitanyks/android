package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zznk implements zzdb<zznn> {
    private static zznk zza = new zznk();
    private final zzdb<zznn> zzb;

    public static boolean zzb() {
        return ((zznn) zza.zza()).zza();
    }

    private zznk(zzdb<zznn> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zznk() {
        this(zzda.zza(new zznm()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zznn zza() {
        return this.zzb.zza();
    }
}
