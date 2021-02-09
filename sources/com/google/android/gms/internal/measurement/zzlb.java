package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlb implements zzdb<zzla> {
    private static zzlb zza = new zzlb();
    private final zzdb<zzla> zzb;

    public static boolean zzb() {
        return ((zzla) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzla) zza.zza()).zzb();
    }

    private zzlb(zzdb<zzla> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlb() {
        this(zzda.zza(new zzld()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzla zza() {
        return this.zzb.zza();
    }
}
