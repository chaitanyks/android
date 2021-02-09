package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.internal.zzju;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzjq<T extends Context & zzju> {
    private final T zza;

    public zzjq(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() {
        zzgf zza2 = zzgf.zza(this.zza, (zzv) null);
        zzfb zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzgf zza2 = zzgf.zza(this.zza, (zzv) null);
        zzfb zzr = zza2.zzr();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    public final int zza(Intent intent, int i, int i2) {
        zzgf zza2 = zzgf.zza(this.zza, (zzv) null);
        zzfb zzr = zza2.zzr();
        if (intent == null) {
            zzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new zzjp(this, i2, zzr, intent));
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzkj zza2 = zzkj.zza(this.zza);
        zza2.zzq().zza(new zzjr(this, zza2, runnable));
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgk(zzkj.zza(this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zza(JobParameters jobParameters) {
        zzgf zza2 = zzgf.zza(this.zza, (zzv) null);
        zzfb zzr = zza2.zzr();
        String string = jobParameters.getExtras().getString("action");
        zza2.zzu();
        zzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new zzjs(this, zzr, jobParameters));
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
            return;
        }
        zzc().zzx().zza("onRebind called. action", intent.getAction());
    }

    private final zzfb zzc() {
        return zzgf.zza(this.zza, (zzv) null).zzr();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfb zzfb, JobParameters jobParameters) {
        zzfb.zzx().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzfb zzfb, Intent intent) {
        if (this.zza.zza(i)) {
            zzfb.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }
}
