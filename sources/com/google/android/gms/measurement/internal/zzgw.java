package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzgw implements Callable<List<zzks>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgk zzb;

    zzgw(zzgk zzgk, zzm zzm) {
        this.zzb = zzgk;
        this.zza = zzm;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzks> call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
