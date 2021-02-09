package com.google.android.gms.internal.measurement;

import android.util.Log;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzcr extends zzcn<Double> {
    zzcr(zzct zzct, String str, Double d) {
        super(zzct, str, d, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Double zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String zzb = super.zzb();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(zzb);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
