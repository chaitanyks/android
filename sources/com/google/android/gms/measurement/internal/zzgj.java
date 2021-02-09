package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgj implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgk zzb;

    zzgj(zzgk zzgk, zzm zzm) {
        this.zzb = zzgk;
        this.zza = zzm;
    }

    public final void run() {
        this.zzb.zza.zzo();
        zzkj zzkj = this.zzb.zza;
        zzm zzm = this.zza;
        zzkj.zzq().zzd();
        zzkj.zzk();
        Preconditions.checkNotEmpty(zzm.zza);
        zzkj.zzc(zzm);
    }
}
