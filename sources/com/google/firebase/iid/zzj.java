package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final /* synthetic */ class zzj implements zzap {
    private final FirebaseInstanceId zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    zzj(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.zza = firebaseInstanceId;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    @Override // com.google.firebase.iid.zzap
    public final Task zza() {
        return this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
