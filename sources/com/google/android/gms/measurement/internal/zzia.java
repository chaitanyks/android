package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzia implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhk zzb;

    zzia(zzhk zzhk, AtomicReference atomicReference) {
        this.zzb = zzhk;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzt().zzc(this.zzb.zzg().zzab(), zzap.zzak)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
