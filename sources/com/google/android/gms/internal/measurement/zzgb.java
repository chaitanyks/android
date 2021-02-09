package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzgb extends zzfw {
    private zzgb() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final <L> List<L> zza(Object obj, long j) {
        zzfn zzc = zzc(obj, j);
        if (zzc.zza()) {
            return zzc;
        }
        int size = zzc.size();
        zzfn zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzid.zza(obj, j, zza);
        return zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzfn] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzfn<E> zzc = zzc(obj, j);
        zzfn<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzfn<E> zzfn = zzc;
        zzfn = zzc;
        if (size > 0 && size2 > 0) {
            boolean zza = zzc.zza();
            zzfn<E> zzfn2 = zzc;
            if (!zza) {
                zzfn2 = zzc.zza(size2 + size);
            }
            zzfn2.addAll(zzc2);
            zzfn = zzfn2;
        }
        if (size > 0) {
            zzc2 = zzfn;
        }
        zzid.zza(obj, j, zzc2);
    }

    private static <E> zzfn<E> zzc(Object obj, long j) {
        return (zzfn) zzid.zzf(obj, j);
    }
}
