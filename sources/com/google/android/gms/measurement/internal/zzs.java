package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzkw;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzs {
    private zzbs.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzn zzd;

    private zzs(zzn zzn) {
        this.zzd = zzn;
    }

    /* access modifiers changed from: package-private */
    public final zzbs.zzc zza(String str, zzbs.zzc zzc2) {
        String zzc3 = zzc2.zzc();
        List<zzbs.zze> zza2 = zzc2.zza();
        this.zzd.zzg();
        Long l = (Long) zzkr.zzb(zzc2, "_eid");
        boolean z = l != null;
        if (z && zzc3.equals("_ep")) {
            this.zzd.zzg();
            String str2 = (String) zzkr.zzb(zzc2, "_en");
            if (TextUtils.isEmpty(str2)) {
                if (!zzkw.zzb() || !this.zzd.zzt().zzd(str, zzap.zzcx)) {
                    this.zzd.zzr().zzf().zza("Extra parameter without an event name. eventId", l);
                } else {
                    this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                }
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzbs.zzc, Long> zza3 = this.zzd.zzi().zza(str, l);
                if (zza3 == null || zza3.first == null) {
                    if (!zzkw.zzb() || !this.zzd.zzt().zzd(str, zzap.zzcx)) {
                        this.zzd.zzr().zzf().zza("Extra parameter without existing main event. eventName, eventId", str2, l);
                    } else {
                        this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", str2, l);
                    }
                    return null;
                }
                this.zza = (zzbs.zzc) zza3.first;
                this.zzc = ((Long) zza3.second).longValue();
                this.zzd.zzg();
                this.zzb = (Long) zzkr.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzac zzi = this.zzd.zzi();
                zzi.zzd();
                zzi.zzr().zzx().zza("Clearing complex main event info. appId", str);
                try {
                    zzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzi.zzr().zzf().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzbs.zze zze : this.zza.zza()) {
                this.zzd.zzg();
                if (zzkr.zza(zzc2, zze.zzb()) == null) {
                    arrayList.add(zze);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(zza2);
                zza2 = arrayList;
                zzc3 = str2;
            } else {
                if (!zzkw.zzb() || !this.zzd.zzt().zzd(str, zzap.zzcx)) {
                    this.zzd.zzr().zzi().zza("No unique parameters in main event. eventName", str2);
                } else {
                    this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", str2);
                }
                zzc3 = str2;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzc2;
            this.zzd.zzg();
            long j2 = 0L;
            Object zzb2 = zzkr.zzb(zzc2, "_epc");
            if (zzb2 != null) {
                j2 = zzb2;
            }
            long longValue = ((Long) j2).longValue();
            this.zzc = longValue;
            if (longValue > 0) {
                this.zzd.zzi().zza(str, l, this.zzc, zzc2);
            } else if (!zzkw.zzb() || !this.zzd.zzt().zzd(str, zzap.zzcx)) {
                this.zzd.zzr().zzi().zza("Complex event with zero extra param count. eventName", zzc3);
            } else {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", zzc3);
            }
        }
        return (zzbs.zzc) ((zzfe) ((zzbs.zzc.zza) zzc2.zzbl()).zza(zzc3).zzc().zza(zza2).zzv());
    }

    /* synthetic */ zzs(zzn zzn, zzq zzq) {
        this(zzn);
    }
}
