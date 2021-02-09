package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkm implements zzkn {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.engagement_time_main_thread", false);
        zzb = zzct.zza("measurement.id.engagement_time_main_thread", 0L);
    }
}
