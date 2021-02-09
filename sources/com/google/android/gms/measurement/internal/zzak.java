package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzak {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzam zze;
    private final String zzf;

    private zzak(zzgf zzgf, String str, String str2, String str3, long j, long j2, zzam zzam) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzam);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgf.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId, name", zzfb.zza(str2), zzfb.zza(str3));
        }
        this.zze = zzam;
    }

    zzak(zzgf zzgf, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzgf.zzr().zzi().zza("Event created with reverse previous/current timestamps. appId", zzfb.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzgf.zzr().zzf().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzgf.zzi().zza(next, bundle2.get(next));
                    if (zza2 == null) {
                        zzgf.zzr().zzi().zza("Param value can't be null", zzgf.zzj().zzb(next));
                        it.remove();
                    } else {
                        zzgf.zzi().zza(bundle2, next, zza2);
                    }
                }
            }
            zzam = new zzam(bundle2);
        }
        this.zze = zzam;
    }

    /* access modifiers changed from: package-private */
    public final zzak zza(zzgf zzgf, long j) {
        return new zzak(zzgf, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
