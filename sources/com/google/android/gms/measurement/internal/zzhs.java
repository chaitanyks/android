package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzhs implements Runnable {
    private final /* synthetic */ zzhf zza;
    private final /* synthetic */ zzhk zzb;

    zzhs(zzhk zzhk, zzhf zzhf) {
        this.zzb = zzhk;
        this.zza = zzhf;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
