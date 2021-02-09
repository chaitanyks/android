package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziz implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzis zzd;

    zziz(zzis zzis, zzan zzan, String str, zzn zzn) {
        this.zzd = zzis;
        this.zza = zzan;
        this.zzb = str;
        this.zzc = zzn;
    }

    public final void run() {
        try {
            zzet zzet = this.zzd.zzb;
            if (zzet == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza2 = zzet.zza(this.zza, this.zzb);
            this.zzd.zzaj();
            this.zzd.zzp().zza(this.zzc, zza2);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, (byte[]) null);
        }
    }
}
