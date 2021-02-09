package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzkw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzgk extends zzew {
    private final zzkj zza;
    private Boolean zzb;
    private String zzc;

    public zzgk(zzkj zzkj) {
        this(zzkj, null);
    }

    private zzgk(zzkj zzkj, String str) {
        Preconditions.checkNotNull(zzkj);
        this.zza = zzkj;
        this.zzc = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zzb(zzm zzm) {
        zzb(zzm, false);
        zza(new zzgj(this, zzm));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzan zzan, zzm zzm) {
        Preconditions.checkNotNull(zzan);
        zzb(zzm, false);
        zza(new zzgs(this, zzan, zzm));
    }

    /* access modifiers changed from: package-private */
    public final zzan zzb(zzan zzan, zzm zzm) {
        boolean z = false;
        if (!(!"_cmp".equals(zzan.zza) || zzan.zzb == null || zzan.zzb.zza() == 0)) {
            String zzd = zzan.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zze(zzm.zza, zzap.zzan))) {
                z = true;
            }
        }
        if (!z) {
            return zzan;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzan.toString());
        return new zzan("_cmpx", zzan.zzb, zzan.zzc, zzan.zzd);
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzan zzan, String str, String str2) {
        Preconditions.checkNotNull(zzan);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzgr(this, zzan, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final byte[] zza(zzan zzan, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzan);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzan.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgu(this, zzan, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzfb.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzan.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzfb.zza(str), this.zza.zzi().zza(zzan.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzkq zzkq, zzm zzm) {
        Preconditions.checkNotNull(zzkq);
        zzb(zzm, false);
        zza(new zzgt(this, zzkq, zzm));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final List<zzkq> zza(zzm zzm, boolean z) {
        zzb(zzm, false);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgw(this, zzm)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzks : list) {
                if (z || !zzkv.zze(zzks.zzc)) {
                    arrayList.add(new zzkq(zzks));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzkw.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcx)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfb.zza(zzm.zza), e);
                return null;
            }
            this.zza.zzr().zzf().zza("Failed to get user properties. appId", zzfb.zza(zzm.zza), e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzm zzm) {
        zzb(zzm, false);
        zza(new zzgv(this, zzm));
    }

    private final void zzb(zzm zzm, boolean z) {
        Preconditions.checkNotNull(zzm);
        zza(zzm.zza, false);
        this.zza.zzj().zza(zzm.zzb, zzm.zzr, zzm.zzv);
    }

    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzfb.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.zza.zzr().zzf().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzgy(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final String zzc(zzm zzm) {
        zzb(zzm, false);
        return this.zza.zzd(zzm);
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzv zzv, zzm zzm) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zzb(zzm, false);
        zzv zzv2 = new zzv(zzv);
        zzv2.zza = zzm.zza;
        zza(new zzgx(this, zzv2, zzm));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zza(zzv zzv) {
        Preconditions.checkNotNull(zzv);
        Preconditions.checkNotNull(zzv.zzc);
        zza(zzv.zza, true);
        zza(new zzgm(this, new zzv(zzv)));
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final List<zzkq> zza(String str, String str2, boolean z, zzm zzm) {
        zzb(zzm, false);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgl(this, zzm, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzks : list) {
                if (z || !zzkv.zze(zzks.zzc)) {
                    arrayList.add(new zzkq(zzks));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzkw.zzb() || !this.zza.zzb().zze(zzm.zza, zzap.zzcx)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfb.zza(zzm.zza), e);
            } else {
                this.zza.zzr().zzf().zza("Failed to query user properties. appId", zzfb.zza(zzm.zza), e);
            }
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final List<zzkq> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzks> list = (List) this.zza.zzq().zza(new zzgo(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzks zzks : list) {
                if (z || !zzkv.zze(zzks.zzc)) {
                    arrayList.add(new zzkq(zzks));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            if (!zzkw.zzb() || !this.zza.zzb().zze(str, zzap.zzcx)) {
                this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzfb.zza(str), e);
            } else {
                this.zza.zzr().zzf().zza("Failed to get user properties as. appId", zzfb.zza(str), e);
            }
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final List<zzv> zza(String str, String str2, zzm zzm) {
        zzb(zzm, false);
        try {
            return (List) this.zza.zzq().zza(new zzgn(this, zzm, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final List<zzv> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzgq(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            if (!zzkw.zzb() || !this.zza.zzb().zze(str, zzap.zzcx)) {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            } else {
                this.zza.zzr().zzf().zza("Failed to get conditional user properties as", e);
            }
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzet
    public final void zzd(zzm zzm) {
        zza(zzm.zza, false);
        zza(new zzgp(this, zzm));
    }

    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }
}
