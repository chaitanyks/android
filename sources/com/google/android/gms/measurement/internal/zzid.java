package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzlt;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzid implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhk zza;

    private zzid(zzhk zzhk) {
        this.zza = zzhk;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            this.zza.zzr().zzx().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    this.zza.zzi().zza(activity, bundle);
                    return;
                }
                this.zza.zzp();
                if (zzkv.zza(intent)) {
                    str = "gs";
                } else {
                    str = "auto";
                }
                String queryParameter = data.getQueryParameter("referrer");
                boolean z = bundle == null;
                if (!zzlt.zzb() || !zzap.zzcb.zza(null).booleanValue()) {
                    zza(z, data, str, queryParameter);
                } else {
                    this.zza.zzq().zza(new zzig(this, z, data, str, queryParameter));
                }
                this.zza.zzi().zza(activity, bundle);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(boolean z, Uri uri, String str, String str2) {
        Bundle bundle;
        Bundle bundle2;
        try {
            if (this.zza.zzt().zza(zzap.zzby) || this.zza.zzt().zza(zzap.zzca) || this.zza.zzt().zza(zzap.zzbz)) {
                zzkv zzp = this.zza.zzp();
                if (TextUtils.isEmpty(str2)) {
                    bundle = null;
                } else if (str2.contains("gclid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium")) {
                    String valueOf = String.valueOf(str2);
                    bundle = zzp.zza(Uri.parse(valueOf.length() != 0 ? "https://google.com/search?".concat(valueOf) : new String("https://google.com/search?")));
                    if (bundle != null) {
                        bundle.putString("_cis", "referrer");
                    }
                } else {
                    zzp.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                    bundle = null;
                }
            } else {
                bundle = null;
            }
            boolean z2 = false;
            if (z) {
                bundle2 = this.zza.zzp().zza(uri);
                if (bundle2 != null) {
                    bundle2.putString("_cis", "intent");
                    if (this.zza.zzt().zza(zzap.zzby) && !bundle2.containsKey("gclid") && bundle != null && bundle.containsKey("gclid")) {
                        bundle2.putString("_cer", String.format("gclid=%s", bundle.getString("gclid")));
                    }
                    this.zza.zza(str, "_cmp", bundle2);
                }
            } else {
                bundle2 = null;
            }
            if (this.zza.zzt().zza(zzap.zzca) && !this.zza.zzt().zza(zzap.zzbz) && bundle != null && bundle.containsKey("gclid") && (bundle2 == null || !bundle2.containsKey("gclid"))) {
                this.zza.zza("auto", "_lgclid", (Object) bundle.getString("gclid"), true);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzr().zzw().zza("Activity created with referrer", str2);
                if (this.zza.zzt().zza(zzap.zzbz)) {
                    if (bundle != null) {
                        this.zza.zza(str, "_cmp", bundle);
                    } else {
                        this.zza.zzr().zzw().zza("Referrer does not contain valid parameters", str2);
                    }
                    this.zza.zza("auto", "_ldl", (Object) null, true);
                    return;
                }
                if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                    z2 = true;
                }
                if (!z2) {
                    this.zza.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                } else if (!TextUtils.isEmpty(str2)) {
                    this.zza.zza("auto", "_ldl", (Object) str2, true);
                }
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzjt zzk = this.zza.zzk();
        zzk.zzq().zza(new zzjv(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        if (!zzlc.zzb() || !zzap.zzau.zza(null).booleanValue()) {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
            return;
        }
        this.zza.zzk().zzab();
        this.zza.zzi().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzid(zzhk zzhk, zzhm zzhm) {
        this(zzhk);
    }
}
