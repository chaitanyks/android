package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzfy implements Runnable {
    private final /* synthetic */ zzgf zza;
    private final /* synthetic */ zzfb zzb;

    zzfy(zzfv zzfv, zzgf zzgf, zzfb zzfb) {
        this.zza = zzgf;
        this.zzb = zzfb;
    }

    public final void run() {
        if (this.zza.zzf() == null) {
            this.zzb.zzf().zza("Install Referrer Reporter is null");
        } else {
            this.zza.zzf().zza();
        }
    }
}
