package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.2 */
public final class zzat extends zzx.zza {
    private final /* synthetic */ zzk zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzat(zzx zzx, zzk zzk) {
        super(zzx);
        this.zzd = zzx;
        this.zzc = zzk;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zza() throws RemoteException {
        this.zzd.zzr.getAppInstanceId(this.zzc);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
