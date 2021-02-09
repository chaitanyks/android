package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzip implements Runnable {
    private final /* synthetic */ zzio zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzin zzc;

    zzip(zzin zzin, zzio zzio, long j) {
        this.zzc = zzin;
        this.zza = zzio;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza((zzin) this.zza, (zzio) false, (boolean) this.zzb);
        this.zzc.zza = null;
        this.zzc.zzh().zza((zzio) null);
    }
}
