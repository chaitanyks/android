package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzjj implements Runnable {
    private final /* synthetic */ zzet zza;
    private final /* synthetic */ zzjk zzb;

    zzjj(zzjk zzjk, zzet zzet) {
        this.zzb = zzjk;
        this.zza = zzet;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
