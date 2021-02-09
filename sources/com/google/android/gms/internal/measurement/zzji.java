package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzji implements zzjj {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.service.disable_install_state_reporting", false);
        zzb = zzct.zza("measurement.id.service.disable_install_state_reporting", 0L);
    }
}
