package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzlb;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzjy {
    final /* synthetic */ zzjt zza;
    private zzjz zzb;
    private final Runnable zzc = new zzjx(this);

    zzjy(zzjt zzjt) {
        this.zza = zzjt;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzd();
        if (!this.zza.zzt().zza(zzap.zzcg)) {
            return;
        }
        if (!zzlb.zzb() || !this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzct)) {
            this.zza.zzc.removeCallbacks(this.zzc);
        } else if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (!this.zza.zzt().zza(zzap.zzcg)) {
            return;
        }
        if (!zzlb.zzb() || !this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzct)) {
            this.zza.zzc.postDelayed(this.zzc, 2000);
            return;
        }
        this.zzb = new zzjz(this, this.zza.zzm().currentTimeMillis());
        this.zza.zzc.postDelayed(this.zzb, 2000);
    }
}
