package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjt zzb;

    zzjw(zzjt zzjt, long j) {
        this.zzb = zzjt;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza((zzjt) this.zza);
    }
}
