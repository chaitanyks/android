package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final /* synthetic */ class zzcv implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzcs zza;

    zzcv(zzcs zzcs) {
        this.zza = zzcs;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
