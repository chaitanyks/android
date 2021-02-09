package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.2 */
public final class zzd implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zze zza;

    public zzd(zze zze) {
        this.zza = zze;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzhi
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzb.zze(str2));
            this.zza.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
