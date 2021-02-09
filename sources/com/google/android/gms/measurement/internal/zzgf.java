package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzkv;
import com.google.android.gms.internal.measurement.zzv;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public class zzgf implements zzhc {
    private static volatile zzgf zza;
    private long zzaa;
    private volatile Boolean zzab;
    private Boolean zzac;
    private Boolean zzad;
    private int zzae;
    private AtomicInteger zzaf = new AtomicInteger(0);
    private final long zzag;
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;
    private final zzw zzg;
    private final zzx zzh;
    private final zzfo zzi;
    private final zzfb zzj;
    private final zzgc zzk;
    private final zzjt zzl;
    private final zzkv zzm;
    private final zzez zzn;
    private final Clock zzo;
    private final zzin zzp;
    private final zzhk zzq;
    private final zzb zzr;
    private final zzii zzs;
    private zzex zzt;
    private zzis zzu;
    private zzah zzv;
    private zzey zzw;
    private zzfu zzx;
    private boolean zzy = false;
    private Boolean zzz;

    private zzgf(zzhh zzhh) {
        boolean z = false;
        Preconditions.checkNotNull(zzhh);
        zzw zzw2 = new zzw(zzhh.zza);
        this.zzg = zzw2;
        zzer.zza = zzw2;
        this.zzb = zzhh.zza;
        this.zzc = zzhh.zzb;
        this.zzd = zzhh.zzc;
        this.zze = zzhh.zzd;
        this.zzf = zzhh.zzh;
        this.zzab = zzhh.zze;
        zzv zzv2 = zzhh.zzg;
        if (!(zzv2 == null || zzv2.zzg == null)) {
            Object obj = zzv2.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzac = (Boolean) obj;
            }
            Object obj2 = zzv2.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzad = (Boolean) obj2;
            }
        }
        zzcn.zza(this.zzb);
        Clock instance = DefaultClock.getInstance();
        this.zzo = instance;
        this.zzag = instance.currentTimeMillis();
        this.zzh = new zzx(this);
        zzfo zzfo = new zzfo(this);
        zzfo.zzab();
        this.zzi = zzfo;
        zzfb zzfb = new zzfb(this);
        zzfb.zzab();
        this.zzj = zzfb;
        zzkv zzkv = new zzkv(this);
        zzkv.zzab();
        this.zzm = zzkv;
        zzez zzez = new zzez(this);
        zzez.zzab();
        this.zzn = zzez;
        this.zzr = new zzb(this);
        zzin zzin = new zzin(this);
        zzin.zzx();
        this.zzp = zzin;
        zzhk zzhk = new zzhk(this);
        zzhk.zzx();
        this.zzq = zzhk;
        zzjt zzjt = new zzjt(this);
        zzjt.zzx();
        this.zzl = zzjt;
        zzii zzii = new zzii(this);
        zzii.zzab();
        this.zzs = zzii;
        zzgc zzgc = new zzgc(this);
        zzgc.zzab();
        this.zzk = zzgc;
        if (!(zzhh.zzg == null || zzhh.zzg.zzb == 0)) {
            z = true;
        }
        boolean z2 = !z;
        if (this.zzb.getApplicationContext() instanceof Application) {
            zzhk zzh2 = zzh();
            if (zzh2.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzh2.zzn().getApplicationContext();
                if (zzh2.zza == null) {
                    zzh2.zza = new zzid(zzh2, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzh2.zza);
                    application.registerActivityLifecycleCallbacks(zzh2.zza);
                    zzh2.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        this.zzk.zza(new zzgh(this, zzhh));
    }

    /* access modifiers changed from: private */
    public final void zza(zzhh zzhh) {
        zzfd zzfd;
        String str;
        zzq().zzd();
        zzah zzah = new zzah(this);
        zzah.zzab();
        this.zzv = zzah;
        zzey zzey = new zzey(this, zzhh.zzf);
        zzey.zzx();
        this.zzw = zzey;
        zzex zzex = new zzex(this);
        zzex.zzx();
        this.zzt = zzex;
        zzis zzis = new zzis(this);
        zzis.zzx();
        this.zzu = zzis;
        this.zzm.zzac();
        this.zzi.zzac();
        this.zzx = new zzfu(this);
        this.zzw.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzh.zze()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzab2 = zzey.zzab();
        if (TextUtils.isEmpty(this.zzc)) {
            if (zzi().zzf(zzab2)) {
                zzfd = zzr().zzv();
                str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzfd zzv2 = zzr().zzv();
                String valueOf = String.valueOf(zzab2);
                str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzfd = zzv2;
            }
            zzfd.zza(str);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzae != this.zzaf.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzae), Integer.valueOf(this.zzaf.get()));
        }
        this.zzy = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzo.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zzag));
            zzc().zzh.zza(this.zzag);
        }
        if (zzah()) {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzkv.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzu.zzah();
                    this.zzu.zzaf();
                    zzc().zzh.zza(this.zzag);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (zzjy.zzb() && this.zzh.zza(zzap.zzco) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzw.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzw.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zzab2 = zzab();
                if (!zzc().zzx() && !this.zzh.zzg()) {
                    zzc().zzc(!zzab2);
                }
                if (zzab2) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza(new AtomicReference<>());
            }
        } else if (zzab()) {
            if (!zzi().zzd("android.permission.INTERNET")) {
                zzr().zzf().zza("App is missing INTERNET permission");
            }
            if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zzb).isCallerInstantApp() && !this.zzh.zzx()) {
                if (!zzfv.zza(this.zzb)) {
                    zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzkv.zza(this.zzb, false)) {
                    zzr().zzf().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzr().zzf().zza("Uploading is not possible. App measurement disabled");
        }
        zzc().zzo.zza(this.zzh.zza(zzap.zzbg));
        zzc().zzp.zza(this.zzh.zza(zzap.zzbh));
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzw zzu() {
        return this.zzg;
    }

    public final zzx zzb() {
        return this.zzh;
    }

    public final zzfo zzc() {
        zza((zzha) this.zzi);
        return this.zzi;
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzfb zzr() {
        zzb(this.zzj);
        return this.zzj;
    }

    public final zzfb zzd() {
        zzfb zzfb = this.zzj;
        if (zzfb == null || !zzfb.zzz()) {
            return null;
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzgc zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzjt zze() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzfu zzf() {
        return this.zzx;
    }

    /* access modifiers changed from: package-private */
    public final zzgc zzg() {
        return this.zzk;
    }

    public final zzhk zzh() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzkv zzi() {
        zza((zzha) this.zzm);
        return this.zzm;
    }

    public final zzez zzj() {
        zza((zzha) this.zzn);
        return this.zzn;
    }

    public final zzex zzk() {
        zzb(this.zzt);
        return this.zzt;
    }

    private final zzii zzaj() {
        zzb(this.zzs);
        return this.zzs;
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final Context zzn() {
        return this.zzb;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzc);
    }

    public final String zzo() {
        return this.zzc;
    }

    public final String zzp() {
        return this.zzd;
    }

    public final String zzs() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final Clock zzm() {
        return this.zzo;
    }

    public final zzin zzv() {
        zzb(this.zzp);
        return this.zzp;
    }

    public final zzis zzw() {
        zzb(this.zzu);
        return this.zzu;
    }

    public final zzah zzx() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzey zzy() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzb zzz() {
        zzb zzb2 = this.zzr;
        if (zzb2 != null) {
            return zzb2;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzgf zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new zzv(0, 0, true, null, null, null, bundle));
    }

    public static zzgf zza(Context context, zzv zzv2) {
        if (zzv2 != null && (zzv2.zze == null || zzv2.zzf == null)) {
            zzv2 = new zzv(zzv2.zza, zzv2.zzb, zzv2.zzc, zzv2.zzd, null, null, zzv2.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzgf.class) {
                if (zza == null) {
                    zza = new zzgf(new zzhh(context, zzv2));
                }
            }
        } else if (!(zzv2 == null || zzv2.zzg == null || !zzv2.zzg.containsKey("dataCollectionDefaultEnabled"))) {
            zza.zza(zzv2.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zza;
    }

    private final void zzak() {
        if (!this.zzy) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zzb(zzgz zzgz) {
        if (zzgz == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgz.zzz()) {
            String valueOf = String.valueOf(zzgz.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zzb(zze zze2) {
        if (zze2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zze2.zzv()) {
            String valueOf = String.valueOf(zze2.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static void zza(zzha zzha) {
        if (zzha == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzab = Boolean.valueOf(z);
    }

    public final boolean zzaa() {
        return this.zzab != null && this.zzab.booleanValue();
    }

    public final boolean zzab() {
        if (zzkv.zzb() && this.zzh.zza(zzap.zzcw)) {
            return zzac() == 0;
        }
        zzq().zzd();
        zzak();
        if (this.zzh.zzg()) {
            return false;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean zzv2 = zzc().zzv();
        if (zzv2 != null) {
            return zzv2.booleanValue();
        }
        Boolean zzh2 = this.zzh.zzh();
        if (zzh2 != null) {
            return zzh2.booleanValue();
        }
        Boolean bool2 = this.zzac;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return false;
        }
        if (!this.zzh.zza(zzap.zzaw) || this.zzab == null) {
            return true;
        }
        return this.zzab.booleanValue();
    }

    public final int zzac() {
        zzq().zzd();
        if (this.zzh.zzg()) {
            return 1;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean zzv2 = zzc().zzv();
        if (zzv2 == null) {
            Boolean zzh2 = this.zzh.zzh();
            if (zzh2 == null) {
                Boolean bool2 = this.zzac;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    return 6;
                } else {
                    if (!this.zzh.zza(zzap.zzaw) || this.zzab == null || this.zzab.booleanValue()) {
                        return 0;
                    }
                    return 7;
                }
            } else if (zzh2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzv2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zzad() {
        Long valueOf = Long.valueOf(zzc().zzh.zza());
        if (valueOf.longValue() == 0) {
            return this.zzag;
        }
        return Math.min(this.zzag, valueOf.longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgz zzgz) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zze zze2) {
        this.zzae++;
    }

    /* access modifiers changed from: package-private */
    public final void zzag() {
        this.zzaf.incrementAndGet();
    }

    /* access modifiers changed from: protected */
    public final boolean zzah() {
        zzak();
        zzq().zzd();
        Boolean bool = this.zzz;
        if (bool == null || this.zzaa == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzo.elapsedRealtime() - this.zzaa) > 1000)) {
            this.zzaa = this.zzo.elapsedRealtime();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzb).isCallerInstantApp() || this.zzh.zzx() || (zzfv.zza(this.zzb) && zzkv.zza(this.zzb, false))));
            this.zzz = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzz = Boolean.valueOf(z);
            }
        }
        return this.zzz.booleanValue();
    }

    public final void zzai() {
        zzq().zzd();
        zzb(zzaj());
        String zzab2 = zzy().zzab();
        Pair<String, Boolean> zza2 = zzc().zza(zzab2);
        if (!this.zzh.zzi().booleanValue() || ((Boolean) zza2.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza2.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzaj().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            URL zza3 = zzi().zza(zzy().zzt().zze(), zzab2, (String) zza2.first, zzc().zzv.zza() - 1);
            zzii zzaj = zzaj();
            zzgi zzgi = new zzgi(this);
            zzaj.zzd();
            zzaj.zzaa();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzgi);
            zzaj.zzq().zzb(new zzik(zzaj, zzab2, zza3, null, null, zzgi));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzu.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkv zzi2 = zzi();
            zzi2.zzb();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzi2.zzn().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzq.zza("auto", "_cmp", bundle);
            zzkv zzi3 = zzi();
            if (!TextUtils.isEmpty(optString) && zzi3.zza(optString, optDouble)) {
                zzi3.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
            }
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
