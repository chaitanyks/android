package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzhu implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhk zzb;

    zzhu(zzhk zzhk, Bundle bundle) {
        this.zzb = zzhk;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzd((zzhk) this.zza);
    }
}
