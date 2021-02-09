package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.2 */
final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String str;
        String zza2 = FirebaseAnalytics.zza(this.zza);
        if (zza2 != null) {
            return zza2;
        }
        if (FirebaseAnalytics.zzb(this.zza)) {
            str = FirebaseAnalytics.zzc(this.zza).zzh();
        } else {
            str = FirebaseAnalytics.zzd(this.zza).zzh().zzc(120000);
        }
        if (str != null) {
            FirebaseAnalytics.zza(this.zza, str);
            return str;
        }
        throw new TimeoutException();
    }
}
