package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjb implements zziy {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zziy
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.app_launch.event_ordering_fix", false);
        zzb = zzct.zza("measurement.id.app_launch.event_ordering_fix", 0L);
    }
}
