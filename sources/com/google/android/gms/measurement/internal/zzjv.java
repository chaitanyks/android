package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzjv implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjt zzb;

    zzjv(zzjt zzjt, long j) {
        this.zzb = zzjt;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb((zzjt) this.zza);
    }
}
