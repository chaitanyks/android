package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzlc;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzhp implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhk zzb;

    zzhp(zzhk zzhk, long j) {
        this.zzb = zzhk;
        this.zza = j;
    }

    public final void run() {
        zzhk zzhk = this.zzb;
        long j = this.zza;
        zzhk.zzd();
        zzhk.zzb();
        zzhk.zzw();
        zzhk.zzr().zzw().zza("Resetting analytics data (FE)");
        zzjt zzk = zzhk.zzk();
        zzk.zzd();
        zzk.zzb.zza();
        boolean zzab = zzhk.zzx.zzab();
        zzfo zzs = zzhk.zzs();
        zzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzs.zzs().zzw.zza())) {
            zzs.zzw.zza(null);
        }
        if (zzlc.zzb() && zzs.zzt().zza(zzap.zzcp)) {
            zzs.zzq.zza(0);
        }
        if (!zzs.zzt().zzg()) {
            zzs.zzc(!zzab);
        }
        zzhk.zzh().zzad();
        if (zzlc.zzb() && zzhk.zzt().zza(zzap.zzcp)) {
            zzhk.zzk().zza.zza();
        }
        zzhk.zzb = !zzab;
        this.zzb.zzh().zza(new AtomicReference<>());
    }
}
