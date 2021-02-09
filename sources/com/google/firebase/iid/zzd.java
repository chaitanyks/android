package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final /* synthetic */ class zzd implements ThreadFactory {
    static final ThreadFactory zza = new zzd();

    private zzd() {
    }

    public final Thread newThread(Runnable runnable) {
        return zza.zza(runnable);
    }
}
