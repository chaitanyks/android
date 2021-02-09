package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public abstract class zzu {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    zzu(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zza(String str, zzbk.zzf zzf2, zzfb zzfb) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf2);
        if (str == null || !zzf2.zza() || zzf2.zzb() == zzbk.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzf2.zzb() == zzbk.zzf.zza.IN_LIST) {
            if (zzf2.zzh() == 0) {
                return null;
            }
        } else if (!zzf2.zzc()) {
            return null;
        }
        zzbk.zzf.zza zzb2 = zzf2.zzb();
        boolean zzf3 = zzf2.zzf();
        if (zzf3 || zzb2 == zzbk.zzf.zza.REGEXP || zzb2 == zzbk.zzf.zza.IN_LIST) {
            str2 = zzf2.zzd();
        } else {
            str2 = zzf2.zzd().toUpperCase(Locale.ENGLISH);
        }
        if (zzf2.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf2.zzg();
            if (zzf3) {
                list = zzg;
            } else {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String str3 : zzg) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                list = Collections.unmodifiableList(arrayList);
            }
        }
        return zza(str, zzb2, zzf3, str2, list, zzb2 == zzbk.zzf.zza.REGEXP ? str2 : null, zzfb);
    }

    private static Boolean zza(String str, zzbk.zzf.zza zza2, boolean z, String str2, List<String> list, String str3, zzfb zzfb) {
        if (str == null) {
            return null;
        }
        if (zza2 == zzbk.zzf.zza.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zza2 != zzbk.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzq.zza[zza2.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    if (zzfb != null) {
                        zzfb.zzi().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zza(long j, zzbk.zzd zzd2) {
        try {
            return zza(new BigDecimal(j), zzd2, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static Boolean zza(double d, zzbk.zzd zzd2) {
        try {
            return zza(new BigDecimal(d), zzd2, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    static Boolean zza(String str, zzbk.zzd zzd2) {
        if (!zzkr.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd2, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008c, code lost:
        if (r2 != null) goto L_0x008e;
     */
    private static Boolean zza(BigDecimal bigDecimal, zzbk.zzd zzd2, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzd2);
        if (!zzd2.zza() || zzd2.zzb() == zzbk.zzd.zzb.UNKNOWN_COMPARISON_TYPE) {
            return null;
        }
        if (zzd2.zzb() == zzbk.zzd.zzb.BETWEEN) {
            if (!zzd2.zzg() || !zzd2.zzi()) {
                return null;
            }
        } else if (!zzd2.zze()) {
            return null;
        }
        zzbk.zzd.zzb zzb2 = zzd2.zzb();
        if (zzd2.zzb() == zzbk.zzd.zzb.BETWEEN) {
            if (!zzkr.zza(zzd2.zzh()) || !zzkr.zza(zzd2.zzj())) {
                return null;
            }
            try {
                BigDecimal bigDecimal5 = new BigDecimal(zzd2.zzh());
                bigDecimal3 = new BigDecimal(zzd2.zzj());
                bigDecimal2 = bigDecimal5;
                bigDecimal4 = null;
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (!zzkr.zza(zzd2.zzf())) {
            return null;
        } else {
            try {
                bigDecimal4 = new BigDecimal(zzd2.zzf());
                bigDecimal2 = null;
                bigDecimal3 = null;
            } catch (NumberFormatException e2) {
                return null;
            }
        }
        if (zzb2 == zzbk.zzd.zzb.BETWEEN) {
            if (bigDecimal2 == null) {
                return null;
            }
        }
        int i = zzq.zzb[zzb2.ordinal()];
        boolean z = false;
        if (i == 1) {
            if (bigDecimal.compareTo(bigDecimal4) == -1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i == 2) {
            if (bigDecimal.compareTo(bigDecimal4) == 1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i != 3) {
            if (i == 4) {
                if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            return null;
        } else if (d != 0.0d) {
            if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            if (bigDecimal.compareTo(bigDecimal4) == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }
}
