package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzfo extends zzgz {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private boolean zzaa;
    private long zzab;
    public zzfs zzb;
    public final zzfp zzc = new zzfp(this, "last_upload", 0);
    public final zzfp zzd = new zzfp(this, "last_upload_attempt", 0);
    public final zzfp zze = new zzfp(this, "backoff", 0);
    public final zzfp zzf = new zzfp(this, "last_delete_stale", 0);
    public final zzfp zzg = new zzfp(this, "midnight_offset", 0);
    public final zzfp zzh = new zzfp(this, "first_open_time", 0);
    public final zzfp zzi = new zzfp(this, "app_install_time", 0);
    public final zzfr zzj = new zzfr(this, "app_instance_id", null);
    public final zzfp zzk = new zzfp(this, "time_before_start", 10000);
    public final zzfp zzl = new zzfp(this, "session_timeout", 1800000);
    public final zzfq zzm = new zzfq(this, "start_new_session", true);
    public final zzfr zzn = new zzfr(this, "non_personalized_ads", null);
    public final zzfq zzo = new zzfq(this, "use_dynamite_api", false);
    public final zzfq zzp = new zzfq(this, "allow_remote_dynamite", false);
    public final zzfp zzq = new zzfp(this, "last_pause_time", 0);
    public final zzfp zzr = new zzfp(this, "time_active", 0);
    public boolean zzs;
    public zzfq zzt = new zzfq(this, "app_backgrounded", false);
    public zzfq zzu = new zzfq(this, "deep_link_retrieval_complete", false);
    public zzfp zzv = new zzfp(this, "deep_link_retrieval_attempts", 0);
    public final zzfr zzw = new zzfr(this, "firebase_feature_rollouts", null);
    private SharedPreferences zzy;
    private String zzz;

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        if (this.zzz != null && elapsedRealtime < this.zzab) {
            return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
        }
        this.zzab = elapsedRealtime + zzt().zza(str, zzap.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzz = advertisingIdInfo.getId();
                this.zzaa = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzz == null) {
                this.zzz = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzz = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
    }

    /* access modifiers changed from: package-private */
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi2 = zzkv.zzi();
        if (zzi2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzi2.digest(str2.getBytes())));
    }

    zzfo(zzgf zzgf) {
        super(zzgf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzgz
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzgz
    public final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzy = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzs = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzy.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzfs(this, "health_monitor", Math.max(0L, zzap.zzb.zza(null).longValue()));
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzy;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", null);
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj() {
        zzd();
        if (!zzg().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzg().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        zzd();
        Boolean zzv2 = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv2 != null) {
            zzb(zzv2.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        return this.zzy.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }
}
