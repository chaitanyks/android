package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
final class zzki extends zzaf {
    private final /* synthetic */ zzkj zza;
    private final /* synthetic */ zzkf zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzki(zzkf zzkf, zzhc zzhc, zzkj zzkj) {
        super(zzhc);
        this.zzb = zzkf;
        this.zza = zzkj;
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
