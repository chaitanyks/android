package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziu implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkq zzb;
    private final /* synthetic */ zzm zzc;
    private final /* synthetic */ zzis zzd;

    zziu(zzis zzis, boolean z, zzkq zzkq, zzm zzm) {
        this.zzd = zzis;
        this.zza = z;
        this.zzb = zzkq;
        this.zzc = zzm;
    }

    public final void run() {
        zzet zzet = this.zzd.zzb;
        if (zzet == null) {
            this.zzd.zzr().zzf().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzet, this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzaj();
    }
}
