package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzgh implements Runnable {
    private final /* synthetic */ zzhh zza;
    private final /* synthetic */ zzgf zzb;

    zzgh(zzgf zzgf, zzhh zzhh) {
        this.zzb = zzgf;
        this.zza = zzhh;
    }

    public final void run() {
        this.zzb.zza((zzgf) this.zza);
        this.zzb.zza();
    }
}
