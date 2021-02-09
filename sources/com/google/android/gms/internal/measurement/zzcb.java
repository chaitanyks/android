package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzcb extends ContentObserver {
    private final /* synthetic */ zzbz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcb(zzbz zzbz, Handler handler) {
        super(null);
        this.zza = zzbz;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
