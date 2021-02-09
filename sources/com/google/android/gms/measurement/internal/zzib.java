package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzib implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhk zzb;

    zzib(zzhk zzhk, long j) {
        this.zzb = zzhk;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzk.zza(this.zza);
        this.zzb.zzr().zzw().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
