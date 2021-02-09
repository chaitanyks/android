package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlu implements zzdb<zzlx> {
    private static zzlu zza = new zzlu();
    private final zzdb<zzlx> zzb;

    public static boolean zzb() {
        return ((zzlx) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlx) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlx) zza.zza()).zzc();
    }

    private zzlu(zzdb<zzlx> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlu() {
        this(zzda.zza(new zzlw()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlx zza() {
        return this.zzb.zza();
    }
}
