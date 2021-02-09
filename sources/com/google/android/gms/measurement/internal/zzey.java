package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzkv;
import com.google.android.gms.internal.measurement.zzln;
import com.google.android.gms.internal.measurement.zznd;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzey extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzey(zzgf zzgf, long j) {
        super(zzgf);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zze
    public final boolean zzz() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0245 A[Catch:{ IllegalStateException -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0247 A[Catch:{ IllegalStateException -> 0x02be }] */
    @Override // com.google.android.gms.measurement.internal.zze
    public final void zzaa() {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        String googleAppId;
        String str2;
        String packageName = zzn().getPackageName();
        PackageManager packageManager = zzn().getPackageManager();
        String str3 = "Unknown";
        String str4 = "";
        String str5 = EnvironmentCompat.MEDIA_UNKNOWN;
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            zzr().zzf().zza("PackageManager is null, app identity information might be inaccurate. appId", zzfb.zza(packageName));
            str = str3;
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzr().zzf().zza("Error retrieving app installer package name. appId", zzfb.zza(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = str4;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(zzn().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str = applicationLabel.toString();
                    } else {
                        str = str3;
                    }
                    try {
                        str3 = packageInfo.versionName;
                        i = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException e2) {
                        str2 = str3;
                        str3 = str;
                    }
                } else {
                    str = str3;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                str2 = str3;
                zzr().zzf().zza("Error retrieving package info. appId, appName", zzfb.zza(packageName), str3);
                str = str3;
                str3 = str2;
                this.zza = packageName;
                this.zzd = str5;
                this.zzb = str3;
                this.zzc = i;
                this.zze = str;
                this.zzf = 0;
                zzu();
                Status initialize = GoogleServices.initialize(zzn());
                boolean z4 = true;
                if (initialize == null) {
                }
                if (TextUtils.isEmpty(this.zzx.zzo())) {
                }
                z2 = r6 | z;
                if (!z2) {
                }
                if (z2) {
                }
                this.zzj = str4;
                this.zzk = str4;
                this.zzl = str4;
                zzu();
                if (z) {
                }
                googleAppId = GoogleServices.getGoogleAppId();
                this.zzj = !TextUtils.isEmpty(googleAppId) ? str4 : googleAppId;
                if (!zzln.zzb()) {
                }
                if (!TextUtils.isEmpty(googleAppId)) {
                }
                if (z3) {
                }
                this.zzh = null;
                if (zzt().zza(zzap.zzbj)) {
                }
                if (Build.VERSION.SDK_INT >= 16) {
                }
            }
        }
        this.zza = packageName;
        this.zzd = str5;
        this.zzb = str3;
        this.zzc = i;
        this.zze = str;
        this.zzf = 0;
        zzu();
        Status initialize2 = GoogleServices.initialize(zzn());
        boolean z42 = true;
        boolean z5 = initialize2 == null && initialize2.isSuccess();
        z = TextUtils.isEmpty(this.zzx.zzo()) && "am".equals(this.zzx.zzp());
        z2 = z5 | z;
        if (!z2) {
            if (initialize2 == null) {
                zzr().zzg().zza("GoogleService failed to initialize (no status)");
            } else {
                zzr().zzg().zza("GoogleService failed to initialize, status", Integer.valueOf(initialize2.getStatusCode()), initialize2.getStatusMessage());
            }
        }
        if (z2) {
            z3 = false;
        } else if (!zzkv.zzb() || !zzt().zza(zzap.zzcw)) {
            Boolean zzh2 = zzt().zzh();
            if (zzt().zzg()) {
                if (this.zzx.zzl()) {
                    zzr().zzv().zza("Collection disabled with firebase_analytics_collection_deactivated=1");
                }
            } else if (zzh2 == null || zzh2.booleanValue()) {
                if (zzh2 != null || !GoogleServices.isMeasurementExplicitlyDisabled()) {
                    zzr().zzx().zza("Collection enabled");
                    z3 = true;
                } else {
                    zzr().zzv().zza("Collection disabled with google_app_measurement_enable=0");
                }
            } else if (this.zzx.zzl()) {
                zzr().zzv().zza("Collection disabled with firebase_analytics_collection_enabled=0");
            }
            z3 = false;
        } else {
            int zzac = this.zzx.zzac();
            switch (zzac) {
                case 0:
                    zzr().zzx().zza("App measurement collection enabled");
                    break;
                case 1:
                    zzr().zzv().zza("App measurement deactivated via the manifest");
                    break;
                case 2:
                    zzr().zzx().zza("App measurement deactivated via the init parameters");
                    break;
                case 3:
                    zzr().zzv().zza("App measurement disabled by setMeasurementEnabled(false)");
                    break;
                case 4:
                    zzr().zzv().zza("App measurement disabled via the manifest");
                    break;
                case 5:
                    zzr().zzx().zza("App measurement disabled via the init parameters");
                    break;
                case 6:
                    zzr().zzk().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                    break;
                case 7:
                    zzr().zzv().zza("App measurement disabled via the global data collection setting");
                    break;
                default:
                    zzr().zzv().zza("App measurement disabled");
                    zzr().zzg().zza("Invalid scion state in identity");
                    break;
            }
            z3 = zzac == 0;
        }
        this.zzj = str4;
        this.zzk = str4;
        this.zzl = str4;
        zzu();
        if (z) {
            this.zzk = this.zzx.zzo();
        }
        try {
            googleAppId = GoogleServices.getGoogleAppId();
            this.zzj = !TextUtils.isEmpty(googleAppId) ? str4 : googleAppId;
            if (!zzln.zzb() && zzt().zza(zzap.zzcf)) {
                StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(zzn());
                String string = stringResourceValueReader.getString("ga_app_id");
                if (!TextUtils.isEmpty(string)) {
                    str4 = string;
                }
                this.zzl = str4;
                if (!TextUtils.isEmpty(googleAppId) || !TextUtils.isEmpty(string)) {
                    this.zzk = stringResourceValueReader.getString("admob_app_id");
                }
            } else if (!TextUtils.isEmpty(googleAppId)) {
                this.zzk = new StringResourceValueReader(zzn()).getString("admob_app_id");
            }
            if (z3) {
                zzr().zzx().zza("App measurement enabled for app package, google app id", this.zza, TextUtils.isEmpty(this.zzj) ? this.zzk : this.zzj);
            }
        } catch (IllegalStateException e4) {
            zzr().zzf().zza("Fetching Google App Id failed with exception. appId", zzfb.zza(packageName), e4);
        }
        this.zzh = null;
        if (zzt().zza(zzap.zzbj)) {
            zzu();
            List<String> zzc2 = zzt().zzc("analytics.safelisted_events");
            if (zzc2 != null) {
                if (zzc2.size() == 0) {
                    zzr().zzk().zza("Safelisted event list is empty. Ignoring");
                    z42 = false;
                } else {
                    Iterator<String> it = zzc2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!zzp().zzb("safelisted event", it.next())) {
                                z42 = false;
                            }
                        }
                    }
                }
            }
            if (z42) {
                this.zzh = zzc2;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.zzi = 0;
        } else if (packageManager != null) {
            this.zzi = InstantApps.isInstantApp(zzn()) ? 1 : 0;
        } else {
            this.zzi = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final zzm zza(String str) {
        String str2;
        Boolean bool;
        List<String> list;
        Boolean zzb2;
        zzd();
        zzb();
        String zzab = zzab();
        String zzac = zzac();
        zzw();
        String str3 = this.zzb;
        long zzaf = (long) zzaf();
        zzw();
        String str4 = this.zzd;
        long zze2 = zzt().zze();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzx.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zzab2 = this.zzx.zzab();
        boolean z = !zzs().zzs;
        zzd();
        zzb();
        if (!this.zzx.zzab()) {
            str2 = null;
        } else {
            str2 = zzai();
        }
        long zzad = this.zzx.zzad();
        int zzag = zzag();
        boolean booleanValue = zzt().zzi().booleanValue();
        zzx zzt = zzt();
        zzt.zzb();
        Boolean zzb3 = zzt.zzb("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzb3 == null || zzb3.booleanValue()).booleanValue();
        zzfo zzs = zzs();
        zzs.zzd();
        boolean z2 = zzs.zzg().getBoolean("deferred_analytics_collection", false);
        String zzad2 = zzad();
        if (!zzt().zza(zzap.zzaz) || (zzb2 = zzt().zzb("google_analytics_default_allow_ad_personalization_signals")) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(!zzb2.booleanValue());
        }
        long j2 = this.zzg;
        if (zzt().zza(zzap.zzbj)) {
            list = this.zzh;
        } else {
            list = null;
        }
        return new zzm(zzab, zzac, str3, zzaf, str4, zze2, j, str, zzab2, z, str2, 0, zzad, zzag, booleanValue, booleanValue2, z2, zzad2, bool, j2, list, (!zzln.zzb() || !zzt().zza(zzap.zzcf)) ? null : zzae());
    }

    private final String zzai() {
        if (!zznd.zzb() || !zzt().zza(zzap.zzci)) {
            try {
                Class<?> loadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception e) {
                        zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception e2) {
                    zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException e3) {
                return null;
            }
        } else {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzab() {
        zzw();
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzw();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzw();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzae() {
        zzw();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzaf() {
        zzw();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzag() {
        zzw();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzah() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhk zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzey zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzex zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzjt zzk() {
        return super.zzk();
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
