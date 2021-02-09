package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.2 */
public final /* synthetic */ class zza implements Executor {
    static final Executor zza = new zza();

    private zza() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
