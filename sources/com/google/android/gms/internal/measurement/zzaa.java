package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.2 */
public final class zzaa extends zzx.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzx zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaa(zzx zzx, String str, String str2, Context context, Bundle bundle) {
        super(zzx);
        this.zzg = zzx;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063 A[Catch:{ Exception -> 0x00a3 }] */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    public final void zza() {
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        int i;
        try {
            this.zzg.zzf = new ArrayList();
            zzx zzx = this.zzg;
            if (zzx.zzc(this.zzc, this.zzd)) {
                String str4 = this.zzd;
                str2 = this.zzc;
                str = str4;
                str3 = this.zzg.zzc;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            zzx.zzi(this.zze);
            if (!zzx.zzi.booleanValue()) {
                if (str2 == null) {
                    z = false;
                    this.zzg.zzr = this.zzg.zza(this.zze, z);
                    if (this.zzg.zzr != null) {
                        Log.w(this.zzg.zzc, "Failed to connect to measurement client.");
                        return;
                    }
                    int i2 = zzx.zzh(this.zze);
                    int i3 = zzx.zzg(this.zze);
                    if (z) {
                        i = Math.max(i2, i3);
                        z2 = i3 < i2;
                    } else {
                        if (i2 > 0) {
                            i3 = i2;
                        }
                        z2 = i2 > 0;
                        i = i3;
                    }
                    this.zzg.zzr.initialize(ObjectWrapper.wrap(this.zze), new zzv(21028, (long) i, z2, str3, str2, str, this.zzf), this.zza);
                    return;
                }
            }
            z = true;
            this.zzg.zzr = this.zzg.zza(this.zze, z);
            if (this.zzg.zzr != null) {
            }
        } catch (Exception e) {
            this.zzg.zza((zzx) e, (Exception) true, false);
        }
    }
}
