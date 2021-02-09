package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziy implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzis zzc;

    zziy(zzis zzis, zzm zzm, zzn zzn) {
        this.zzc = zzis;
        this.zza = zzm;
        this.zzb = zzn;
    }

    public final void run() {
        try {
            zzet zzet = this.zzc.zzb;
            if (zzet == null) {
                this.zzc.zzr().zzf().zza("Failed to get app instance id");
                return;
            }
            String zzc2 = zzet.zzc(this.zza);
            if (zzc2 != null) {
                this.zzc.zzf().zza(zzc2);
                this.zzc.zzs().zzj.zza(zzc2);
            }
            this.zzc.zzaj();
            this.zzc.zzp().zza(this.zzb, zzc2);
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzp().zza(this.zzb, (String) null);
        }
    }
}
