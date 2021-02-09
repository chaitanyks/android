package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzic implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhk zzb;

    zzic(zzhk zzhk, boolean z) {
        this.zzb = zzhk;
        this.zza = z;
    }

    public final void run() {
        boolean zzab = this.zzb.zzx.zzab();
        boolean zzaa = this.zzb.zzx.zzaa();
        this.zzb.zzx.zza(this.zza);
        if (zzaa == this.zza) {
            this.zzb.zzx.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzx.zzab() == zzab || this.zzb.zzx.zzab() != this.zzb.zzx.zzaa()) {
            this.zzb.zzx.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzab));
        }
        this.zzb.zzam();
    }
}
