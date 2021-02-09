package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzgp;
import com.google.android.gms.internal.measurement.zzjg;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzkr extends zzkk {
    zzkr(zzkj zzkj) {
        super(zzkj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzkk
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbs.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbs.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    static zzbs.zze zza(zzbs.zzc zzc, String str) {
        for (zzbs.zze zze : zzc.zza()) {
            if (zze.zzb().equals(str)) {
                return zze;
            }
        }
        return null;
    }

    static Object zzb(zzbs.zzc zzc, String str) {
        zzbs.zze zza = zza(zzc, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzc()) {
            return zza.zzd();
        }
        if (zza.zze()) {
            return Long.valueOf(zza.zzf());
        }
        if (zza.zzg()) {
            return Double.valueOf(zza.zzh());
        }
        return null;
    }

    static void zza(zzbs.zzc.zza zza, String str, Object obj) {
        List<zzbs.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzbs.zze.zza zza3 = zzbs.zze.zzk().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbs.zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzbs.zzg zzg : zzf.zza()) {
            if (zzg != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzg.zza()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzg.zzb()));
                }
                zza(sb, 1, "platform", zzg.zzq());
                if (zzg.zzz()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzg.zzaa()));
                }
                if (zzg.zzab()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzg.zzac()));
                }
                if (zzg.zzbc()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzg.zzbd()));
                }
                if (zzg.zzau()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzg.zzav()));
                }
                zza(sb, 1, "gmp_app_id", zzg.zzam());
                zza(sb, 1, "admob_app_id", zzg.zzbb());
                zza(sb, 1, "app_id", zzg.zzx());
                zza(sb, 1, "app_version", zzg.zzy());
                if (zzg.zzar()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzg.zzas()));
                }
                zza(sb, 1, "firebase_instance_id", zzg.zzaq());
                if (zzg.zzah()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzg.zzai()));
                }
                zza(sb, 1, "app_store", zzg.zzw());
                if (zzg.zzg()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzg.zzh()));
                }
                if (zzg.zzi()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzg.zzj()));
                }
                if (zzg.zzk()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzg.zzl()));
                }
                if (zzg.zzm()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzg.zzn()));
                }
                if (zzg.zzo()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzg.zzp()));
                }
                zza(sb, 1, "app_instance_id", zzg.zzag());
                zza(sb, 1, "resettable_device_id", zzg.zzad());
                zza(sb, 1, "device_id", zzg.zzat());
                zza(sb, 1, "ds_id", zzg.zzay());
                if (zzg.zzae()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzg.zzaf()));
                }
                zza(sb, 1, "os_version", zzg.zzr());
                zza(sb, 1, "device_model", zzg.zzs());
                zza(sb, 1, "user_default_language", zzg.zzt());
                if (zzg.zzu()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzg.zzv()));
                }
                if (zzg.zzaj()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzg.zzak()));
                }
                if (zzg.zzan()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzg.zzao()));
                }
                zza(sb, 1, "health_monitor", zzg.zzal());
                if (zzg.zzaw() && zzg.zzax() != 0) {
                    zza(sb, 1, "android_id", Long.valueOf(zzg.zzax()));
                }
                if (zzg.zzaz()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzg.zzba()));
                }
                List<zzbs.zzk> zze = zzg.zze();
                if (zze != null) {
                    for (zzbs.zzk zzk : zze) {
                        if (zzk != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            Double d = null;
                            zza(sb, 2, "set_timestamp_millis", zzk.zza() ? Long.valueOf(zzk.zzb()) : null);
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzo().zzc(zzk.zzc()));
                            zza(sb, 2, "string_value", zzk.zze());
                            zza(sb, 2, "int_value", zzk.zzf() ? Long.valueOf(zzk.zzg()) : null);
                            if (zzk.zzh()) {
                                d = Double.valueOf(zzk.zzi());
                            }
                            zza(sb, 2, "double_value", d);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbs.zza> zzap = zzg.zzap();
                String zzx = zzg.zzx();
                if (zzap != null) {
                    for (zzbs.zza zza : zzap) {
                        if (zza != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zza.zza()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zza.zzb()));
                            }
                            if (zza.zzf()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zza.zzg()));
                            }
                            zza(sb, 2, "current_data", zza.zzc(), zzx);
                            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zza.zzd()) {
                                zza(sb, 2, "previous_data", zza.zze(), zzx);
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbs.zzc> zzc = zzg.zzc();
                if (zzc != null) {
                    for (zzbs.zzc zzc2 : zzc) {
                        if (zzc2 != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzo().zza(zzc2.zzc()));
                            if (zzc2.zzd()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzc2.zze()));
                            }
                            if (zzc2.zzf()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzc2.zzg()));
                            }
                            if (zzc2.zzh()) {
                                zza(sb, 2, "count", Integer.valueOf(zzc2.zzi()));
                            }
                            if (zzc2.zzb() != 0) {
                                zza(sb, 2, zzc2.zza());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbk.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzb.zza()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzb.zzb()));
        }
        zza(sb, 0, "event_name", zzo().zza(zzb.zzc()));
        String zza = zza(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzb.zzf()) {
            zza(sb, 1, "event_count_filter", zzb.zzg());
        }
        if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzb.zze() > 0) {
            sb.append("  filters {\n");
            for (zzbk.zzc zzc : zzb.zzd()) {
                zza(sb, 2, zzc);
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbk.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zze.zza()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zze.zzb()));
        }
        zza(sb, 0, "property_name", zzo().zzc(zze.zzc()));
        String zza = zza(zze.zze(), zze.zzf(), zze.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        zza(sb, 1, zze.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void zza(StringBuilder sb, int i, List<zzbs.zze> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzbs.zze zze : list) {
                if (zze != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    if (!zzjr.zzb() || !zzt().zza(zzap.zzcy)) {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzo().zzb(zze.zzb()));
                        zza(sb, i2, "string_value", zze.zzd());
                        zza(sb, i2, "int_value", zze.zze() ? Long.valueOf(zze.zzf()) : null);
                        if (zze.zzg()) {
                            d = Double.valueOf(zze.zzh());
                        }
                        zza(sb, i2, "double_value", d);
                    } else {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, zze.zza() ? zzo().zzb(zze.zzb()) : null);
                        zza(sb, i2, "string_value", zze.zzc() ? zze.zzd() : null);
                        zza(sb, i2, "int_value", zze.zze() ? Long.valueOf(zze.zzf()) : null);
                        if (zze.zzg()) {
                            d = Double.valueOf(zze.zzh());
                        }
                        zza(sb, i2, "double_value", d);
                        if (zze.zzj() > 0) {
                            zza(sb, i2, zze.zzi());
                        }
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzbs.zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append('\n');
            }
            if (zzi.zzb() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append('\n');
            }
            if (zzi.zzf() != 0) {
                zza(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzbs.zzb zzb : zzi.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzb.zza() ? Integer.valueOf(zzb.zzb()) : null);
                    sb.append(":");
                    sb.append(zzb.zzc() ? Long.valueOf(zzb.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzi.zzh() != 0) {
                zza(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzbs.zzj zzj : zzi.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzj.zza() ? Integer.valueOf(zzj.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long l3 : zzj.zzc()) {
                        long longValue = l3.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzbk.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                zza(sb, i, "comparison_type", zzd.zzb().name());
            }
            if (zzd.zzc()) {
                zza(sb, i, "match_as_float", Boolean.valueOf(zzd.zzd()));
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzd.zze()) {
                zza(sb, i, "comparison_value", zzd.zzf());
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzd.zzg()) {
                zza(sb, i, "min_comparison_value", zzd.zzh());
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzd.zzi()) {
                zza(sb, i, "max_comparison_value", zzd.zzj());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzbk.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                zza(sb, i, "complement", Boolean.valueOf(zzc.zzf()));
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzc.zzg()) {
                zza(sb, i, "param_name", zzo().zzb(zzc.zzh()));
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzc.zza()) {
                int i2 = i + 1;
                zzbk.zzf zzb = zzc.zzb();
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (zzb.zza()) {
                        zza(sb, i2, "match_type", zzb.zzb().name());
                    }
                    if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzb.zzc()) {
                        zza(sb, i2, "expression", zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zza(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zza(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String str : zzb.zzg()) {
                            zza(sb, i2 + 2);
                            sb.append(str);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
            if (!zzkw.zzb() || !zzt().zza(zzap.zzcx) || zzc.zzc()) {
                zza(sb, i + 1, "number_filter", zzc.zzd());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append('\n');
        }
    }

    /* access modifiers changed from: package-private */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException e) {
            zzr().zzf().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzan zzan, zzm zzm) {
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotNull(zzm);
        if (!zzjg.zzb() || !zzt().zza(zzap.zzcm)) {
            if (!TextUtils.isEmpty(zzm.zzb) || !TextUtils.isEmpty(zzm.zzr)) {
                return true;
            }
            zzu();
            return false;
        } else if (!TextUtils.isEmpty(zzm.zzb) || !TextUtils.isEmpty(zzm.zzr)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean zza(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzr().zzi().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzr().zzi().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (size2 >= 0 && ((Long) arrayList.get(size2)).longValue() == 0) {
            size = size2;
            size2--;
        }
        return arrayList.subList(0, size);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzm().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzp().zzd();
        MessageDigest zzi = zzkv.zzi();
        if (zzi != null) {
            return zzkv.zza(zzi.digest(bArr));
        }
        zzr().zzf().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzr().zzf().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzr().zzf().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<Integer> zzf() {
        Map<String, String> zza = zzap.zza(this.zza.zzn());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzap.zzal.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            if (next.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzr().zzi().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzr().zzi().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    static <Builder extends zzgp> Builder zza(Builder builder, byte[] bArr) throws zzfm {
        zzer zzb = zzer.zzb();
        return zzb != null ? (Builder) builder.zza(bArr, zzb) : (Builder) builder.zza(bArr);
    }

    static int zza(zzbs.zzg.zza zza, String str) {
        if (zza == null) {
            return -1;
        }
        for (int i = 0; i < zza.zze(); i++) {
            if (str.equals(zza.zzd(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzkr zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzn e_() {
        return super.e_();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzfz zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzez zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzkv zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzgc zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfb zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfo zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
