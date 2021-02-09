package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzlw implements zzlx {
    private static final zzcn<Long> zza;
    private static final zzcn<Boolean> zzb;
    private static final zzcn<Boolean> zzc;
    private static final zzcn<Boolean> zzd;
    private static final zzcn<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzct.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzct.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzct.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzct.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
