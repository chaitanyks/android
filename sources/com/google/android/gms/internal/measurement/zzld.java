package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzld implements zzla {
    private static final zzcn<Boolean> zza = new zzct(zzck.zza("com.google.android.gms.measurement")).zza("measurement.lifecycle.app_background_timestamp_when_backgrounded", true);

    @Override // com.google.android.gms.internal.measurement.zzla
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
