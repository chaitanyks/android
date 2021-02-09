package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzdv extends zzdx {
    private int zza = 0;
    private final int zzb = this.zzc.zza();
    private final /* synthetic */ zzdw zzc;

    zzdv(zzdw zzdw) {
        this.zzc = zzdw;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzeb
    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
