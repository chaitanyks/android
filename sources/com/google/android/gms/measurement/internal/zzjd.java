package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjd implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzv zzc;
    private final /* synthetic */ zzm zzd;
    private final /* synthetic */ zzv zze;
    private final /* synthetic */ zzis zzf;

    zzjd(zzis zzis, boolean z, boolean z2, zzv zzv, zzm zzm, zzv zzv2) {
        this.zzf = zzis;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzv;
        this.zzd = zzm;
        this.zze = zzv2;
    }

    public final void run() {
        zzet zzet = this.zzf.zzb;
        if (zzet == null) {
            this.zzf.zzr().zzf().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzet, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzet.zza(this.zzc, this.zzd);
                } else {
                    zzet.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzr().zzf().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
