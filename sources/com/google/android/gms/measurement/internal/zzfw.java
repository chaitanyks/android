package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzfw implements Runnable {
    private final /* synthetic */ zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzft zzc;

    zzfw(zzft zzft, zzd zzd, ServiceConnection serviceConnection) {
        this.zzc = zzft;
        this.zza = zzd;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzfu zzfu = this.zzc.zza;
        String str = this.zzc.zzb;
        zzd zzd = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza2 = zzfu.zza(str, zzd);
        zzfu.zza.zzq().zzd();
        if (zza2 != null) {
            long j = zza2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzfu.zza.zzr().zzf().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfu.zza.zzr().zzf().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfu.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    zzkv zzi = zzfu.zza.zzi();
                    String valueOf = String.valueOf(string);
                    Bundle zza3 = zzi.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza3 == null) {
                        zzfu.zza.zzr().zzf().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza3.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzfu.zza.zzr().zzf().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfu.zza.zzc().zzi.zza()) {
                            zzfu.zza.zzu();
                            zzfu.zza.zzr().zzx().zza("Install Referrer campaign has already been logged");
                        } else if (!zzkj.zzb() || !zzfu.zza.zzb().zza(zzap.zzcv) || zzfu.zza.zzab()) {
                            zzfu.zza.zzc().zzi.zza(j);
                            zzfu.zza.zzu();
                            zzfu.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza3.putString("_cis", "referrer API");
                            zzfu.zza.zzh().zza("auto", "_cmp", zza3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfu.zza.zzn(), serviceConnection);
        }
    }
}
