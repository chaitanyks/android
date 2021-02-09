package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzne implements zzdb<zznh> {
    private static zzne zza = new zzne();
    private final zzdb<zznh> zzb;

    public static boolean zzb() {
        return ((zznh) zza.zza()).zza();
    }

    private zzne(zzdb<zznh> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzne() {
        this(zzda.zza(new zzng()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zznh zza() {
        return this.zzb.zza();
    }
}
