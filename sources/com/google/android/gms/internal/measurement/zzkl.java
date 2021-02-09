package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkl implements zzki {
    private static final zzcn<Boolean> zza = new zzct(zzck.zza("com.google.android.gms.measurement")).zza("measurement.sdk.referrer.delayed_install_referrer_api", false);

    @Override // com.google.android.gms.internal.measurement.zzki
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzki
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
