package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgs implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ zzm zzb;
    private final /* synthetic */ zzgk zzc;

    zzgs(zzgk zzgk, zzan zzan, zzm zzm) {
        this.zzc = zzgk;
        this.zza = zzan;
        this.zzb = zzm;
    }

    public final void run() {
        zzan zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
