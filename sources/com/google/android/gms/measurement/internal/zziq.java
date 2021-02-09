package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zziq implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzio zzc;
    private final /* synthetic */ zzio zzd;
    private final /* synthetic */ zzin zze;

    zziq(zzin zzin, boolean z, long j, zzio zzio, zzio zzio2) {
        this.zze = zzin;
        this.zza = z;
        this.zzb = j;
        this.zzc = zzio;
        this.zzd = zzio2;
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.zze.zzt().zza(zzap.zzax)) {
            z = this.zza && this.zze.zza != null;
            if (z) {
                zzin zzin = this.zze;
                zzin.zza((zzin) zzin.zza, (zzio) true, (boolean) this.zzb);
            }
        } else {
            if (this.zza && this.zze.zza != null) {
                zzin zzin2 = this.zze;
                zzin2.zza((zzin) zzin2.zza, (zzio) true, (boolean) this.zzb);
            }
            z = false;
        }
        zzio zzio = this.zzc;
        if (zzio == null || zzio.zzc != this.zzd.zzc || !zzkv.zzc(this.zzc.zzb, this.zzd.zzb) || !zzkv.zzc(this.zzc.zza, this.zzd.zza)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zzin.zza(this.zzd, bundle, true);
            zzio zzio2 = this.zzc;
            if (zzio2 != null) {
                if (zzio2.zza != null) {
                    bundle.putString("_pn", this.zzc.zza);
                }
                bundle.putString("_pc", this.zzc.zzb);
                bundle.putLong("_pi", this.zzc.zzc);
            }
            if (this.zze.zzt().zza(zzap.zzax) && z) {
                long zzb2 = this.zze.zzk().zzb.zzb();
                if (zzb2 > 0) {
                    this.zze.zzp().zza(bundle, zzb2);
                }
            }
            this.zze.zzf().zzb("auto", "_vs", bundle);
        }
        this.zze.zza = this.zzd;
        this.zze.zzh().zza(this.zzd);
    }
}
