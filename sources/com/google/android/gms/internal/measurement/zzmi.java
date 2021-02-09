package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzmi implements zzmj {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Double> zzb;
    private static final zzcn<Long> zzc;
    private static final zzcn<Long> zzd;
    private static final zzcn<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.test.boolean_flag", false);
        zzb = zzct.zza("measurement.test.double_flag", -3.0d);
        zzc = zzct.zza("measurement.test.int_flag", -2L);
        zzd = zzct.zza("measurement.test.long_flag", -1L);
        zze = zzct.zza("measurement.test.string_flag", "---");
    }
}
