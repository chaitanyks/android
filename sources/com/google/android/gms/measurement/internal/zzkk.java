package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public abstract class zzkk extends zzkh {
    private boolean zzb;

    zzkk(zzkj zzkj) {
        super(zzkj);
        this.zza.zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (!this.zzb) {
            zze();
            this.zza.zzp();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
