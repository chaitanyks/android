package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzjo implements Runnable {
    private final /* synthetic */ zzjk zza;

    zzjo(zzjk zzjk) {
        this.zza = zzjk;
    }

    public final void run() {
        zzis zzis = this.zza.zza;
        Context zzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzis.zza((zzis) new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
