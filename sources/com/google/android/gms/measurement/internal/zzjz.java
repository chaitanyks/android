package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjz implements Runnable {
    long zza;
    final /* synthetic */ zzjy zzb;

    zzjz(zzjy zzjy, long j) {
        this.zzb = zzjy;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza.zzq().zza(new zzkc(this));
    }
}
