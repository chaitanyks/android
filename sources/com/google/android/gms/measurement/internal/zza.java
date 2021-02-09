package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zza implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzb zzc;

    zza(zzb zzb2, String str, long j) {
        this.zzc = zzb2;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzc(this.zza, this.zzb);
    }
}
