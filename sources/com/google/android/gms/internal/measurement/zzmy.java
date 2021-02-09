package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmy implements zzdb<zznb> {
    private static zzmy zza = new zzmy();
    private final zzdb<zznb> zzb;

    public static boolean zzb() {
        return ((zznb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznb) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zznb) zza.zza()).zzc();
    }

    private zzmy(zzdb<zznb> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzmy() {
        this(zzda.zza(new zzna()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zznb zza() {
        return this.zzb.zza();
    }
}
