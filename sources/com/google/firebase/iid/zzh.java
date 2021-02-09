package com.google.firebase.iid;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final /* synthetic */ class zzh implements Runnable {
    private final FirebaseInstanceId zza;

    zzh(FirebaseInstanceId firebaseInstanceId) {
        this.zza = firebaseInstanceId;
    }

    public final void run() {
        this.zza.zzi();
    }
}
