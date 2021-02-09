package com.google.firebase.iid;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final /* synthetic */ class zzi implements SuccessContinuation {
    private final FirebaseInstanceId zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    zzi(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.zza = firebaseInstanceId;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, this.zzd, (String) obj);
    }
}
