package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final /* synthetic */ class zzhj implements Runnable {
    private final zzhk zza;

    zzhj(zzhk zzhk) {
        this.zza = zzhk;
    }

    public final void run() {
        zzhk zzhk = this.zza;
        zzhk.zzd();
        if (zzhk.zzs().zzu.zza()) {
            zzhk.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhk.zzs().zzv.zza();
        zzhk.zzs().zzv.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhk.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhk.zzs().zzu.zza(true);
            return;
        }
        zzhk.zzx.zzai();
    }
}
