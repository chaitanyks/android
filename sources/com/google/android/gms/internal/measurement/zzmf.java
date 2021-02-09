package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmf implements zzdb<zzme> {
    private static zzmf zza = new zzmf();
    private final zzdb<zzme> zzb;

    public static boolean zzb() {
        return ((zzme) zza.zza()).zza();
    }

    private zzmf(zzdb<zzme> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmf() {
        this(zzda.zza(new zzmh()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzme zza() {
        return this.zzb.zza();
    }
}
