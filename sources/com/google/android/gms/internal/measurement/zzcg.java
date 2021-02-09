package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzcg extends ContentObserver {
    zzcg(zzce zzce, Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzcn.zza();
    }
}
