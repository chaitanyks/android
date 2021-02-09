package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzis zzc;

    zziv(zzis zzis, AtomicReference atomicReference, zzm zzm) {
        this.zzc = zzis;
        this.zza = atomicReference;
        this.zzb = zzm;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzet zzet = this.zzc.zzb;
                if (zzet == null) {
                    this.zzc.zzr().zzf().zza("Failed to get app instance id");
                    return;
                }
                this.zza.set(zzet.zzc(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzf().zza(str);
                    this.zzc.zzs().zzj.zza(str);
                }
                this.zzc.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
