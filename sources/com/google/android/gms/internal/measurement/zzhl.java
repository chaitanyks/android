package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzhl extends zzhr {
    private final /* synthetic */ zzhg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzhl(zzhg zzhg) {
        super(zzhg, null);
        this.zza = zzhg;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.android.gms.internal.measurement.zzhr, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhi(this.zza, null);
    }

    /* synthetic */ zzhl(zzhg zzhg, zzhj zzhj) {
        this(zzhg);
    }
}
