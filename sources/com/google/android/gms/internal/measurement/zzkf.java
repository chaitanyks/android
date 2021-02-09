package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkf implements zzkc {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Boolean> zzb;
    private static final zzcn<Boolean> zzc;
    private static final zzcn<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzct.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzct.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzct.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
