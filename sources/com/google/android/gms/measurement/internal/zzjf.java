package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjf implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzis zze;

    zzjf(zzis zzis, String str, String str2, zzm zzm, zzn zzn) {
        this.zze = zzis;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzm;
        this.zzd = zzn;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzet zzet = this.zze.zzb;
            if (zzet == null) {
                this.zze.zzr().zzf().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            ArrayList<Bundle> zzb2 = zzkv.zzb(zzet.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzaj();
            this.zze.zzp().zza(this.zzd, zzb2);
        } catch (RemoteException e) {
            this.zze.zzr().zzf().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzp().zza(this.zzd, arrayList);
        }
    }
}
