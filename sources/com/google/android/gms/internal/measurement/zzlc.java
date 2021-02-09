package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlc implements zzdb<zzlf> {
    private static zzlc zza = new zzlc();
    private final zzdb<zzlf> zzb;

    public static boolean zzb() {
        return ((zzlf) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlf) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlf) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzlf) zza.zza()).zzd();
    }

    private zzlc(zzdb<zzlf> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlc() {
        this(zzda.zza(new zzle()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlf zza() {
        return this.zzb.zza();
    }
}
