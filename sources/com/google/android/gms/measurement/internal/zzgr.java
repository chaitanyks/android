package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgr implements Runnable {
    private final /* synthetic */ zzan zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgk zzc;

    zzgr(zzgk zzgk, zzan zzan, String str) {
        this.zzc = zzgk;
        this.zza = zzan;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
