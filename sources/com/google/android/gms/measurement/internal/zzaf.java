package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzj;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public abstract class zzaf {
    private static volatile Handler zzb;
    private final zzhc zza;
    private final Runnable zzc;
    private volatile long zzd;

    zzaf(zzhc zzhc) {
        Preconditions.checkNotNull(zzhc);
        this.zza = zzhc;
        this.zzc = new zzai(this, zzhc);
    }

    public abstract void zza();

    public final void zza(long j) {
        zzc();
        if (j >= 0) {
            this.zzd = this.zza.zzm().currentTimeMillis();
            if (!zzd().postDelayed(this.zzc, j)) {
                this.zza.zzr().zzf().zza("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzb() {
        return this.zzd != 0;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd = 0;
        zzd().removeCallbacks(this.zzc);
    }

    private final Handler zzd() {
        Handler handler;
        if (zzb != null) {
            return zzb;
        }
        synchronized (zzaf.class) {
            if (zzb == null) {
                zzb = new zzj(this.zza.zzn().getMainLooper());
            }
            handler = zzb;
        }
        return handler;
    }
}
