package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzkl implements zzfh {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkj zzb;

    zzkl(zzkj zzkj, String str) {
        this.zzb = zzkj;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzfh
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
