package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzln;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzim extends zzkk {
    public zzim(zzkj zzkj) {
        super(zzkj);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzkk
    public final boolean zze() {
        return false;
    }

    public final byte[] zza(zzan zzan, String str) {
        zzks zzks;
        zzbs.zzf.zza zza;
        zzbs.zzg.zza zza2;
        zzg zzg;
        byte[] bArr;
        Bundle bundle;
        zzaj zzaj;
        long j;
        zzd();
        this.zzx.zzaf();
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str, zzap.zzbd)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if ("_iap".equals(zzan.zza) || "_iapx".equals(zzan.zza)) {
            zzbs.zzf.zza zzb = zzbs.zzf.zzb();
            zzi().zzf();
            try {
                zzg zzb2 = zzi().zzb(str);
                if (zzb2 == null) {
                    zzr().zzw().zza("Log and bundle not available. package_name", str);
                    return new byte[0];
                } else if (!zzb2.zzr()) {
                    zzr().zzw().zza("Log and bundle disabled. package_name", str);
                    byte[] bArr2 = new byte[0];
                    zzi().zzh();
                    return bArr2;
                } else {
                    zzbs.zzg.zza zza3 = zzbs.zzg.zzbf().zza(1).zza("android");
                    if (!TextUtils.isEmpty(zzb2.zzc())) {
                        zza3.zzf(zzb2.zzc());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzn())) {
                        zza3.zze(zzb2.zzn());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzl())) {
                        zza3.zzg(zzb2.zzl());
                    }
                    if (zzb2.zzm() != -2147483648L) {
                        zza3.zzh((int) zzb2.zzm());
                    }
                    zza3.zzf(zzb2.zzo()).zzk(zzb2.zzq());
                    if (!zzln.zzb() || !zzt().zze(zzb2.zzc(), zzap.zzcf)) {
                        if (!TextUtils.isEmpty(zzb2.zze())) {
                            zza3.zzk(zzb2.zze());
                        } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                            zza3.zzo(zzb2.zzf());
                        }
                    } else if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzk(zzb2.zze());
                    } else if (!TextUtils.isEmpty(zzb2.zzg())) {
                        zza3.zzp(zzb2.zzg());
                    } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                        zza3.zzo(zzb2.zzf());
                    }
                    zza3.zzh(zzb2.zzp());
                    if (this.zzx.zzab() && zzt().zzd(zza3.zzj())) {
                        zza3.zzj();
                        if (!TextUtils.isEmpty(null)) {
                            zza3.zzn(null);
                        }
                    }
                    Pair<String, Boolean> zza4 = zzs().zza(zzb2.zzc());
                    if (zzb2.zzaf() && zza4 != null && !TextUtils.isEmpty((CharSequence) zza4.first)) {
                        try {
                            zza3.zzh(zza((String) zza4.first, Long.toString(zzan.zzd)));
                            if (zza4.second != null) {
                                zza3.zza(((Boolean) zza4.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzr().zzw().zza("Resettable device id encryption failed", e.getMessage());
                            byte[] bArr3 = new byte[0];
                            zzi().zzh();
                            return bArr3;
                        }
                    }
                    zzl().zzaa();
                    zzbs.zzg.zza zzc = zza3.zzc(Build.MODEL);
                    zzl().zzaa();
                    zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
                    try {
                        zza3.zzi(zza(zzb2.zzd(), Long.toString(zzan.zzd)));
                        if (!TextUtils.isEmpty(zzb2.zzi())) {
                            zza3.zzl(zzb2.zzi());
                        }
                        String zzc2 = zzb2.zzc();
                        List<zzks> zza5 = zzi().zza(zzc2);
                        Iterator<zzks> it = zza5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzks = null;
                                break;
                            }
                            zzks = it.next();
                            if ("_lte".equals(zzks.zzc)) {
                                break;
                            }
                        }
                        if (zzks == null || zzks.zze == null) {
                            zzks zzks2 = new zzks(zzc2, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                            zza5.add(zzks2);
                            zzi().zza(zzks2);
                        }
                        if (zzt().zze(zzc2, zzap.zzaz)) {
                            zzkr zzg2 = zzg();
                            zzg2.zzr().zzx().zza("Checking account type status for ad personalization signals");
                            if (zzg2.zzl().zzj()) {
                                String zzc3 = zzb2.zzc();
                                if (zzb2.zzaf() && zzg2.zzj().zze(zzc3)) {
                                    zzg2.zzr().zzw().zza("Turning off ad personalization due to account type");
                                    Iterator<zzks> it2 = zza5.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        } else if ("_npa".equals(it2.next().zzc)) {
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    zza5.add(new zzks(zzc3, "auto", "_npa", zzg2.zzm().currentTimeMillis(), 1L));
                                }
                            }
                        }
                        zzbs.zzk[] zzkArr = new zzbs.zzk[zza5.size()];
                        for (int i = 0; i < zza5.size(); i++) {
                            zzbs.zzk.zza zza6 = zzbs.zzk.zzj().zza(zza5.get(i).zzc).zza(zza5.get(i).zzd);
                            zzg().zza(zza6, zza5.get(i).zze);
                            zzkArr[i] = (zzbs.zzk) ((zzfe) zza6.zzv());
                        }
                        zza3.zzb(Arrays.asList(zzkArr));
                        Bundle zzb3 = zzan.zzb.zzb();
                        zzb3.putLong("_c", 1);
                        zzr().zzw().zza("Marking in-app purchase as real-time");
                        zzb3.putLong("_r", 1);
                        zzb3.putString("_o", zzan.zzc);
                        if (zzp().zzf(zza3.zzj())) {
                            zzp().zza(zzb3, "_dbg", (Object) 1L);
                            zzp().zza(zzb3, "_r", (Object) 1L);
                        }
                        zzaj zza7 = zzi().zza(str, zzan.zza);
                        if (zza7 == null) {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            zzaj = new zzaj(str, zzan.zza, 0, 0, zzan.zzd, 0, null, null, null, null);
                            j = 0;
                        } else {
                            zzg = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb3;
                            bArr = null;
                            j = zza7.zzf;
                            zzaj = zza7.zza(zzan.zzd);
                        }
                        zzi().zza(zzaj);
                        zzak zzak = new zzak(this.zzx, zzan.zzc, str, zzan.zza, zzan.zzd, j, bundle);
                        zzbs.zzc.zza zzb4 = zzbs.zzc.zzj().zza(zzak.zzc).zza(zzak.zzb).zzb(zzak.zzd);
                        Iterator<String> it3 = zzak.zze.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzbs.zze.zza zza8 = zzbs.zze.zzk().zza(next);
                            zzg().zza(zza8, zzak.zze.zza(next));
                            zzb4.zza(zza8);
                        }
                        zza2.zza(zzb4).zza(zzbs.zzh.zza().zza(zzbs.zzd.zza().zza(zzaj.zzc).zza(zzan.zza)));
                        zza2.zzc(e_().zza(zzg.zzc(), Collections.emptyList(), zza2.zzd(), Long.valueOf(zzb4.zzf()), Long.valueOf(zzb4.zzf())));
                        if (zzb4.zze()) {
                            zza2.zzb(zzb4.zzf()).zzc(zzb4.zzf());
                        }
                        long zzk = zzg.zzk();
                        if (zzk != 0) {
                            zza2.zze(zzk);
                        }
                        long zzj = zzg.zzj();
                        if (zzj != 0) {
                            zza2.zzd(zzj);
                        } else if (zzk != 0) {
                            zza2.zzd(zzk);
                        }
                        zzg.zzv();
                        zza2.zzg((int) zzg.zzs()).zzg(zzt().zze()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                        zza.zza(zza2);
                        zzg.zza(zza2.zzf());
                        zzg.zzb(zza2.zzg());
                        zzi().zza(zzg);
                        zzi().b_();
                        zzi().zzh();
                        try {
                            return zzg().zzc(((zzbs.zzf) ((zzfe) zza.zzv())).zzbi());
                        } catch (IOException e2) {
                            zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzfb.zza(str), e2);
                            return bArr;
                        }
                    } catch (SecurityException e3) {
                        zzr().zzw().zza("app instance id encryption failed", e3.getMessage());
                        byte[] bArr4 = new byte[0];
                        zzi().zzh();
                        return bArr4;
                    }
                }
            } finally {
                zzi().zzh();
            }
        } else {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str, zzan.zza);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
