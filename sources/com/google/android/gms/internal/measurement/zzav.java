package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.2 */
public final class zzav extends zzx.zza {
    private final /* synthetic */ zzk zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzx zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzav(zzx zzx, zzk zzk, int i) {
        super(zzx);
        this.zze = zzx;
        this.zzc = zzk;
        this.zzd = i;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zza() throws RemoteException {
        this.zze.zzr.getTestFlag(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
