package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmu implements zzmv {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Boolean> zzb;
    private static final zzcn<Boolean> zzc;
    private static final zzcn<Boolean> zzd;
    private static final zzcn<Boolean> zze;
    private static final zzcn<Boolean> zzf;
    private static final zzcn<Long> zzg;
    private static final zzcn<Boolean> zzh;
    private static final zzcn<Boolean> zzi;

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzf() {
        return zze.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzg() {
        return zzf.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzh() {
        return zzh.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzi() {
        return zzi.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.service.audience.scoped_filters_v27", true);
        zzb = zzct.zza("measurement.service.audience.session_scoped_user_engagement", true);
        zzc = zzct.zza("measurement.client.audience.scoped_engagement_removal_when_session_expired", true);
        zzd = zzct.zza("measurement.service.audience.scoped_engagement_removal_when_session_expired", true);
        zze = zzct.zza("measurement.service.audience.session_scoped_event_aggregates", true);
        zzf = zzct.zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", true);
        zzg = zzct.zza("measurement.id.scoped_audience_filters", 0L);
        zzh = zzct.zza("measurement.service.audience.fix_prepending_previous_sequence_timestamp", true);
        zzi = zzct.zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }
}
