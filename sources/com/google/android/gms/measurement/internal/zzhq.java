package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzhq implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhk zzb;

    zzhq(zzhk zzhk, AtomicReference atomicReference) {
        this.zzb = zzhk;
        this.zza = atomicReference;
    }

    public final void run() {
        this.zzb.zzh().zza(this.zza);
    }
}
