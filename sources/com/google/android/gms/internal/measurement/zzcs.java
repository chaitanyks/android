package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzcs implements zzcd {
    private static final Map<String, zzcs> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new zzcv(this);
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    private final List<zzca> zzf = new ArrayList();

    static zzcs zza(Context context, String str) {
        boolean z;
        zzcs zzcs;
        if (!zzbw.zza() || str.startsWith("direct_boot:")) {
            z = true;
        } else {
            z = zzbw.zza(context);
        }
        if (!z) {
            return null;
        }
        synchronized (zzcs.class) {
            zzcs = zza.get(str);
            if (zzcs == null) {
                zzcs = new zzcs(zzb(context, str));
                zza.put(str, zzcs);
            }
        }
        return zzcs;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzbw.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private zzcs(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.internal.measurement.zzcd
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void zza() {
        synchronized (zzcs.class) {
            for (zzcs zzcs : zza.values()) {
                zzcs.zzb.unregisterOnSharedPreferenceChangeListener(zzcs.zzc);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcn.zza();
        }
        synchronized (this) {
            for (zzca zzca : this.zzf) {
                zzca.zza();
            }
        }
    }
}
