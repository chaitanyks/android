package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzgi implements zzgj {
    zzgi() {
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Map<?, ?> zza(Object obj) {
        return (zzgg) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final zzgh<?, ?> zzb(Object obj) {
        zzge zzge = (zzge) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Map<?, ?> zzc(Object obj) {
        return (zzgg) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final boolean zzd(Object obj) {
        return !((zzgg) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Object zze(Object obj) {
        ((zzgg) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Object zzf(Object obj) {
        return zzgg.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final Object zza(Object obj, Object obj2) {
        zzgg zzgg = (zzgg) obj;
        zzgg zzgg2 = (zzgg) obj2;
        if (!zzgg2.isEmpty()) {
            if (!zzgg.zzd()) {
                zzgg = zzgg.zzb();
            }
            zzgg.zza(zzgg2);
        }
        return zzgg;
    }

    @Override // com.google.android.gms.internal.measurement.zzgj
    public final int zza(int i, Object obj, Object obj2) {
        zzgg zzgg = (zzgg) obj;
        zzge zzge = (zzge) obj2;
        if (zzgg.isEmpty()) {
            return 0;
        }
        Iterator it = zzgg.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
