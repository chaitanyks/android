package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmb implements zzly {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Boolean> zzb;

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.personalized_ads_signals_collection_enabled", true);
        zzb = zzct.zza("measurement.personalized_ads_property_translation_enabled", true);
    }
}
