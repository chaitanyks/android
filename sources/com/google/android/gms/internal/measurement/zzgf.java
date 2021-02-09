package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzgf implements zzgn {
    private zzgn[] zza;

    zzgf(zzgn... zzgnArr) {
        this.zza = zzgnArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final boolean zza(Class<?> cls) {
        for (zzgn zzgn : this.zza) {
            if (zzgn.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final zzgk zzb(Class<?> cls) {
        zzgn[] zzgnArr = this.zza;
        for (zzgn zzgn : zzgnArr) {
            if (zzgn.zza(cls)) {
                return zzgn.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
