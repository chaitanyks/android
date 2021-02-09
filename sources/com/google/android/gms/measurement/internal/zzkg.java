package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzkg {
    private final Clock zza;
    private long zzb;

    public zzkg(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final void zzb() {
        this.zzb = 0;
    }

    public final boolean zza(long j) {
        if (this.zzb != 0 && this.zza.elapsedRealtime() - this.zzb < 3600000) {
            return false;
        }
        return true;
    }
}
