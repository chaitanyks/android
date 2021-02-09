package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzln implements zzdb<zzlm> {
    private static zzln zza = new zzln();
    private final zzdb<zzlm> zzb;

    public static boolean zzb() {
        return ((zzlm) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlm) zza.zza()).zzb();
    }

    private zzln(zzdb<zzlm> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzln() {
        this(zzda.zza(new zzlp()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlm zza() {
        return this.zzb.zza();
    }
}
