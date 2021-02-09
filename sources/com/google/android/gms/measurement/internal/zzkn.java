package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzkn implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzkj zzb;

    zzkn(zzkj zzkj, zzm zzm) {
        this.zzb = zzkj;
        this.zza = zzm;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzg zzc = this.zzb.zzc(this.zza);
        if (zzc != null) {
            return zzc.zzd();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
