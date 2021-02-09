package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzhf;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.2 */
public final class zzaj extends zzx.zza {
    private final /* synthetic */ zzhf zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzx zzx, zzhf zzhf) {
        super(zzx);
        this.zzd = zzx;
        this.zzc = zzhf;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zza() throws RemoteException {
        this.zzd.zzr.setEventInterceptor(new zzx.zzc(this.zzc));
    }
}
