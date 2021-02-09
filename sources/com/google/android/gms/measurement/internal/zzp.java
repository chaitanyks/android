package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzkd;
import com.google.android.gms.internal.measurement.zzms;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzp {
    private String zza;
    private boolean zzb;
    private zzbs.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzn zzh;

    private zzp(zzn zzn, String str) {
        this.zzh = zzn;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzp(zzn zzn, String str, zzbs.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzn;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    public final void zza(zzu zzu) {
        int zza2 = zzu.zza();
        if (zzu.zzc != null) {
            this.zze.set(zza2, zzu.zzc.booleanValue());
        }
        if (zzu.zzd != null) {
            this.zzd.set(zza2, zzu.zzd.booleanValue());
        }
        if (zzu.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzu.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzu.zzf != null) {
            List<Long> list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList<>();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzms.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbr) && zzu.zzb()) {
                list.clear();
            }
            if (zzkd.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbv) && zzu.zzc()) {
                list.clear();
            }
            if (!zzkd.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbv)) {
                list.add(Long.valueOf(zzu.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzu.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x00e0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f5, code lost:
        if (r17.zzh.zzt().zzd(r17.zza, com.google.android.gms.measurement.internal.zzap.zzbr) == false) goto L_0x00f7;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final zzbs.zza zza(int i, List<Integer> list) {
        ArrayList arrayList;
        ?? r4;
        ArrayList arrayList2;
        zzbs.zza.C0003zza zzh2 = zzbs.zza.zzh();
        zzh2.zza(i);
        zzh2.zza(this.zzb);
        zzbs.zzi zzi = this.zzc;
        if (zzi != null) {
            zzh2.zza(zzi);
        }
        zzbs.zzi.zza zza2 = zzbs.zzi.zzi().zzb(zzkr.zza(this.zzd)).zza(zzkr.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer num : this.zzf.keySet()) {
                int intValue = num.intValue();
                arrayList.add((zzbs.zzb) ((zzfe) zzbs.zzb.zze().zza(intValue).zza(this.zzf.get(Integer.valueOf(intValue)).longValue()).zzv()));
            }
        }
        zza2.zzc(arrayList);
        if (this.zzg == null) {
            r4 = Collections.emptyList();
        } else {
            r4 = new ArrayList(this.zzg.size());
            for (Integer num2 : this.zzg.keySet()) {
                zzbs.zzj.zza zza3 = zzbs.zzj.zze().zza(num2.intValue());
                List<Long> list2 = this.zzg.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza3.zza(list2);
                }
                r4.add((zzbs.zzj) ((zzfe) zza3.zzv()));
            }
        }
        if (zzms.zzb()) {
            arrayList2 = r4;
        }
        arrayList2 = r4;
        if (zzh2.zza()) {
            List<zzbs.zzj> zzg2 = zzh2.zzb().zzg();
            arrayList2 = r4;
            if (!zzg2.isEmpty()) {
                ArrayList arrayList3 = new ArrayList((Collection) r4);
                ArrayMap arrayMap = new ArrayMap();
                for (zzbs.zzj zzj : zzg2) {
                    if (zzj.zza() && zzj.zzd() > 0) {
                        arrayMap.put(Integer.valueOf(zzj.zzb()), Long.valueOf(zzj.zza(zzj.zzd() - 1)));
                    }
                }
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    zzbs.zzj zzj2 = (zzbs.zzj) arrayList3.get(i2);
                    Long l = (Long) arrayMap.remove(zzj2.zza() ? Integer.valueOf(zzj2.zzb()) : null);
                    if (l != null && (list == null || !list.contains(Integer.valueOf(zzj2.zzb())))) {
                        ArrayList arrayList4 = new ArrayList();
                        if (l.longValue() < zzj2.zza(0)) {
                            arrayList4.add(l);
                        }
                        arrayList4.addAll(zzj2.zzc());
                        arrayList3.set(i2, (zzbs.zzj) ((zzfe) ((zzbs.zzj.zza) zzj2.zzbl()).zza().zza(arrayList4).zzv()));
                    }
                }
                for (Integer num3 : arrayMap.keySet()) {
                    arrayList3.add((zzbs.zzj) ((zzfe) zzbs.zzj.zze().zza(num3.intValue()).zza(((Long) arrayMap.get(num3)).longValue()).zzv()));
                }
                arrayList2 = arrayList3;
            }
        }
        zza2.zzd(arrayList2);
        zzh2.zza(zza2);
        return (zzbs.zza) ((zzfe) zzh2.zzv());
    }

    /* synthetic */ zzp(zzn zzn, String str, zzbs.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzq) {
        this(zzn, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzp(zzn zzn, String str, zzq zzq) {
        this(zzn, str);
    }
}
