package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziz implements zzdb<zziy> {
    private static zziz zza = new zziz();
    private final zzdb<zziy> zzb;

    public static boolean zzb() {
        return ((zziy) zza.zza()).zza();
    }

    private zziz(zzdb<zziy> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zziz() {
        this(zzda.zza(new zzjb()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zziy zza() {
        return this.zzb.zza();
    }
}
