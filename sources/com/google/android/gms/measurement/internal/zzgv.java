package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgv implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgk zzb;

    zzgv(zzgk zzgk, zzm zzm) {
        this.zzb = zzgk;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
