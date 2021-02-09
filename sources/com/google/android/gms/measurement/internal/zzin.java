package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzin extends zze {
    protected zzio zza;
    private volatile zzio zzb;
    private zzio zzc;
    private final Map<Activity, zzio> zzd = new ArrayMap();
    private zzio zze;
    private String zzf;

    public zzin(zzgf zzgf) {
        super(zzgf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zze
    public final boolean zzz() {
        return false;
    }

    public final zzio zzab() {
        zzw();
        zzd();
        return this.zza;
    }

    public final void zza(Activity activity, String str, String str2) {
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzb.zzb.equals(str2);
            boolean zzc2 = zzkv.zzc(this.zzb.zza, str);
            if (equals && zzc2) {
                zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzr().zzx().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzio zzio = new zzio(str, str2, zzp().zzg());
                this.zzd.put(activity, zzio);
                zza(activity, zzio, true);
            } else {
                zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzio zzac() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzio zzio, boolean z) {
        zzio zzio2;
        zzio zzio3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzio.zzb == null) {
            zzio2 = new zzio(zzio.zza, zza(activity.getClass().getCanonicalName()), zzio.zzc);
        } else {
            zzio2 = zzio;
        }
        this.zzc = this.zzb;
        this.zzb = zzio2;
        zzq().zza(new zziq(this, z, zzm().elapsedRealtime(), zzio3, zzio2));
    }

    /* access modifiers changed from: private */
    public final void zza(zzio zzio, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzio.zzd, z, j)) {
            zzio.zzd = false;
        }
    }

    public static void zza(zzio zzio, Bundle bundle, boolean z) {
        if (bundle != null && zzio != null && (!bundle.containsKey("_sc") || z)) {
            if (zzio.zza != null) {
                bundle.putString("_sn", zzio.zza);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzio.zzb);
            bundle.putLong("_si", zzio.zzc);
        } else if (bundle != null && zzio == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzio zzio) {
        zzd();
        synchronized (this) {
            if (this.zzf == null || this.zzf.equals(str) || zzio != null) {
                this.zzf = str;
                this.zze = zzio;
            }
        }
    }

    private static String zza(String str) {
        String str2;
        String[] split = str.split("\\.");
        if (split.length > 0) {
            str2 = split[split.length - 1];
        } else {
            str2 = "";
        }
        if (str2.length() > 100) {
            return str2.substring(0, 100);
        }
        return str2;
    }

    private final zzio zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzio zzio = this.zzd.get(activity);
        if (zzio != null) {
            return zzio;
        }
        zzio zzio2 = new zzio(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
        this.zzd.put(activity, zzio2);
        return zzio2;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzio(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zza(Activity activity) {
        zza(activity, zzd(activity), false);
        zzb zze2 = zze();
        zze2.zzq().zza(new zzc(zze2, zze2.zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity) {
        zzio zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza(new zzip(this, zzd2, zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzio zzio;
        if (bundle != null && (zzio = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzio.zzc);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzio.zza);
            bundle2.putString("referrer_name", zzio.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void zzc(Activity activity) {
        this.zzd.remove(activity);
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
