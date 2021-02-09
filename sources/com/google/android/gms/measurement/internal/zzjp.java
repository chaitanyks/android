package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final /* synthetic */ class zzjp implements Runnable {
    private final zzjq zza;
    private final int zzb;
    private final zzfb zzc;
    private final Intent zzd;

    zzjp(zzjq zzjq, int i, zzfb zzfb, Intent intent) {
        this.zza = zzjq;
        this.zzb = i;
        this.zzc = zzfb;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
