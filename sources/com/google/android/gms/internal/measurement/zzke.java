package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzke implements zzdb<zzkh> {
    private static zzke zza = new zzke();
    private final zzdb<zzkh> zzb;

    public static boolean zzb() {
        return ((zzkh) zza.zza()).zza();
    }

    private zzke(zzdb<zzkh> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzke() {
        this(zzda.zza(new zzkg()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzkh zza() {
        return this.zzb.zza();
    }
}
