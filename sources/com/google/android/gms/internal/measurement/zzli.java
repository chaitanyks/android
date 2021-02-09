package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzli implements zzdb<zzll> {
    private static zzli zza = new zzli();
    private final zzdb<zzll> zzb;

    public static boolean zzb() {
        return ((zzll) zza.zza()).zza();
    }

    private zzli(zzdb<zzll> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzli() {
        this(zzda.zza(new zzlk()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzll zza() {
        return this.zzb.zza();
    }
}
