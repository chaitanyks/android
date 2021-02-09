package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzfy extends zzfw {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfy() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzid.zzf(obj, j);
        if (list instanceof zzfx) {
            obj2 = ((zzfx) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzgy) || !(list instanceof zzfn)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzfn zzfn = (zzfn) list;
                if (zzfn.zza()) {
                    zzfn.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzid.zza(obj, j, obj2);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzfx) {
                list = new zzfu(i);
            } else if (!(zzc instanceof zzgy) || !(zzc instanceof zzfn)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzfn) zzc).zza(i);
            }
            zzid.zza(obj, j, list);
            return list;
        } else if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzid.zza(obj, j, arrayList);
            return arrayList;
        } else if (zzc instanceof zzhy) {
            zzfu zzfu = new zzfu(zzc.size() + i);
            zzfu.addAll((zzhy) zzc);
            zzid.zza(obj, j, zzfu);
            return zzfu;
        } else if (!(zzc instanceof zzgy) || !(zzc instanceof zzfn)) {
            return zzc;
        } else {
            zzfn zzfn = (zzfn) zzc;
            if (zzfn.zza()) {
                return zzc;
            }
            zzfn zza2 = zzfn.zza(zzc.size() + i);
            zzid.zza(obj, j, zza2);
            return zza2;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzfw
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzid.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzid.zzf(obj, j);
    }
}
