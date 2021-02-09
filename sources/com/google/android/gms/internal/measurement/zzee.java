package com.google.android.gms.internal.measurement;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzee {
    private final zzel zza;
    private final byte[] zzb;

    private zzee(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzel.zza(bArr);
    }

    public final zzdw zza() {
        this.zza.zzb();
        return new zzeg(this.zzb);
    }

    public final zzel zzb() {
        return this.zza;
    }

    /* synthetic */ zzee(int i, zzdv zzdv) {
        this(i);
    }
}
