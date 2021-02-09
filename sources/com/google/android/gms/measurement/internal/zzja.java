package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzja implements Runnable {
    private final /* synthetic */ zzio zza;
    private final /* synthetic */ zzis zzb;

    zzja(zzis zzis, zzio zzio) {
        this.zzb = zzis;
        this.zza = zzio;
    }

    public final void run() {
        zzet zzet = this.zzb.zzb;
        if (zzet == null) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzet.zza(0, (String) null, (String) null, this.zzb.zzn().getPackageName());
            } else {
                zzet.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzn().getPackageName());
            }
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send current screen to the service", e);
        }
    }
}
