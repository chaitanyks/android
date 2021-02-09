package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zznd implements zzdb<zznc> {
    private static zznd zza = new zznd();
    private final zzdb<zznc> zzb;

    public static boolean zzb() {
        return ((zznc) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznc) zza.zza()).zzb();
    }

    private zznd(zzdb<zznc> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zznd() {
        this(zzda.zza(new zznf()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zznc zza() {
        return this.zzb.zza();
    }
}
