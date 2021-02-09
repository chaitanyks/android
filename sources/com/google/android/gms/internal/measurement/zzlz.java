package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlz implements zzdb<zzly> {
    private static zzlz zza = new zzlz();
    private final zzdb<zzly> zzb;

    public static boolean zzb() {
        return ((zzly) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzly) zza.zza()).zzb();
    }

    private zzlz(zzdb<zzly> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlz() {
        this(zzda.zza(new zzmb()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzly zza() {
        return this.zzb.zza();
    }
}
