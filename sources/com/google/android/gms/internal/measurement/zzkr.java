package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkr implements zzko {
    private static final zzcn<Boolean> zza;
    private static final zzcn<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzko
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzko
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzct zzct = new zzct(zzck.zza("com.google.android.gms.measurement"));
        zza = zzct.zza("measurement.service.fix_gmp_version", false);
        zzb = zzct.zza("measurement.id.service.fix_gmp_version", 0L);
    }
}
