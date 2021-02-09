package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzis extends zze {
    private final zzjk zza;
    private zzet zzb;
    private volatile Boolean zzc;
    private final zzaf zzd;
    private final zzkg zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaf zzg;

    protected zzis(zzgf zzgf) {
        super(zzgf);
        this.zze = new zzkg(zzgf.zzm());
        this.zza = new zzjk(this);
        this.zzd = new zzir(this, zzgf);
        this.zzg = new zzjc(this, zzgf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zze
    public final boolean zzz() {
        return false;
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzd();
        zzw();
        zza(new zzjb(this, zza(true)));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzet zzet, AbstractSafeParcelable abstractSafeParcelable, zzm zzm) {
        int i;
        List<AbstractSafeParcelable> zza2;
        zzd();
        zzb();
        zzw();
        boolean zzai = zzai();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzai || (zza2 = zzj().zza(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zza2);
                i = zza2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        zzet.zza((zzan) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkq) {
                    try {
                        zzet.zza((zzkq) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        zzet.zza((zzv) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzan zzan, String str) {
        Preconditions.checkNotNull(zzan);
        zzd();
        zzw();
        boolean zzai = zzai();
        zza(new zzje(this, zzai, zzai && zzj().zza(zzan), zzan, zza(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        zzd();
        zzw();
        zzu();
        zza(new zzjd(this, true, zzj().zza(zzv), new zzv(zzv), zza(true), zzv));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza(new zzjg(this, atomicReference, str, str2, str3, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2) {
        zzd();
        zzw();
        zza(new zzjf(this, str, str2, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkq>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza(new zzji(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzn zzn, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza(new zzjh(this, str, str2, z, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkq zzkq) {
        zzd();
        zzw();
        zza(new zziu(this, zzai() && zzj().zza(zzkq), zzkq, zza(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkq>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza(new zzit(this, atomicReference, zza(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zza2 = zza(false);
        if (zzai()) {
            zzj().zzab();
        }
        zza(new zziw(this, zza2));
    }

    private final boolean zzai() {
        zzu();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza(new zziv(this, atomicReference, zza(false)));
    }

    public final void zza(zzn zzn) {
        zzd();
        zzw();
        zza(new zziy(this, zza(false), zzn));
    }

    /* access modifiers changed from: protected */
    public final void zzae() {
        zzd();
        zzw();
        zzm zza2 = zza(true);
        boolean zza3 = zzt().zza(zzap.zzbx);
        if (zza3) {
            zzj().zzac();
        }
        zza(new zzix(this, zza2, zza3));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzio zzio) {
        zzd();
        zzw();
        zza(new zzja(this, zzio));
    }

    /* access modifiers changed from: private */
    public final void zzaj() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzap.zzaf.zza(null).longValue());
    }

    /* access modifiers changed from: package-private */
    public final void zzaf() {
        boolean z;
        boolean z2;
        zzd();
        zzw();
        if (!zzab()) {
            boolean z3 = false;
            if (this.zzc == null) {
                zzd();
                zzw();
                Boolean zzj = zzs().zzj();
                if (zzj == null || !zzj.booleanValue()) {
                    zzu();
                    if (zzg().zzag() == 1) {
                        z = true;
                        z2 = true;
                    } else {
                        zzr().zzx().zza("Checking service availability");
                        int zza2 = zzp().zza(12451000);
                        if (zza2 == 0) {
                            zzr().zzx().zza("Service available");
                            z = true;
                            z2 = true;
                        } else if (zza2 == 1) {
                            zzr().zzx().zza("Service missing");
                            z = false;
                            z2 = true;
                        } else if (zza2 == 2) {
                            zzr().zzw().zza("Service container out of date");
                            if (zzp().zzj() < 17443) {
                                z = false;
                                z2 = true;
                            } else {
                                Boolean zzj2 = zzs().zzj();
                                z = zzj2 == null || zzj2.booleanValue();
                                z2 = false;
                            }
                        } else if (zza2 == 3) {
                            zzr().zzi().zza("Service disabled");
                            z = false;
                            z2 = false;
                        } else if (zza2 == 9) {
                            zzr().zzi().zza("Service invalid");
                            z = false;
                            z2 = false;
                        } else if (zza2 != 18) {
                            zzr().zzi().zza("Unexpected service status", Integer.valueOf(zza2));
                            z = false;
                            z2 = false;
                        } else {
                            zzr().zzi().zza("Service updating");
                            z = true;
                            z2 = true;
                        }
                    }
                    if (!z && zzt().zzx()) {
                        zzr().zzf().zza("No way to upload. Consider using the full version of Analytics");
                        z2 = false;
                    }
                    if (z2) {
                        zzs().zza(z);
                    }
                } else {
                    z = true;
                }
                this.zzc = Boolean.valueOf(z);
            }
            if (this.zzc.booleanValue()) {
                this.zza.zzb();
            } else if (!zzt().zzx()) {
                zzu();
                List<ResolveInfo> queryIntentServices = zzn().getPackageManager().queryIntentServices(new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    z3 = true;
                }
                if (z3) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzn = zzn();
                    zzu();
                    intent.setComponent(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzag() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzet zzet) {
        zzd();
        Preconditions.checkNotNull(zzet);
        this.zzb = zzet;
        zzaj();
        zzal();
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzr().zzf().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzaf();
        }
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable runnable : this.zzf) {
            try {
                runnable.run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    public final void zza(zzn zzn, zzan zzan, String str) {
        zzd();
        zzw();
        if (zzp().zza(12451000) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zzn, new byte[0]);
            return;
        }
        zza(new zziz(this, zzan, str, zzn));
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
