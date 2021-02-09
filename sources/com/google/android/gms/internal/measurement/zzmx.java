package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmx implements zzdb<zzmw> {
    private static zzmx zza = new zzmx();
    private final zzdb<zzmw> zzb;

    public static boolean zzb() {
        return ((zzmw) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmw) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmw) zza.zza()).zzc();
    }

    private zzmx(zzdb<zzmw> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmx() {
        this(zzda.zza(new zzmz()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzmw zza() {
        return this.zzb.zza();
    }
}
