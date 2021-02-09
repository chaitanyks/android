package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
final class zzai implements Runnable {
    private final /* synthetic */ zzhc zza;
    private final /* synthetic */ zzaf zzb;

    zzai(zzaf zzaf, zzhc zzhc) {
        this.zzb = zzaf;
        this.zza = zzhc;
    }

    public final void run() {
        this.zza.zzu();
        if (zzw.zza()) {
            this.zza.zzq().zza(this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        zzaf.zza(this.zzb, 0);
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
