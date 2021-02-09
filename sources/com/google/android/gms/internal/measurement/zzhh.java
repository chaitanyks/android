package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzhh {
    private static final Class<?> zza = zzd();
    private static final zzhx<?, ?> zzb = zza(false);
    private static final zzhx<?, ?> zzc = zza(true);
    private static final zzhx<?, ?> zzd = new zzhz();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfe.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zziq zziq, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zziq zziq) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdw> list, zziq zziq) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zziq zziq, zzhf zzhf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zza(i, list, zzhf);
        }
    }

    public static void zzb(int i, List<?> list, zziq zziq, zzhf zzhf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zziq.zzb(i, list, zzhf);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzga) {
            zzga zzga = (zzga) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzd(zzga.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzel.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzga) {
            zzga zzga = (zzga) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zze(zzga.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzel.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzga) {
            zzga zzga = (zzga) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzf(zzga.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzel.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzk(zzff.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzel.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzf(zzff.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzel.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzg(zzff.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzel.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzel.zzh(zzff.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzel.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzel.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzel.zze(i) * size;
        if (list instanceof zzfx) {
            zzfx zzfx = (zzfx) list;
            while (i4 < size) {
                Object zzb2 = zzfx.zzb(i4);
                if (zzb2 instanceof zzdw) {
                    i3 = zzel.zzb((zzdw) zzb2);
                } else {
                    i3 = zzel.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdw) {
                    i2 = zzel.zzb((zzdw) obj);
                } else {
                    i2 = zzel.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzhf zzhf) {
        if (obj instanceof zzfv) {
            return zzel.zza(i, (zzfv) obj);
        }
        return zzel.zzb(i, (zzgm) obj, zzhf);
    }

    static int zza(int i, List<?> list, zzhf zzhf) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzel.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfv) {
                i2 = zzel.zza((zzfv) obj);
            } else {
                i2 = zzel.zza((zzgm) obj, zzhf);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzdw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzel.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzel.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzgm> list, zzhf zzhf) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzel.zzc(i, list.get(i3), zzhf);
        }
        return i2;
    }

    public static zzhx<?, ?> zza() {
        return zzb;
    }

    public static zzhx<?, ?> zzb() {
        return zzc;
    }

    public static zzhx<?, ?> zzc() {
        return zzd;
    }

    private static zzhx<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzhx) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgj zzgj, T t, T t2, long j) {
        zzid.zza(t, j, zzgj.zza(zzid.zzf(t, j), zzid.zzf(t2, j)));
    }

    static <T, FT extends zzew<FT>> void zza(zzet<FT> zzet, T t, T t2) {
        zzeu<FT> zza2 = zzet.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzet.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzhx<UT, UB> zzhx, T t, T t2) {
        zzhx.zza(t, zzhx.zzc(zzhx.zzb(t), zzhx.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfi zzfi, UB ub, zzhx<UT, UB> zzhx) {
        if (zzfi == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzfi.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzhx);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzfi.zza(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzhx);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzhx<UT, UB> zzhx) {
        if (ub == null) {
            ub = zzhx.zza();
        }
        zzhx.zza(ub, i, (long) i2);
        return ub;
    }
}
