package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzja implements zzdb<zzjd> {
    private static zzja zza = new zzja();
    private final zzdb<zzjd> zzb;

    public static boolean zzb() {
        return ((zzjd) zza.zza()).zza();
    }

    private zzja(zzdb<zzjd> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzja() {
        this(zzda.zza(new zzjc()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjd zza() {
        return this.zzb.zza();
    }
}
