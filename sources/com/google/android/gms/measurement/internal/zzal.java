package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzal implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.keySet().iterator();
    private final /* synthetic */ zzam zzb;

    zzal(zzam zzam) {
        this.zzb = zzam;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
