package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzkd;
import com.google.android.gms.internal.measurement.zzms;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzn extends zzkk {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzp> zzd;
    private Long zze;
    private Long zzf;

    zzn(zzkj zzkj) {
        super(zzkj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzkk
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x07b0  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x07d6  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0357 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0111  */
    public final List<zzbs.zza> zza(String str, List<zzbs.zzc> list, List<zzbs.zzk> list2, Long l, Long l2) {
        boolean z;
        Map<Integer, List<zzbk.zzb>> emptyMap;
        Map<Integer, zzbs.zzi> zzg;
        zzq zzq;
        boolean zzd2;
        SQLiteException e;
        zzbk.zze next;
        zzaj zzaj;
        zzs zzs;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        ArrayMap arrayMap3;
        Iterator it;
        Map<Integer, zzbs.zzi> map;
        zzbs.zzi zzi;
        List<zzbk.zzb> list3;
        Map<Integer, List<zzbk.zzb>> map2;
        Iterator it2;
        Map<Integer, zzbs.zzi> map3;
        boolean z2;
        Iterator<zzbs.zzj> it3;
        Long l3;
        zzac zzi2;
        String str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zzb = str;
        this.zzc = new HashSet();
        this.zzd = new ArrayMap();
        this.zze = l;
        this.zzf = l2;
        if (zzt().zzd(this.zzb, zzap.zzbk) || zzt().zzd(this.zzb, zzap.zzbl)) {
            Iterator<zzbs.zzc> it4 = list.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if ("_s".equals(it4.next().zzc())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            boolean zzd3 = zzt().zzd(this.zzb, zzap.zzbk);
            boolean zzd4 = zzt().zzd(this.zzb, zzap.zzbl);
            boolean z3 = !zzkd.zzb() && zzt().zzd(this.zzb, zzap.zzbv);
            boolean z4 = !zzkd.zzb() && zzt().zzd(this.zzb, zzap.zzbu);
            if (z && zzd4) {
                zzi2 = zzi();
                str2 = this.zzb;
                zzi2.zzak();
                zzi2.zzd();
                Preconditions.checkNotEmpty(str2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("current_session_count", (Integer) 0);
                zzi2.c_().update("events", contentValues, "app_id = ?", new String[]{str2});
            }
            emptyMap = Collections.emptyMap();
            if (z4 && z3) {
                emptyMap = zzi().zze(this.zzb);
            }
            zzg = zzi().zzg(this.zzb);
            if (zzg != null) {
                zzq = null;
            } else if (zzg.isEmpty()) {
                zzq = null;
            } else {
                HashSet hashSet = new HashSet(zzg.keySet());
                if (!zzd3 || !z) {
                    arrayMap2 = zzg;
                } else {
                    String str3 = this.zzb;
                    Preconditions.checkNotEmpty(str3);
                    Preconditions.checkNotNull(zzg);
                    ArrayMap arrayMap4 = new ArrayMap();
                    if (!zzg.isEmpty()) {
                        Map<Integer, List<Integer>> zzf2 = zzi().zzf(str3);
                        for (Integer num : zzg.keySet()) {
                            int intValue = num.intValue();
                            zzbs.zzi zzi3 = zzg.get(Integer.valueOf(intValue));
                            List<Integer> list4 = zzf2.get(Integer.valueOf(intValue));
                            if (list4 == null || list4.isEmpty()) {
                                arrayMap4.put(Integer.valueOf(intValue), zzi3);
                            } else {
                                List<Long> zza = zzg().zza(zzi3.zzc(), list4);
                                if (!zza.isEmpty()) {
                                    zzbs.zzi.zza zzb2 = ((zzbs.zzi.zza) zzi3.zzbl()).zzb().zzb(zza);
                                    zzb2.zza().zza(zzg().zza(zzi3.zza(), list4));
                                    for (int i = 0; i < zzi3.zzf(); i++) {
                                        if (list4.contains(Integer.valueOf(zzi3.zza(i).zzb()))) {
                                            zzb2.zza(i);
                                        }
                                    }
                                    for (int i2 = 0; i2 < zzi3.zzh(); i2++) {
                                        if (list4.contains(Integer.valueOf(zzi3.zzb(i2).zzb()))) {
                                            zzb2.zzb(i2);
                                        }
                                    }
                                    arrayMap4.put(Integer.valueOf(intValue), (zzbs.zzi) ((zzfe) zzb2.zzv()));
                                }
                            }
                        }
                    }
                    arrayMap2 = arrayMap4;
                }
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    int intValue2 = ((Integer) it5.next()).intValue();
                    zzbs.zzi zzi4 = arrayMap2.get(Integer.valueOf(intValue2));
                    BitSet bitSet = new BitSet();
                    BitSet bitSet2 = new BitSet();
                    ArrayMap arrayMap5 = new ArrayMap();
                    if (!(zzi4 == null || zzi4.zzf() == 0)) {
                        for (zzbs.zzb zzb3 : zzi4.zze()) {
                            if (zzb3.zza()) {
                                Integer valueOf = Integer.valueOf(zzb3.zzb());
                                if (zzb3.zzc()) {
                                    l3 = Long.valueOf(zzb3.zzd());
                                } else {
                                    l3 = null;
                                }
                                arrayMap5.put(valueOf, l3);
                            }
                        }
                    }
                    if (zzms.zzb()) {
                        if (zzt().zzd(this.zzb, zzap.zzbr)) {
                            ArrayMap arrayMap6 = new ArrayMap();
                            if (zzi4 != null) {
                                if (zzi4.zzh() != 0) {
                                    Iterator<zzbs.zzj> it6 = zzi4.zzg().iterator();
                                    while (it6.hasNext()) {
                                        zzbs.zzj next2 = it6.next();
                                        if (!next2.zza() || next2.zzd() <= 0) {
                                            it3 = it6;
                                        } else {
                                            it3 = it6;
                                            arrayMap6.put(Integer.valueOf(next2.zzb()), Long.valueOf(next2.zza(next2.zzd() - 1)));
                                        }
                                        it6 = it3;
                                    }
                                }
                            }
                            arrayMap3 = arrayMap6;
                            if (zzi4 == null) {
                                int i3 = 0;
                                while (i3 < (zzi4.zzb() << 6)) {
                                    if (zzkr.zza(zzi4.zza(), i3)) {
                                        map3 = arrayMap2;
                                        it2 = it5;
                                        zzr().zzx().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i3));
                                        bitSet2.set(i3);
                                        if (zzkr.zza(zzi4.zzc(), i3)) {
                                            bitSet.set(i3);
                                            z2 = true;
                                            if (z2) {
                                                arrayMap5.remove(Integer.valueOf(i3));
                                            }
                                            i3++;
                                            it5 = it2;
                                            arrayMap2 = map3;
                                        }
                                    } else {
                                        map3 = arrayMap2;
                                        it2 = it5;
                                    }
                                    z2 = false;
                                    if (z2) {
                                    }
                                    i3++;
                                    it5 = it2;
                                    arrayMap2 = map3;
                                }
                                map = arrayMap2;
                                it = it5;
                            } else {
                                map = arrayMap2;
                                it = it5;
                            }
                            if (!zzd3) {
                                zzi = zzg.get(Integer.valueOf(intValue2));
                            } else {
                                zzi = zzi4;
                            }
                            if (!(!z4 || !z3 || (list3 = emptyMap.get(Integer.valueOf(intValue2))) == null || this.zzf == null || this.zze == null)) {
                                for (zzbk.zzb zzb4 : list3) {
                                    int zzb5 = zzb4.zzb();
                                    long longValue = this.zzf.longValue() / 1000;
                                    if (zzb4.zzi()) {
                                        longValue = this.zze.longValue() / 1000;
                                    }
                                    if (arrayMap5.containsKey(Integer.valueOf(zzb5))) {
                                        map2 = emptyMap;
                                        arrayMap5.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                                    } else {
                                        map2 = emptyMap;
                                    }
                                    if (arrayMap3.containsKey(Integer.valueOf(zzb5))) {
                                        arrayMap3.put(Integer.valueOf(zzb5), Long.valueOf(longValue));
                                    }
                                    emptyMap = map2;
                                }
                            }
                            this.zzd.put(Integer.valueOf(intValue2), new zzp(this, this.zzb, zzi, bitSet, bitSet2, arrayMap5, arrayMap3, null));
                            it5 = it;
                            arrayMap2 = map;
                            emptyMap = emptyMap;
                            zzg = zzg;
                        }
                    }
                    arrayMap3 = null;
                    if (zzi4 == null) {
                    }
                    if (!zzd3) {
                    }
                    while (r1.hasNext()) {
                    }
                    this.zzd.put(Integer.valueOf(intValue2), new zzp(this, this.zzb, zzi, bitSet, bitSet2, arrayMap5, arrayMap3, null));
                    it5 = it;
                    arrayMap2 = map;
                    emptyMap = emptyMap;
                    zzg = zzg;
                }
                zzq = null;
            }
            if (!list.isEmpty()) {
                zzs zzs2 = new zzs(this, zzq);
                ArrayMap arrayMap7 = new ArrayMap();
                for (zzbs.zzc zzc2 : list) {
                    zzbs.zzc zza2 = zzs2.zza(this.zzb, zzc2);
                    if (zza2 != null) {
                        zzac zzi5 = zzi();
                        String str4 = this.zzb;
                        String zzc3 = zza2.zzc();
                        boolean zzd5 = zzi5.zzt().zzd(str4, zzap.zzbl);
                        zzaj zza3 = zzi5.zza(str4, zzc2.zzc());
                        if (zza3 == null) {
                            zzi5.zzr().zzi().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfb.zza(str4), zzi5.zzo().zza(zzc3));
                            if (zzd5) {
                                zzaj = new zzaj(str4, zzc2.zzc(), 1, 1, 1, zzc2.zze(), 0, null, null, null, null);
                            } else {
                                zzaj = new zzaj(str4, zzc2.zzc(), 1, 1, zzc2.zze(), 0, null, null, null, null);
                            }
                        } else if (zzd5) {
                            zzaj = new zzaj(zza3.zza, zza3.zzb, zza3.zzc + 1, zza3.zzd + 1, zza3.zze + 1, zza3.zzf, zza3.zzg, zza3.zzh, zza3.zzi, zza3.zzj, zza3.zzk);
                        } else {
                            zzaj = new zzaj(zza3.zza, zza3.zzb, zza3.zzc + 1, zza3.zzd + 1, zza3.zze, zza3.zzf, zza3.zzg, zza3.zzh, zza3.zzi, zza3.zzj, zza3.zzk);
                        }
                        zzi().zza(zzaj);
                        long j = zzaj.zzc;
                        String zzc4 = zza2.zzc();
                        Map<Integer, List<zzbk.zzb>> map4 = (Map) arrayMap7.get(zzc4);
                        if (map4 == null) {
                            map4 = zzi().zzf(this.zzb, zzc4);
                            if (map4 == null) {
                                map4 = new ArrayMap<>();
                            }
                            arrayMap7.put(zzc4, map4);
                        }
                        for (Integer num2 : map4.keySet()) {
                            int intValue3 = num2.intValue();
                            if (this.zzc.contains(Integer.valueOf(intValue3))) {
                                zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(intValue3));
                            } else {
                                Iterator<zzbk.zzb> it7 = map4.get(Integer.valueOf(intValue3)).iterator();
                                boolean z5 = true;
                                while (true) {
                                    if (!it7.hasNext()) {
                                        zzs = zzs2;
                                        arrayMap = arrayMap7;
                                        break;
                                    }
                                    zzbk.zzb next3 = it7.next();
                                    zzr zzr = new zzr(this, this.zzb, intValue3, next3);
                                    zzs = zzs2;
                                    z5 = zzr.zza(this.zze, this.zzf, zza2, j, zzaj, zza(intValue3, next3.zzb()));
                                    arrayMap = arrayMap7;
                                    if (zzt().zzd(this.zzb, zzap.zzbs) && !z5) {
                                        this.zzc.add(Integer.valueOf(intValue3));
                                        break;
                                    }
                                    zza(intValue3).zza(zzr);
                                    zzs2 = zzs;
                                    arrayMap7 = arrayMap;
                                }
                                if (!z5) {
                                    this.zzc.add(Integer.valueOf(intValue3));
                                }
                                zzs2 = zzs;
                                arrayMap7 = arrayMap;
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (!list2.isEmpty()) {
                ArrayMap arrayMap8 = new ArrayMap();
                for (zzbs.zzk zzk : list2) {
                    arrayList.add(zzk.zzc());
                    String zzc5 = zzk.zzc();
                    Map<Integer, List<zzbk.zze>> map5 = (Map) arrayMap8.get(zzc5);
                    if (map5 == null) {
                        map5 = zzi().zzg(this.zzb, zzc5);
                        if (map5 == null) {
                            map5 = new ArrayMap<>();
                        }
                        arrayMap8.put(zzc5, map5);
                    }
                    Iterator<Integer> it8 = map5.keySet().iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        int intValue4 = it8.next().intValue();
                        if (this.zzc.contains(Integer.valueOf(intValue4))) {
                            zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(intValue4));
                            break;
                        }
                        Iterator<zzbk.zze> it9 = map5.get(Integer.valueOf(intValue4)).iterator();
                        boolean z6 = true;
                        while (true) {
                            if (!it9.hasNext()) {
                                break;
                            }
                            next = it9.next();
                            if (zzr().zza(2)) {
                                zzr().zzx().zza("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), next.zza() ? Integer.valueOf(next.zzb()) : null, zzo().zzc(next.zzc()));
                                zzr().zzx().zza("Filter definition", zzg().zza(next));
                            }
                            if (next.zza() && next.zzb() <= 256) {
                                zzt zzt = new zzt(this, this.zzb, intValue4, next);
                                z6 = zzt.zza(this.zze, this.zzf, zzk, zza(intValue4, next.zzb()));
                                if (zzt().zzd(this.zzb, zzap.zzbs) && !z6) {
                                    this.zzc.add(Integer.valueOf(intValue4));
                                    break;
                                }
                                zza(intValue4).zza(zzt);
                            }
                        }
                        zzr().zzi().zza("Invalid property filter ID. appId, id", zzfb.zza(this.zzb), String.valueOf(next.zza() ? Integer.valueOf(next.zzb()) : null));
                        z6 = false;
                        if (!z6) {
                            this.zzc.add(Integer.valueOf(intValue4));
                        }
                    }
                }
            }
            zzd2 = zzt().zzd(this.zzb, zzap.zzbq);
            Map<Integer, List<Integer>> arrayMap9 = new ArrayMap<>();
            if (zzd2) {
                arrayMap9 = zzi().zza(this.zzb, arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Set<Integer> keySet = this.zzd.keySet();
            keySet.removeAll(this.zzc);
            for (Integer num3 : keySet) {
                int intValue5 = num3.intValue();
                zzbs.zza zza4 = this.zzd.get(Integer.valueOf(intValue5)).zza(intValue5, arrayMap9.get(Integer.valueOf(intValue5)));
                arrayList2.add(zza4);
                zzac zzi6 = zzi();
                String str5 = this.zzb;
                zzbs.zzi zzc6 = zza4.zzc();
                zzi6.zzak();
                zzi6.zzd();
                Preconditions.checkNotEmpty(str5);
                Preconditions.checkNotNull(zzc6);
                byte[] zzbi = zzc6.zzbi();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str5);
                contentValues2.put("audience_id", Integer.valueOf(intValue5));
                contentValues2.put("current_results", zzbi);
                try {
                    try {
                        if (zzi6.c_().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                            zzi6.zzr().zzf().zza("Failed to insert filter results (got -1). appId", zzfb.zza(str5));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzi6.zzr().zzf().zza("Error storing filter results. appId", zzfb.zza(str5), e);
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    zzi6.zzr().zzf().zza("Error storing filter results. appId", zzfb.zza(str5), e);
                }
            }
            return arrayList2;
        }
        z = false;
        boolean zzd32 = zzt().zzd(this.zzb, zzap.zzbk);
        boolean zzd42 = zzt().zzd(this.zzb, zzap.zzbl);
        if (!zzkd.zzb()) {
        }
        if (!zzkd.zzb()) {
        }
        zzi2 = zzi();
        str2 = this.zzb;
        zzi2.zzak();
        zzi2.zzd();
        Preconditions.checkNotEmpty(str2);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("current_session_count", (Integer) 0);
        try {
            zzi2.c_().update("events", contentValues3, "app_id = ?", new String[]{str2});
        } catch (SQLiteException e4) {
            zzi2.zzr().zzf().zza("Error resetting session-scoped event counts. appId", zzfb.zza(str2), e4);
        }
        emptyMap = Collections.emptyMap();
        emptyMap = zzi().zze(this.zzb);
        zzg = zzi().zzg(this.zzb);
        if (zzg != null) {
        }
        if (!list.isEmpty()) {
        }
        ArrayList arrayList3 = new ArrayList();
        if (!list2.isEmpty()) {
        }
        zzd2 = zzt().zzd(this.zzb, zzap.zzbq);
        Map<Integer, List<Integer>> arrayMap92 = new ArrayMap<>();
        if (zzd2) {
        }
        ArrayList arrayList22 = new ArrayList();
        Set<Integer> keySet2 = this.zzd.keySet();
        keySet2.removeAll(this.zzc);
        while (r3.hasNext()) {
        }
        return arrayList22;
    }

    private final zzp zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzp zzp = new zzp(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzp);
        return zzp;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return zzp.zza(this.zzd.get(Integer.valueOf(i))).get(i2);
    }
}
