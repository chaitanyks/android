package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public abstract class zzgz extends zzha {
    private boolean zza;

    zzgz(zzgf zzgf) {
        super(zzgf);
        this.zzx.zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();

    /* access modifiers changed from: package-private */
    public final boolean zzz() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzx.zzag();
            this.zza = true;
        }
    }

    public final void zzac() {
        if (!this.zza) {
            f_();
            this.zzx.zzag();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public void f_() {
    }
}
