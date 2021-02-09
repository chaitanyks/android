package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final /* synthetic */ class zzkc implements Runnable {
    private final zzjz zza;

    zzkc(zzjz zzjz) {
        this.zza = zzjz;
    }

    public final void run() {
        zzjz zzjz = this.zza;
        zzjy zzjy = zzjz.zzb;
        long j = zzjz.zza;
        zzjy.zza.zzd();
        zzjy.zza.zzr().zzw().zza("Application going to the background");
        zzjy.zza.zzf().zza("auto", "_ab", j, new Bundle());
    }
}
