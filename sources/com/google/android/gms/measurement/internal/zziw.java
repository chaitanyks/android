package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziw implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzis zzb;

    zziw(zzis zzis, zzm zzm) {
        this.zzb = zzis;
        this.zza = zzm;
    }

    public final void run() {
        zzet zzet = this.zzb.zzb;
        if (zzet == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzet.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaj();
    }
}
