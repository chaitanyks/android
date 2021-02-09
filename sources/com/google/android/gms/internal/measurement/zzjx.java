package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjx implements zzdb<zzjw> {
    private static zzjx zza = new zzjx();
    private final zzdb<zzjw> zzb;

    public static boolean zzb() {
        return ((zzjw) zza.zza()).zza();
    }

    private zzjx(zzdb<zzjw> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzjx() {
        this(zzda.zza(new zzjz()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzjw zza() {
        return this.zzb.zza();
    }
}
