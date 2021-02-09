package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzkm implements Runnable {
    private final /* synthetic */ zzkp zza;
    private final /* synthetic */ zzkj zzb;

    zzkm(zzkj zzkj, zzkp zzkp) {
        this.zzb = zzkj;
        this.zza = zzkp;
    }

    public final void run() {
        this.zzb.zza((zzkj) this.zza);
        this.zzb.zza();
    }
}
