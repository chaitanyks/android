package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzcu<T> extends zzcw<T> {
    static final zzcu<Object> zza = new zzcu<>();

    private zzcu() {
    }

    @Override // com.google.android.gms.internal.measurement.zzcw
    public final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzcw
    public final T zzb() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
