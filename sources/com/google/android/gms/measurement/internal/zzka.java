package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final /* synthetic */ class zzka implements Runnable {
    private final zzjy zza;

    zzka(zzjy zzjy) {
        this.zza = zzjy;
    }

    public final void run() {
        zzjy zzjy = this.zza;
        zzjy.zza.zzd();
        zzjy.zza.zzr().zzw().zza("Application backgrounded");
        zzjy.zza.zzf().zzb("auto", "_ab", new Bundle());
    }
}
