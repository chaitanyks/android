package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzjm implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjk zzb;

    zzjm(zzjk zzjk, ComponentName componentName) {
        this.zzb = zzjk;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza((zzis) this.zza);
    }
}
