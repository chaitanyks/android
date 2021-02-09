package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzln;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzx extends zzha {
    private Boolean zza;
    private zzz zzb = zzaa.zza;
    private Boolean zzc;

    zzx(zzgf zzgf) {
        super(zzgf);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz) {
        this.zzb = zzz;
    }

    public final int zza(String str) {
        return zzb(str, zzap.zzn);
    }

    public final long zze() {
        zzu();
        return 21028;
    }

    public final boolean zzf() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final long zza(String str, zzeu<Long> zzeu) {
        if (str == null) {
            return zzeu.zza(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzeu.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzeu.zza(null).longValue();
        }
        try {
            return zzeu.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException e) {
            return zzeu.zza(null).longValue();
        }
    }

    public final int zzb(String str, zzeu<Integer> zzeu) {
        if (str == null) {
            return zzeu.zza(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzeu.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzeu.zza(null).intValue();
        }
        try {
            return zzeu.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException e) {
            return zzeu.zza(null).intValue();
        }
    }

    public final double zzc(String str, zzeu<Double> zzeu) {
        if (str == null) {
            return zzeu.zza(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzeu.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzeu.zza(null).doubleValue();
        }
        try {
            return zzeu.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException e) {
            return zzeu.zza(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzeu<Boolean> zzeu) {
        if (str == null) {
            return zzeu.zza(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzeu.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzeu.zza(null).booleanValue();
        }
        return zzeu.zza(Boolean.valueOf(Boolean.parseBoolean(zza2))).booleanValue();
    }

    public final boolean zze(String str, zzeu<Boolean> zzeu) {
        return zzd(str, zzeu);
    }

    public final boolean zza(zzeu<Boolean> zzeu) {
        return zzd(null, zzeu);
    }

    private final Bundle zzy() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzb(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzy = zzy();
        if (zzy == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzy.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzy.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzc(String str) {
        Integer num;
        Preconditions.checkNotEmpty(str);
        Bundle zzy = zzy();
        if (zzy == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            num = null;
        } else if (!zzy.containsKey(str)) {
            num = null;
        } else {
            num = Integer.valueOf(zzy.getInt(str));
        }
        if (num == null) {
            return null;
        }
        try {
            String[] stringArray = zzn().getResources().getStringArray(num.intValue());
            if (stringArray == null) {
                return null;
            }
            return Arrays.asList(stringArray);
        } catch (Resources.NotFoundException e) {
            zzr().zzf().zza("Failed to load string array from metadata: resource not found", e);
            return null;
        }
    }

    public final boolean zzg() {
        zzu();
        Boolean zzb2 = zzb("firebase_analytics_collection_deactivated");
        return zzb2 != null && zzb2.booleanValue();
    }

    public final Boolean zzh() {
        zzu();
        return zzb("firebase_analytics_collection_enabled");
    }

    public final Boolean zzi() {
        zzb();
        Boolean zzb2 = zzb("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzb2 == null || zzb2.booleanValue());
    }

    public static long zzj() {
        return zzap.zzac.zza(null).longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    public final String zza(zzg zzg) {
        Uri.Builder builder = new Uri.Builder();
        String zze = zzg.zze();
        if (TextUtils.isEmpty(zze)) {
            if (zzln.zzb() && zzt().zzd(zzg.zzc(), zzap.zzcf)) {
                zze = zzg.zzg();
            }
            zze = zzg.zzf();
        }
        Uri.Builder encodedAuthority = builder.scheme(zzap.zzd.zza(null)).encodedAuthority(zzap.zze.zza(null));
        String valueOf = String.valueOf(zze);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzg.zzd()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zze()));
        return builder.build().toString();
    }

    public static long zzk() {
        return zzap.zzc.zza(null).longValue();
    }

    public final String zzv() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzw() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final boolean zzd(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zze(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        return zzd(str, zzap.zzag);
    }

    /* access modifiers changed from: package-private */
    public final String zzg(String str) {
        zzeu<String> zzeu = zzap.zzah;
        if (str == null) {
            return zzeu.zza(null);
        }
        return zzeu.zza(this.zzb.zza(str, zzeu.zza()));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzb2 = zzb("app_measurement_lite");
            this.zza = zzb2;
            if (zzb2 == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzx.zzt()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzez zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzkv zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzgc zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfb zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfo zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
