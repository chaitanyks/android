package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjo implements zzjp {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Boolean> zzb;
    private static final zzcn<Boolean> zzc;
    private static final zzcn<Long> zzd;

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.sdk.dynamite.allow_remote_dynamite", false);
        zzb = zzct.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzct.zza("measurement.sdk.dynamite.use_dynamite2", false);
        zzd = zzct.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
