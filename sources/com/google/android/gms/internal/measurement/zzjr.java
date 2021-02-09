package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjr implements zzdb<zzjq> {
    private static zzjr zza = new zzjr();
    private final zzdb<zzjq> zzb;

    public static boolean zzb() {
        return ((zzjq) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzjq) zza.zza()).zzb();
    }

    private zzjr(zzdb<zzjq> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjr() {
        this(zzda.zza(new zzjt()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjq zza() {
        return this.zzb.zza();
    }
}
