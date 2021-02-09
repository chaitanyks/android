package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-api@@17.2.2 */
public final class zzf implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzg zza;

    public zzf(zzg zzg) {
        this.zza = zzg;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzhi
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals("crash") && zzb.zzb(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.zza.zza.onMessageTriggered(3, bundle2);
        }
    }
}
