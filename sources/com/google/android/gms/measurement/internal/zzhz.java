package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzhz implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhk zzb;

    zzhz(zzhk zzhk, boolean z) {
        this.zzb = zzhk;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzd((zzhk) this.zza);
    }
}
