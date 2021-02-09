package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzfc implements zzgn {
    private static final zzfc zza = new zzfc();

    private zzfc() {
    }

    public static zzfc zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final boolean zza(Class<?> cls) {
        return zzfe.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final zzgk zzb(Class<?> cls) {
        if (!zzfe.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzgk) zzfe.zza(cls.asSubclass(zzfe.class)).zza(zzfe.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
