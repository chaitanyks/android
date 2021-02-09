package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzhi;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.2 */
public final class zzax extends zzx.zza {
    private final /* synthetic */ zzhi zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzx zzx, zzhi zzhi) {
        super(zzx);
        this.zzd = zzx;
        this.zzc = zzhi;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                pair = (Pair) this.zzd.zzf.get(i);
                break;
            } else {
                i++;
            }
        }
        if (pair == null) {
            Log.w(this.zzd.zzc, "OnEventListener had not been registered.");
            return;
        }
        this.zzd.zzr.unregisterOnMeasurementEventListener((zzs) pair.second);
        this.zzd.zzf.remove(pair);
    }
}
