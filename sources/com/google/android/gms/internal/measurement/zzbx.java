package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzbx extends ContentObserver {
    zzbx(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzbv.zza().set(true);
    }
}
