package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final /* synthetic */ class zzz implements Handler.Callback {
    private final zzw zza;

    zzz(zzw zzw) {
        this.zza = zzw;
    }

    public final boolean handleMessage(Message message) {
        return this.zza.zza(message);
    }
}
