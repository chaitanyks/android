package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzkk;
import com.google.android.gms.internal.measurement.zzlc;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkb {
    private long zza;
    private long zzb;
    private final zzaf zzc = new zzke(this, this.zzd.zzx);
    private final /* synthetic */ zzjt zzd;

    public zzkb(zzjt zzjt) {
        this.zzd = zzjt;
        long elapsedRealtime = zzjt.zzm().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzd.zzd();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzc.zzc();
        if (this.zza != 0) {
            this.zzd.zzs().zzr.zza(this.zzd.zzs().zzr.zza() + (j - this.zza));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = 0;
    }

    /* access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzd();
        zza(false, false, this.zzd.zzm().elapsedRealtime());
        this.zzd.zze().zza(this.zzd.zzm().elapsedRealtime());
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzd();
        this.zzd.zzw();
        if (!zzkk.zzb() || !this.zzd.zzt().zza(zzap.zzcu)) {
            j = this.zzd.zzm().elapsedRealtime();
        }
        if (!zzlc.zzb() || !this.zzd.zzt().zza(zzap.zzcp) || this.zzd.zzx.zzab()) {
            this.zzd.zzs().zzq.zza(this.zzd.zzm().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            this.zzd.zzs().zzr.zza(j2);
            this.zzd.zzr().zzx().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzin.zza(this.zzd.zzi().zzab(), bundle, true);
            if (this.zzd.zzt().zze(this.zzd.zzg().zzab(), zzap.zzax)) {
                if (this.zzd.zzt().zza(zzap.zzay)) {
                    if (!z2) {
                        zzb();
                    }
                } else if (z2) {
                    bundle.putLong("_fr", 1);
                } else {
                    zzb();
                }
            }
            if (!this.zzd.zzt().zza(zzap.zzay) || !z2) {
                this.zzd.zzf().zza("auto", "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(Math.max(0L, 3600000 - this.zzd.zzs().zzr.zza()));
            return true;
        }
        this.zzd.zzr().zzx().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzm().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }
}
