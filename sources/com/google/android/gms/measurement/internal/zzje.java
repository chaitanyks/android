package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzje implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzan zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzis zzf;

    zzje(zzis zzis, boolean z, boolean z2, zzan zzan, zzm zzm, String str) {
        this.zzf = zzis;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzan;
        this.zzd = zzm;
        this.zze = str;
    }

    public final void run() {
        zzet zzet = this.zzf.zzb;
        if (zzet == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzet, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzet.zza(this.zzc, this.zzd);
                } else {
                    zzet.zza(this.zzc, this.zze, this.zzf.zzr().zzy());
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
