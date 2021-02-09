package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlh implements zzdb<zzlg> {
    private static zzlh zza = new zzlh();
    private final zzdb<zzlg> zzb;

    public static boolean zzb() {
        return ((zzlg) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlg) zza.zza()).zzb();
    }

    private zzlh(zzdb<zzlg> zzdb) {
        this.zzb = zzda.zza((zzdb) zzdb);
    }

    public zzlh() {
        this(zzda.zza(new zzlj()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzdb
    public final /* synthetic */ zzlg zza() {
        return this.zzb.zza();
    }
}
