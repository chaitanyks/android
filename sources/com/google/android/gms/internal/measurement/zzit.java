package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzit implements zzdb<zzis> {
    private static zzit zza = new zzit();
    private final zzdb<zzis> zzb;

    public static boolean zzb() {
        return ((zzis) zza.zza()).zza();
    }

    private zzit(zzdb<zzis> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzit() {
        this(zzda.zza(new zziv()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzis zza() {
        return this.zzb.zza();
    }
}
