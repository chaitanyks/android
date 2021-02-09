package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzdk extends zzdh {
    zzdk() {
    }

    @Override // com.google.android.gms.internal.measurement.zzdh
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
