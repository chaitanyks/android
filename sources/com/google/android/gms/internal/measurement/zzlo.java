package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlo implements zzdb<zzlr> {
    private static zzlo zza = new zzlo();
    private final zzdb<zzlr> zzb;

    public static boolean zzb() {
        return ((zzlr) zza.zza()).zza();
    }

    private zzlo(zzdb<zzlr> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlo() {
        this(zzda.zza(new zzlq()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlr zza() {
        return this.zzb.zza();
    }
}
