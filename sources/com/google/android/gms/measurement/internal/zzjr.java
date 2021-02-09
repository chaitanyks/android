package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzjr implements Runnable {
    private final /* synthetic */ zzkj zza;
    private final /* synthetic */ Runnable zzb;

    zzjr(zzjq zzjq, zzkj zzkj, Runnable runnable) {
        this.zza = zzkj;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
