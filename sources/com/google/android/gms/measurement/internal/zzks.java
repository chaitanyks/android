package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzks {
    final String zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final Object zze;

    zzks(String str, String str2, String str3, long j, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
        this.zze = obj;
    }
}
