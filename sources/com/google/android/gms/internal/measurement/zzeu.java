package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzew;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzeu<T extends zzew<T>> {
    private static final zzeu zzd = new zzeu(true);
    final zzhg<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzeu() {
        this.zza = zzhg.zza(16);
    }

    private zzeu(boolean z) {
        this(zzhg.zza(0));
        zzb();
    }

    private zzeu(zzhg<T, Object> zzhg) {
        this.zza = zzhg;
        zzb();
    }

    public static <T extends zzew<T>> zzeu<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeu)) {
            return false;
        }
        return this.zza.equals(((zzeu) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfs(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfs(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfr)) {
            return obj;
        }
        zzfr zzfr = (zzfr) obj;
        return zzfr.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfr) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzik zzik, Object obj) {
        zzfh.zza(obj);
        boolean z = true;
        switch (zzex.zza[zzik.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdw) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfg)) {
                    z = false;
                    break;
                }
            case 9:
                if (!(obj instanceof zzgm) && !(obj instanceof zzfr)) {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzew<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzir.MESSAGE) {
            if (key.zzd()) {
                for (zzgm zzgm : (List) entry.getValue()) {
                    if (!zzgm.g_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgm) {
                    if (!((zzgm) value).g_()) {
                        return false;
                    }
                } else if (value instanceof zzfr) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzeu<T> zzeu) {
        for (int i = 0; i < zzeu.zza.zzc(); i++) {
            zzb(zzeu.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzeu.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgv) {
            return ((zzgv) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzgm zzgm;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfr) {
            zzfr zzfr = (zzfr) value;
            value = zzfr.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzew) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.put(key, zza2);
        } else if (key.zzc() == zzir.MESSAGE) {
            Object zza3 = zza((zzew) key);
            if (zza3 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (zza3 instanceof zzgv) {
                zzgm = key.zza((zzgv) zza3, (zzgv) value);
            } else {
                zzgm = key.zza(((zzgm) zza3).zzbq(), (zzgm) value).zzv();
            }
            this.zza.put(key, zzgm);
        } else {
            this.zza.put(key, zza(value));
        }
    }

    static void zza(zzel zzel, zzik zzik, int i, Object obj) throws IOException {
        if (zzik == zzik.GROUP) {
            zzgm zzgm = (zzgm) obj;
            zzfh.zza(zzgm);
            zzel.zza(i, 3);
            zzgm.zza(zzel);
            zzel.zza(i, 4);
            return;
        }
        zzel.zza(i, zzik.zzb());
        switch (zzex.zzb[zzik.ordinal()]) {
            case 1:
                zzel.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzel.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzel.zza(((Long) obj).longValue());
                return;
            case 4:
                zzel.zza(((Long) obj).longValue());
                return;
            case 5:
                zzel.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzel.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzel.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzel.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgm) obj).zza(zzel);
                return;
            case 10:
                zzel.zza((zzgm) obj);
                return;
            case 11:
                if (obj instanceof zzdw) {
                    zzel.zza((zzdw) obj);
                    return;
                } else {
                    zzel.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdw) {
                    zzel.zza((zzdw) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzel.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzel.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzel.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzel.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzel.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzel.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfg) {
                    zzel.zza(((zzfg) obj).zza());
                    return;
                } else {
                    zzel.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzir.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzew<?>) key, value);
        }
        if (value instanceof zzfr) {
            return zzel.zzb(entry.getKey().zza(), (zzfr) value);
        }
        return zzel.zzb(entry.getKey().zza(), (zzgm) value);
    }

    static int zza(zzik zzik, int i, Object obj) {
        int zze = zzel.zze(i);
        if (zzik == zzik.GROUP) {
            zzfh.zza((zzgm) obj);
            zze <<= 1;
        }
        return zze + zzb(zzik, obj);
    }

    private static int zzb(zzik zzik, Object obj) {
        switch (zzex.zzb[zzik.ordinal()]) {
            case 1:
                return zzel.zzb(((Double) obj).doubleValue());
            case 2:
                return zzel.zzb(((Float) obj).floatValue());
            case 3:
                return zzel.zzd(((Long) obj).longValue());
            case 4:
                return zzel.zze(((Long) obj).longValue());
            case 5:
                return zzel.zzf(((Integer) obj).intValue());
            case 6:
                return zzel.zzg(((Long) obj).longValue());
            case 7:
                return zzel.zzi(((Integer) obj).intValue());
            case 8:
                return zzel.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzel.zzc((zzgm) obj);
            case 10:
                if (obj instanceof zzfr) {
                    return zzel.zza((zzfr) obj);
                }
                return zzel.zzb((zzgm) obj);
            case 11:
                if (obj instanceof zzdw) {
                    return zzel.zzb((zzdw) obj);
                }
                return zzel.zzb((String) obj);
            case 12:
                if (obj instanceof zzdw) {
                    return zzel.zzb((zzdw) obj);
                }
                return zzel.zzb((byte[]) obj);
            case 13:
                return zzel.zzg(((Integer) obj).intValue());
            case 14:
                return zzel.zzj(((Integer) obj).intValue());
            case 15:
                return zzel.zzh(((Long) obj).longValue());
            case 16:
                return zzel.zzh(((Integer) obj).intValue());
            case 17:
                return zzel.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfg) {
                    return zzel.zzk(((zzfg) obj).zza());
                }
                return zzel.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzew<?> zzew, Object obj) {
        zzik zzb2 = zzew.zzb();
        int zza2 = zzew.zza();
        if (!zzew.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzew.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzel.zze(zza2) + i + zzel.zzl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeu zzeu = new zzeu();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzeu.zzb(zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzeu.zzb(entry.getKey(), entry.getValue());
        }
        zzeu.zzc = this.zzc;
        return zzeu;
    }
}
