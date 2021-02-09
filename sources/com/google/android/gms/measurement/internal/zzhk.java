package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzkj;
import com.google.android.gms.internal.measurement.zzkv;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzms;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzhk extends zze {
    protected zzid zza;
    protected boolean zzb = true;
    private zzhf zzc;
    private final Set<zzhi> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();

    protected zzhk(zzgf zzgf) {
        super(zzgf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zze
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000, "boolean test flag value", new zzhm(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000, "String test flag value", new zzhw(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000, "long test flag value", new zzhy(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000, "double test flag value", new zzia(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzhz(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzic(this, z));
    }

    /* access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        if (zzt().zza(zzap.zzba)) {
            zzd();
            String zza2 = zzs().zzn.zza();
            if (zza2 != null) {
                if ("unset".equals(zza2)) {
                    zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
                } else {
                    zza("app", "_npa", Long.valueOf("true".equals(zza2) ? 1 : 0), zzm().currentTimeMillis());
                }
            }
        }
        if (!this.zzx.zzab() || !this.zzb) {
            zzr().zzw().zza("Updating Scion state (FE)");
            zzh().zzac();
            return;
        }
        zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzai();
        if (zzlc.zzb() && zzt().zza(zzap.zzcp)) {
            zzk().zza.zza();
        }
        if (zzkj.zzb() && zzt().zza(zzap.zzcv)) {
            if (!(this.zzx.zzf().zza.zzc().zzi.zza() > 0)) {
                this.zzx.zzf().zza();
            }
        }
    }

    public final void zza(long j) {
        zzb();
        zzq().zza(new zzib(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza(new zzie(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzc == null || zzkv.zze(str2), false, null);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzio zzio;
        String str4;
        long j2;
        long j3;
        String str5;
        Bundle bundle2;
        List<String> list;
        String str6;
        String str7;
        zzio zzio2;
        ArrayList arrayList;
        Bundle bundle3;
        boolean z4;
        int i;
        Class<?> cls;
        List<String> zzah;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzd();
        zzw();
        if (!this.zzx.zzab()) {
            zzr().zzw().zza("Event not sent since app measurement is disabled");
        } else if (!zzt().zza(zzap.zzbj) || (zzah = zzg().zzah()) == null || zzah.contains(str2)) {
            int i2 = 0;
            if (!this.zze) {
                this.zze = true;
                try {
                    if (!this.zzx.zzt()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzn().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, zzn());
                    } catch (Exception e) {
                        zzr().zzi().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    zzr().zzv().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzt().zza(zzap.zzby) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
                zza("auto", "_lgclid", bundle.getString("gclid"), zzm().currentTimeMillis());
            }
            if (z3) {
                zzu();
                if (!"_iap".equals(str2)) {
                    zzkv zzi = this.zzx.zzi();
                    if (!zzi.zza(NotificationCompat.CATEGORY_EVENT, str2)) {
                        i = 2;
                    } else if (!zzi.zza(NotificationCompat.CATEGORY_EVENT, zzhe.zza, str2)) {
                        i = 13;
                    } else if (!zzi.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        zzr().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzo().zza(str2));
                        this.zzx.zzi();
                        this.zzx.zzi().zza(i, "_ev", zzkv.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                }
            }
            zzu();
            zzio zzab = zzi().zzab();
            if (zzab != null && !bundle.containsKey("_sc")) {
                zzab.zzd = true;
            }
            zzin.zza(zzab, bundle, z && z3);
            boolean equals = "am".equals(str);
            boolean zze2 = zzkv.zze(str2);
            if (z && this.zzc != null && !zze2 && !equals) {
                zzr().zzw().zza("Passing event to registered event handler (FE)", zzo().zza(str2), zzo().zza(bundle));
                this.zzc.interceptEvent(str, str2, bundle, j);
            } else if (this.zzx.zzah()) {
                int zzb2 = zzp().zzb(str2);
                if (zzb2 != 0) {
                    zzr().zzh().zza("Invalid event name. Event will not be logged (FE)", zzo().zza(str2));
                    zzp();
                    String zza2 = zzkv.zza(str2, 40, true);
                    if (str2 != null) {
                        i2 = str2.length();
                    }
                    this.zzx.zzi().zza(str3, zzb2, "_ev", zza2, i2);
                    return;
                }
                List<String> listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
                Bundle zza3 = zzp().zza(str3, str2, bundle, listOf, z3, true);
                zzio zzio3 = (zza3 == null || !zza3.containsKey("_sc") || !zza3.containsKey("_si")) ? null : new zzio(zza3.getString("_sn"), zza3.getString("_sc"), Long.valueOf(zza3.getLong("_si")).longValue());
                if (zzio3 == null) {
                    zzio = zzab;
                } else {
                    zzio = zzio3;
                }
                String str8 = "_ae";
                if (zzt().zza(zzap.zzax)) {
                    zzu();
                    if (zzi().zzab() != null && str8.equals(str2)) {
                        long zzb3 = zzk().zzb.zzb();
                        if (zzb3 > 0) {
                            zzp().zza(zza3, zzb3);
                        }
                    }
                }
                if (zzjy.zzb() && zzt().zza(zzap.zzco)) {
                    if (!"auto".equals(str) && "_ssr".equals(str2)) {
                        zzkv zzp = zzp();
                        String string = zza3.getString("_ffr");
                        String trim = Strings.isEmptyOrWhitespace(string) ? null : string.trim();
                        if (zzkv.zzc(trim, zzp.zzs().zzw.zza())) {
                            zzp.zzr().zzw().zza("Not logging duplicate session_start_with_rollout event");
                            z4 = false;
                        } else {
                            zzp.zzs().zzw.zza(trim);
                            z4 = true;
                        }
                        if (!z4) {
                            return;
                        }
                    } else if (str8.equals(str2)) {
                        String zza4 = zzp().zzs().zzw.zza();
                        if (!TextUtils.isEmpty(zza4)) {
                            zza3.putString("_ffr", zza4);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(zza3);
                long nextLong = zzp().zzh().nextLong();
                if (!zzt().zza(zzap.zzar)) {
                    j2 = j;
                    j3 = nextLong;
                    str4 = "_o";
                } else if (zzs().zzq.zza() > 0) {
                    j2 = j;
                    if (!zzs().zza(j2)) {
                        j3 = nextLong;
                        str4 = "_o";
                    } else if (zzs().zzt.zza()) {
                        zzr().zzx().zza("Current session is expired, remove the session number, ID, and engagement time");
                        if (zzt().zza(zzap.zzao)) {
                            j3 = nextLong;
                            str4 = "_o";
                            zza("auto", "_sid", (Object) null, zzm().currentTimeMillis());
                        } else {
                            j3 = nextLong;
                            str4 = "_o";
                        }
                        if (zzt().zza(zzap.zzap)) {
                            zza("auto", "_sno", (Object) null, zzm().currentTimeMillis());
                        }
                        if (zzms.zzb() && zzt().zza(zzap.zzbo)) {
                            zza("auto", "_se", (Object) null, zzm().currentTimeMillis());
                        }
                    } else {
                        j3 = nextLong;
                        str4 = "_o";
                    }
                } else {
                    j2 = j;
                    j3 = nextLong;
                    str4 = "_o";
                }
                if (!zzt().zza(zzap.zzaq)) {
                    str5 = str2;
                } else if (zza3.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                    zzr().zzx().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    str5 = str2;
                    this.zzx.zze().zza.zza(j2, true);
                } else {
                    str5 = str2;
                }
                String[] strArr = (String[]) zza3.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    String str9 = strArr[i3];
                    Object obj = zza3.get(str9);
                    zzp();
                    Bundle[] zza5 = zzkv.zza(obj);
                    if (zza5 != null) {
                        zza3.putInt(str9, zza5.length);
                        int i5 = 0;
                        while (i5 < zza5.length) {
                            Bundle bundle4 = zza5[i5];
                            zzin.zza(zzio, bundle4, true);
                            Bundle zza6 = zzp().zza(str3, "_ep", bundle4, listOf, z3, false);
                            zza6.putString("_en", str5);
                            zza6.putLong("_eid", j3);
                            zza6.putString("_gn", str9);
                            zza6.putInt("_ll", zza5.length);
                            zza6.putInt("_i", i5);
                            arrayList2.add(zza6);
                            i5++;
                            zza3 = zza3;
                            arrayList2 = arrayList2;
                            zzio = zzio;
                            str4 = str4;
                            str8 = str8;
                            listOf = listOf;
                        }
                        list = listOf;
                        str7 = str4;
                        arrayList = arrayList2;
                        str6 = str8;
                        zzio2 = zzio;
                        bundle3 = zza3;
                        i4 += zza5.length;
                    } else {
                        list = listOf;
                        str7 = str4;
                        arrayList = arrayList2;
                        str6 = str8;
                        zzio2 = zzio;
                        bundle3 = zza3;
                    }
                    i3++;
                    strArr = strArr;
                    zza3 = bundle3;
                    arrayList2 = arrayList;
                    zzio = zzio2;
                    length = length;
                    str4 = str7;
                    str8 = str6;
                    listOf = list;
                }
                String str10 = str4;
                if (i4 != 0) {
                    zza3.putLong("_eid", j3);
                    zza3.putInt("_epc", i4);
                }
                int i6 = 0;
                while (i6 < arrayList2.size()) {
                    Bundle bundle5 = (Bundle) arrayList2.get(i6);
                    String str11 = i6 != 0 ? "_ep" : str5;
                    bundle5.putString(str10, str);
                    if (z2) {
                        bundle2 = zzp().zza(bundle5);
                    } else {
                        bundle2 = bundle5;
                    }
                    if (!zzkv.zzb() || !zzt().zza(zzap.zzcw)) {
                        zzr().zzw().zza("Logging event (FE)", zzo().zza(str5), zzo().zza(bundle2));
                    }
                    zzh().zza(new zzan(str11, new zzam(bundle2), str, j), str3);
                    if (!equals) {
                        for (zzhi zzhi : this.zzd) {
                            zzhi.onEvent(str, str2, new Bundle(bundle2), j);
                        }
                    }
                    i6++;
                    str10 = str10;
                    str5 = str5;
                }
                zzu();
                if (zzi().zzab() != null && str8.equals(str5)) {
                    zzk().zza(true, true, zzm().elapsedRealtime());
                }
            }
        } else {
            zzr().zzw().zza("Dropping non-safelisted event. event name, origin", str2, str);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3;
        Bundle bundle2;
        boolean z3;
        zzb();
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (z2) {
            if (this.zzc != null && !zzkv.zze(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza(new zzhl(this, str, str2, j, zzkv.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzp().zzc(str2);
        } else {
            zzkv zzp = zzp();
            if (zzp.zza("user property", str2)) {
                if (!zzp.zza("user property", zzhg.zza, str2)) {
                    i = 15;
                } else if (zzp.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzp();
            String zza2 = zzkv.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzx.zzi().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzp().zzb(str2, obj);
            if (zzb2 != 0) {
                zzp();
                String zza3 = zzkv.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzx.zzi().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzp().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza(new zzho(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    public final void zza(String str, String str2, Object obj, long j) {
        Long l;
        String str3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzb();
        zzw();
        if (zzt().zza(zzap.zzba) && FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    String str5 = "false";
                    Long valueOf = Long.valueOf(str5.equals(str4.toLowerCase(Locale.ENGLISH)) ? 1 : 0);
                    zzfr zzfr = zzs().zzn;
                    if (valueOf.longValue() == 1) {
                        str5 = "true";
                    }
                    zzfr.zza(str5);
                    l = valueOf;
                    str3 = "_npa";
                    if (!this.zzx.zzab()) {
                        zzr().zzx().zza("User property not set since app measurement is disabled");
                        return;
                    } else if (this.zzx.zzah()) {
                        zzh().zza(new zzkq(str3, j, l, str));
                        return;
                    } else {
                        return;
                    }
                }
            }
            if (obj == null) {
                zzs().zzn.zza("unset");
                l = obj;
                str3 = "_npa";
                if (!this.zzx.zzab()) {
                }
            }
        }
        str3 = str2;
        l = obj;
        if (!this.zzx.zzab()) {
        }
    }

    public final List<zzkq> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get user properties", new zzhn(this, atomicReference, z));
            List<zzkq> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
    }

    public final String zzah() {
        zzb();
        return this.zzf.get();
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzm().elapsedRealtime();
            String zze2 = zze(120000);
            long elapsedRealtime2 = zzm().elapsedRealtime() - elapsedRealtime;
            if (zze2 != null || elapsedRealtime2 >= 120000) {
                return zze2;
            }
            return zze(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    private final String zze(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzq().zza(new zzhq(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzr().zzi().zza("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza(new zzhp(this, j));
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzx.zzah()) {
            if (zzt().zza(zzap.zzbw)) {
                zzx zzt = zzt();
                zzt.zzu();
                Boolean zzb2 = zzt.zzb("google_analytics_deferred_deep_link_enabled");
                if (zzb2 != null && zzb2.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza(new zzhj(this));
                }
            }
            zzh().zzae();
            this.zzb = false;
            String zzw = zzs().zzw();
            if (!TextUtils.isEmpty(zzw)) {
                zzl().zzaa();
                if (!zzw.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzw);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzhf zzhf) {
        zzhf zzhf2;
        zzd();
        zzb();
        zzw();
        if (!(zzhf == null || zzhf == (zzhf2 = this.zzc))) {
            Preconditions.checkState(zzhf2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzhf;
    }

    public final void zza(zzhi zzhi) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhi);
        if (!this.zzd.add(zzhi)) {
            zzr().zzi().zza("OnEventListener already registered");
        }
    }

    public final void zzb(zzhi zzhi) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhi);
        if (!this.zzd.remove(zzhi)) {
            zzr().zzi().zza("OnEventListener had not been registered");
        }
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzhb.zza(bundle, "app_id", String.class, null);
        zzhb.zza(bundle, "origin", String.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzhb.zza(bundle, "value", Object.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzhb.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
        } else if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
        } else {
            Object zzc2 = zzp().zzc(string, obj);
            if (zzc2 == null) {
                zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
                return;
            }
            zzhb.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
                } else {
                    zzq().zza(new zzhr(this, bundle));
                }
            } else {
                zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            }
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza(new zzhu(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkq zzkq = new zzkq(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin"));
        try {
            zzan zza2 = zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0, true, false);
            zzh().zza(new zzv(bundle.getString("app_id"), bundle.getString("origin"), zzkq, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0, true, false), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzh().zza(new zzv(bundle.getString("app_id"), bundle.getString("origin"), new zzkq(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get conditional user properties", new zzht(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkv.zzb(list);
            }
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzw.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzx.zzq().zza(atomicReference, 5000, "get user properties", new zzhv(this, atomicReference, str, str2, str3, z));
            List<zzkq> list = (List) atomicReference.get();
            if (list == null) {
                zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzkq zzkq : list) {
                arrayMap.put(zzkq.zza, zzkq.zza());
            }
            return arrayMap;
        }
    }

    public final String zzaj() {
        zzio zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    public final String zzak() {
        zzio zzac = this.zzx.zzv().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzx.zzo() != null) {
            return this.zzx.zzo();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzx.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
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
