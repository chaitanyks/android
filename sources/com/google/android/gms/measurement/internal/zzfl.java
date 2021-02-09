package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzfl implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfm zzb;

    zzfl(zzfm zzfm, boolean z) {
        this.zzb = zzfm;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
