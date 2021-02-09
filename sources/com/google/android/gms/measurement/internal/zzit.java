package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzit implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzis zzd;

    zzit(zzis zzis, AtomicReference atomicReference, zzm zzm, boolean z) {
        this.zzd = zzis;
        this.zza = atomicReference;
        this.zzb = zzm;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzet zzet = this.zzd.zzb;
                if (zzet == null) {
                    this.zzd.zzr().zzf().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                this.zza.set(zzet.zza(this.zzb, this.zzc));
                this.zzd.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzd.zzr().zzf().zza("Failed to get all user properties; remote exception", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
