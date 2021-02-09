package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzdy implements Comparator<zzdw> {
    zzdy() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdw zzdw, zzdw zzdw2) {
        zzdw zzdw3 = zzdw;
        zzdw zzdw4 = zzdw2;
        zzeb zzeb = (zzeb) zzdw3.iterator();
        zzeb zzeb2 = (zzeb) zzdw4.iterator();
        while (zzeb.hasNext() && zzeb2.hasNext()) {
            int compare = Integer.compare(zzdw.zzb(zzeb.zza()), zzdw.zzb(zzeb2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdw3.zza(), zzdw4.zza());
    }
}
