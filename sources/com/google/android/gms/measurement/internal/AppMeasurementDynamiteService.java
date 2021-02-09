package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzv;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.2 */
public class AppMeasurementDynamiteService extends zzl {
    zzgf zza = null;
    private Map<Integer, zzhi> zzb = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.2 */
    class zza implements zzhf {
        private zzs zza;

        zza(zzs zzs) {
            this.zza = zzs;
        }

        @Override // com.google.android.gms.measurement.internal.zzhf
        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.2 */
    class zzb implements zzhi {
        private zzs zza;

        zzb(zzs zzs) {
            this.zza = zzs;
        }

        @Override // com.google.android.gms.measurement.internal.zzhi
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initialize(IObjectWrapper iObjectWrapper, zzv zzv, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgf zzgf = this.zza;
        if (zzgf == null) {
            this.zza = zzgf.zza(context, zzv);
        } else {
            zzgf.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(null, "_id", str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzd(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        this.zza.zzh().zzb(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getMaxUserProperties(String str, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzn, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenName(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzaj());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCurrentScreenClass(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzak());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getCachedAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getAppInstanceId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzi(this, zzn));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getGmpAppId(zzn zzn) throws RemoteException {
        zza();
        zza(zzn, this.zza.zzh().zzal());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void generateEventId(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzn, this.zza.zzi().zzg());
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzn zzn, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzq().zza(new zzh(this, zzn, new zzan(str2, new zzam(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zzn, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzn.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void performAction(Bundle bundle, zzn zzn, long j) throws RemoteException {
        zza();
        zzn.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getUserProperties(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzk(this, zzn, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        Object obj = null;
        Object unwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object unwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, unwrap, unwrap2, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setEventInterceptor(zzs zzs) throws RemoteException {
        zza();
        zzhk zzh = this.zza.zzh();
        zza zza2 = new zza(zzs);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza(new zzhs(zzh, zza2));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void registerOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhi zzhi = this.zzb.get(Integer.valueOf(zzs.zza()));
        if (zzhi == null) {
            zzhi = new zzb(zzs);
            this.zzb.put(Integer.valueOf(zzs.zza()), zzhi);
        }
        this.zza.zzh().zza(zzhi);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void unregisterOnMeasurementEventListener(zzs zzs) throws RemoteException {
        zza();
        zzhi remove = this.zzb.remove(Integer.valueOf(zzs.zza()));
        if (remove == null) {
            remove = new zzb(zzs);
        }
        this.zza.zzh().zzb(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setInstanceIdProvider(zzt zzt) throws RemoteException {
        zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getConditionalUserProperties(String str, String str2, zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzj(this, zzn, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void getTestFlag(zzn zzn, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzkv zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzn.zza(bundle);
            } catch (RemoteException e) {
                zzi.zzx.zzr().zzi().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzn, this.zza.zzh().zzac().booleanValue());
        }
    }

    private final void zza(zzn zzn, String str) {
        this.zza.zzi().zza(zzn, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        this.zza.zzh().zzb(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public void isDataCollectionEnabled(zzn zzn) throws RemoteException {
        zza();
        this.zza.zzq().zza(new zzl(this, zzn));
    }
}
