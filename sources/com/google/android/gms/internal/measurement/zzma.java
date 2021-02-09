package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzma implements zzdb<zzmd> {
    private static zzma zza = new zzma();
    private final zzdb<zzmd> zzb;

    public static boolean zzb() {
        return ((zzmd) zza.zza()).zza();
    }

    private zzma(zzdb<zzmd> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzma() {
        this(zzda.zza(new zzmc()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmd zza() {
        return this.zzb.zza();
    }
}
