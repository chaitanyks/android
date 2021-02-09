package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgm implements Runnable {
    private final /* synthetic */ zzv zza;
    private final /* synthetic */ zzgk zzb;

    zzgm(zzgk zzgk, zzv zzv) {
        this.zzb = zzgk;
        this.zza = zzv;
    }

    public final void run() {
        this.zzb.zza.zzo();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
