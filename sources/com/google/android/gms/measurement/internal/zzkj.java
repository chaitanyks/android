package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.internal.measurement.zzln;
import com.google.android.gms.internal.measurement.zzms;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public class zzkj implements zzhc {
    private static volatile zzkj zza;
    private zzfz zzb;
    private zzff zzc;
    private zzac zzd;
    private zzfm zze;
    private zzkf zzf;
    private zzn zzg;
    private final zzkr zzh;
    private zzim zzi;
    private final zzgf zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;

    /* access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public class zza implements zzae {
        zzbs.zzg zza;
        List<Long> zzb;
        List<zzbs.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final void zza(zzbs.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        @Override // com.google.android.gms.measurement.internal.zzae
        public final boolean zza(long j, zzbs.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbm = this.zzd + ((long) zzc2.zzbm());
            if (zzbm >= ((long) Math.max(0, zzap.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbm;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzap.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbs.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkj zzkj, zzkm zzkm) {
            this();
        }
    }

    public static zzkj zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkj.class) {
                if (zza == null) {
                    zza = new zzkj(new zzkp(context));
                }
            }
        }
        return zza;
    }

    private zzkj(zzkp zzkp) {
        this(zzkp, null);
    }

    private zzkj(zzkp zzkp, zzgf zzgf) {
        this.zzk = false;
        Preconditions.checkNotNull(zzkp);
        this.zzj = zzgf.zza(zzkp.zza, (zzv) null);
        this.zzy = -1;
        zzkr zzkr = new zzkr(this);
        zzkr.zzal();
        this.zzh = zzkr;
        zzff zzff = new zzff(this);
        zzff.zzal();
        this.zzc = zzff;
        zzfz zzfz = new zzfz(this);
        zzfz.zzal();
        this.zzb = zzfz;
        this.zzj.zzq().zza(new zzkm(this, zzkp));
    }

    /* access modifiers changed from: private */
    public final void zza(zzkp zzkp) {
        this.zzj.zzq().zzd();
        zzac zzac = new zzac(this);
        zzac.zzal();
        this.zzd = zzac;
        this.zzj.zzb().zza(this.zzb);
        zzn zzn2 = new zzn(this);
        zzn2.zzal();
        this.zzg = zzn2;
        zzim zzim = new zzim(this);
        zzim.zzal();
        this.zzi = zzim;
        zzkf zzkf = new zzkf(this);
        zzkf.zzal();
        this.zzf = zzkf;
        this.zze = new zzfm(this);
        if (this.zzp != this.zzq) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzw zzu() {
        return this.zzj.zzu();
    }

    public final zzx zzb() {
        return this.zzj.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzfb zzr() {
        return this.zzj.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final zzgc zzq() {
        return this.zzj.zzq();
    }

    public final zzfz zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzff zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzac zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfm zzt() {
        zzfm zzfm = this.zze;
        if (zzfm != null) {
            return zzfm;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkf zzv() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzn zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzim zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzez zzi() {
        return this.zzj.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final Context zzn() {
        return this.zzj.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc
    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzkv zzj() {
        return this.zzj.zzi();
    }

    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzkk zzkk) {
        if (zzkk == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzkk.zzaj()) {
            String valueOf = String.valueOf(zzkk.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzfo zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzan zzan, String str) {
        String str2;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzan.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzfb.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzfb.zza(str));
            return;
        }
        String zze2 = zzb2.zze();
        String zzl2 = zzb2.zzl();
        long zzm2 = zzb2.zzm();
        String zzn2 = zzb2.zzn();
        long zzo2 = zzb2.zzo();
        long zzp2 = zzb2.zzp();
        boolean zzr2 = zzb2.zzr();
        String zzi2 = zzb2.zzi();
        long zzae = zzb2.zzae();
        boolean zzaf = zzb2.zzaf();
        boolean zzag = zzb2.zzag();
        String zzf2 = zzb2.zzf();
        Boolean zzah = zzb2.zzah();
        long zzq2 = zzb2.zzq();
        List<String> zzai = zzb2.zzai();
        if (!zzln.zzb() || !this.zzj.zzb().zze(zzb2.zzc(), zzap.zzcf)) {
            str2 = null;
        } else {
            str2 = zzb2.zzg();
        }
        zza(zzan, new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzan zzan, zzm zzm2) {
        List<zzv> list;
        List<zzv> list2;
        List<zzv> list3;
        zzan zzan2 = zzan;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzw();
        zzk();
        String str = zzm2.zza;
        long j = zzan2.zzd;
        if (zzh().zza(zzan2, zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            if (this.zzj.zzb().zze(str, zzap.zzbj) && zzm2.zzu != null) {
                if (zzm2.zzu.contains(zzan2.zza)) {
                    Bundle zzb2 = zzan2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzan2 = new zzan(zzan2.zza, new zzam(zzb2), zzan2.zzc, zzan2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzan2.zza, zzan2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzac zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                if (j < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzfb.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzv zzv2 : list) {
                    if (zzv2 != null) {
                        if (!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) {
                            this.zzj.zzr().zzw().zza("User property timed out", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza), zzv2.zzc.zza());
                        } else {
                            this.zzj.zzr().zzx().zza("User property timed out", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza), zzv2.zzc.zza());
                        }
                        if (zzv2.zzg != null) {
                            zzb(new zzan(zzv2.zzg, j), zzm2);
                        }
                        zze().zze(str, zzv2.zzc.zza);
                    }
                }
                zzac zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (j < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzfb.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzv zzv3 : list2) {
                    if (zzv3 != null) {
                        if (!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) {
                            this.zzj.zzr().zzw().zza("User property expired", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                        } else {
                            this.zzj.zzr().zzx().zza("User property expired", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                        }
                        zze().zzb(str, zzv3.zzc.zza);
                        if (zzv3.zzk != null) {
                            arrayList.add(zzv3.zzk);
                        }
                        zze().zze(str, zzv3.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzb(new zzan((zzan) obj, j), zzm2);
                }
                zzac zze4 = zze();
                String str2 = zzan2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (j < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzfb.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzv zzv4 : list3) {
                    if (zzv4 != null) {
                        zzkq zzkq = zzv4.zzc;
                        zzks zzks = new zzks(zzv4.zza, zzv4.zzb, zzkq.zza, j, zzkq.zza());
                        if (!zze().zza(zzks)) {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzfb.zza(zzv4.zza), this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                        } else if (!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) {
                            this.zzj.zzr().zzw().zza("User property triggered", zzv4.zza, this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                        } else {
                            this.zzj.zzr().zzx().zza("User property triggered", zzv4.zza, this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                        }
                        if (zzv4.zzi != null) {
                            arrayList3.add(zzv4.zzi);
                        }
                        zzv4.zzc = new zzkq(zzks);
                        zzv4.zze = true;
                        zze().zza(zzv4);
                    }
                }
                zzb(zzan2, zzm2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzb(new zzan((zzan) obj2, j), zzm2);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:242:0x08e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02c2  */
    private final void zzb(zzan zzan, zzm zzm2) {
        long j;
        String str;
        zzaj zzaj;
        boolean z;
        List<Integer> zzf2;
        zzks zzc2;
        boolean z2;
        long j2;
        zzks zzks;
        int i;
        char c;
        zzg zzb2;
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        long nanoTime = System.nanoTime();
        zzw();
        zzk();
        String str2 = zzm2.zza;
        if (zzh().zza(zzan, zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (zzc().zzb(str2, zzan.zza)) {
                this.zzj.zzr().zzi().zza("Dropping blacklisted event. appId", zzfb.zza(str2), this.zzj.zzj().zza(zzan.zza));
                boolean z3 = zzc().zzg(str2) || zzc().zzh(str2);
                if (!z3 && !"_err".equals(zzan.zza)) {
                    this.zzj.zzi().zza(str2, 11, "_ev", zzan.zza, 0);
                }
                if (z3 && (zzb2 = zze().zzb(str2)) != null) {
                    if (Math.abs(this.zzj.zzm().currentTimeMillis() - Math.max(zzb2.zzu(), zzb2.zzt())) > zzap.zzy.zza(null).longValue()) {
                        this.zzj.zzr().zzw().zza("Fetching config for blacklisted app");
                        zza(zzb2);
                    }
                }
            } else {
                if (this.zzj.zzr().zza(2)) {
                    this.zzj.zzr().zzx().zza("Logging event", this.zzj.zzj().zza(zzan));
                }
                zze().zzf();
                try {
                    zzc(zzm2);
                    if ("_iap".equals(zzan.zza) || FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzan.zza)) {
                        String zzd2 = zzan.zzb.zzd(FirebaseAnalytics.Param.CURRENCY);
                        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzan.zza)) {
                            double doubleValue = zzan.zzb.zzc("value").doubleValue() * 1000000.0d;
                            if (doubleValue == 0.0d) {
                                double longValue = (double) zzan.zzb.zzb("value").longValue();
                                Double.isNaN(longValue);
                                doubleValue = longValue * 1000000.0d;
                            }
                            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                                this.zzj.zzr().zzi().zza("Data lost. Currency value is too big. appId", zzfb.zza(str2), Double.valueOf(doubleValue));
                                j = nanoTime;
                                z2 = false;
                                if (!z2) {
                                    zze().b_();
                                    zze().zzh();
                                    return;
                                }
                            } else {
                                j2 = Math.round(doubleValue);
                            }
                        } else {
                            j2 = zzan.zzb.zzb("value").longValue();
                        }
                        if (!TextUtils.isEmpty(zzd2)) {
                            String upperCase = zzd2.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                String valueOf = String.valueOf("_ltv_");
                                String valueOf2 = String.valueOf(upperCase);
                                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                zzks zzc3 = zze().zzc(str2, concat);
                                if (zzc3 == null) {
                                    j = nanoTime;
                                    c = 0;
                                    i = 1;
                                } else if (!(zzc3.zze instanceof Long)) {
                                    j = nanoTime;
                                    c = 0;
                                    i = 1;
                                } else {
                                    j = nanoTime;
                                    zzks = new zzks(str2, zzan.zzc, concat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc3.zze).longValue() + j2));
                                    if (!zze().zza(zzks)) {
                                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property. appId", zzfb.zza(str2), this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                                        this.zzj.zzi().zza(str2, 9, (String) null, (String) null, 0);
                                    }
                                }
                                zzac zze2 = zze();
                                int zzb3 = this.zzj.zzb().zzb(str2, zzap.zzad) - i;
                                Preconditions.checkNotEmpty(str2);
                                zze2.zzd();
                                zze2.zzak();
                                try {
                                    SQLiteDatabase c_ = zze2.c_();
                                    String[] strArr = new String[3];
                                    strArr[c] = str2;
                                    strArr[1] = str2;
                                    strArr[2] = String.valueOf(zzb3);
                                    c_.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                                } catch (SQLiteException e) {
                                    zze2.zzr().zzf().zza("Error pruning currencies. appId", zzfb.zza(str2), e);
                                }
                                zzks = new zzks(str2, zzan.zzc, concat, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j2));
                                if (!zze().zza(zzks)) {
                                }
                            } else {
                                j = nanoTime;
                            }
                        } else {
                            j = nanoTime;
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    } else {
                        j = nanoTime;
                    }
                    boolean zza2 = zzkv.zza(zzan.zza);
                    boolean equals = "_err".equals(zzan.zza);
                    zzab zza3 = zze().zza(zzx(), str2, true, zza2, false, equals, false);
                    long intValue = zza3.zzb - ((long) zzap.zzj.zza(null).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            this.zzj.zzr().zzf().zza("Data loss. Too many events logged. appId, count", zzfb.zza(str2), Long.valueOf(zza3.zzb));
                        }
                        zze().b_();
                        return;
                    }
                    if (zza2) {
                        long intValue2 = zza3.zza - ((long) zzap.zzl.zza(null).intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                this.zzj.zzr().zzf().zza("Data loss. Too many public events logged. appId, count", zzfb.zza(str2), Long.valueOf(zza3.zza));
                            }
                            this.zzj.zzi().zza(str2, 16, "_ev", zzan.zza, 0);
                            zze().b_();
                            zze().zzh();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza3.zzd - ((long) Math.max(0, Math.min(1000000, this.zzj.zzb().zzb(zzm2.zza, zzap.zzk))));
                        if (max > 0) {
                            if (max == 1) {
                                this.zzj.zzr().zzf().zza("Too many error events logged. appId, count", zzfb.zza(str2), Long.valueOf(zza3.zzd));
                            }
                            zze().b_();
                            zze().zzh();
                            return;
                        }
                    }
                    Bundle zzb4 = zzan.zzb.zzb();
                    this.zzj.zzi().zza(zzb4, "_o", zzan.zzc);
                    if (this.zzj.zzi().zzf(str2)) {
                        this.zzj.zzi().zza(zzb4, "_dbg", (Object) 1L);
                        this.zzj.zzi().zza(zzb4, "_r", (Object) 1L);
                    }
                    if ("_s".equals(zzan.zza) && this.zzj.zzb().zze(zzm2.zza, zzap.zzap) && (zzc2 = zze().zzc(zzm2.zza, "_sno")) != null && (zzc2.zze instanceof Long)) {
                        this.zzj.zzi().zza(zzb4, "_sno", zzc2.zze);
                    }
                    if (!"_s".equals(zzan.zza)) {
                        str = null;
                    } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzat)) {
                        str = null;
                    } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzap)) {
                        str = null;
                        zzb(new zzkq("_sno", 0, null), zzm2);
                    } else {
                        str = null;
                    }
                    long zzc4 = zze().zzc(str2);
                    if (zzc4 > 0) {
                        this.zzj.zzr().zzi().zza("Data lost. Too many events stored on disk, deleted. appId", zzfb.zza(str2), Long.valueOf(zzc4));
                    }
                    String str3 = "_r";
                    zzak zzak = new zzak(this.zzj, zzan.zzc, str2, zzan.zza, zzan.zzd, 0, zzb4);
                    zzaj zza4 = zze().zza(str2, zzak.zzb);
                    if (zza4 != null) {
                        zzak = zzak.zza(this.zzj, zza4.zzf);
                        zzaj = zza4.zza(zzak.zzc);
                    } else if (zze().zzh(str2) < 500 || !zza2) {
                        zzaj = new zzaj(str2, zzak.zzb, 0, 0, zzak.zzc, 0, null, null, null, null);
                    } else {
                        this.zzj.zzr().zzf().zza("Too many event names used, ignoring event. appId, name, supported count", zzfb.zza(str2), this.zzj.zzj().zza(zzak.zzb), 500);
                        this.zzj.zzi().zza(str2, 8, (String) null, (String) null, 0);
                        zze().zzh();
                        return;
                    }
                    zze().zza(zzaj);
                    zzw();
                    zzk();
                    Preconditions.checkNotNull(zzak);
                    Preconditions.checkNotNull(zzm2);
                    Preconditions.checkNotEmpty(zzak.zza);
                    Preconditions.checkArgument(zzak.zza.equals(zzm2.zza));
                    zzbs.zzg.zza zza5 = zzbs.zzg.zzbf().zza(1).zza("android");
                    if (!TextUtils.isEmpty(zzm2.zza)) {
                        zza5.zzf(zzm2.zza);
                    }
                    if (!TextUtils.isEmpty(zzm2.zzd)) {
                        zza5.zze(zzm2.zzd);
                    }
                    if (!TextUtils.isEmpty(zzm2.zzc)) {
                        zza5.zzg(zzm2.zzc);
                    }
                    if (zzm2.zzj != -2147483648L) {
                        zza5.zzh((int) zzm2.zzj);
                    }
                    zza5.zzf(zzm2.zze);
                    if (!TextUtils.isEmpty(zzm2.zzb)) {
                        zza5.zzk(zzm2.zzb);
                    }
                    if (zzln.zzb() && this.zzj.zzb().zze(zzm2.zza, zzap.zzcf)) {
                        if (TextUtils.isEmpty(zza5.zzl()) && !TextUtils.isEmpty(zzm2.zzv)) {
                            zza5.zzp(zzm2.zzv);
                        }
                        if (TextUtils.isEmpty(zza5.zzl()) && TextUtils.isEmpty(zza5.zzo()) && !TextUtils.isEmpty(zzm2.zzr)) {
                            zza5.zzo(zzm2.zzr);
                        }
                    } else if (this.zzj.zzb().zza(zzap.zzbf)) {
                        if (TextUtils.isEmpty(zza5.zzl()) && !TextUtils.isEmpty(zzm2.zzr)) {
                            zza5.zzo(zzm2.zzr);
                        }
                    } else if (!TextUtils.isEmpty(zzm2.zzr)) {
                        zza5.zzo(zzm2.zzr);
                    }
                    if (zzm2.zzf != 0) {
                        zza5.zzh(zzm2.zzf);
                    }
                    zza5.zzk(zzm2.zzt);
                    if (this.zzj.zzb().zze(zzm2.zza, zzap.zzbc) && (zzf2 = zzh().zzf()) != null) {
                        zza5.zzd(zzf2);
                    }
                    Pair<String, Boolean> zza6 = this.zzj.zzc().zza(zzm2.zza);
                    if (zza6 == null || TextUtils.isEmpty((CharSequence) zza6.first)) {
                        if (!this.zzj.zzx().zza(this.zzj.zzn()) && zzm2.zzp) {
                            String string = Settings.Secure.getString(this.zzj.zzn().getContentResolver(), "android_id");
                            if (string == null) {
                                this.zzj.zzr().zzi().zza("null secure ID. appId", zzfb.zza(zza5.zzj()));
                                string = "null";
                            } else if (string.isEmpty()) {
                                this.zzj.zzr().zzi().zza("empty secure ID. appId", zzfb.zza(zza5.zzj()));
                            }
                            zza5.zzm(string);
                        }
                    } else if (zzm2.zzo) {
                        zza5.zzh((String) zza6.first);
                        if (zza6.second != null) {
                            zza5.zza(((Boolean) zza6.second).booleanValue());
                        }
                    }
                    this.zzj.zzx().zzaa();
                    zzbs.zzg.zza zzc5 = zza5.zzc(Build.MODEL);
                    this.zzj.zzx().zzaa();
                    zzc5.zzb(Build.VERSION.RELEASE).zzf((int) this.zzj.zzx().zzf()).zzd(this.zzj.zzx().zzg()).zzj(zzm2.zzl);
                    if (this.zzj.zzab()) {
                        zza5.zzj();
                        if (!TextUtils.isEmpty(str)) {
                            zza5.zzn(str);
                        }
                    }
                    zzg zzb5 = zze().zzb(zzm2.zza);
                    if (zzb5 == null) {
                        zzb5 = new zzg(this.zzj, zzm2.zza);
                        zzb5.zza(this.zzj.zzi().zzk());
                        zzb5.zzf(zzm2.zzk);
                        zzb5.zzb(zzm2.zzb);
                        zzb5.zze(this.zzj.zzc().zzb(zzm2.zza));
                        zzb5.zzg(0);
                        zzb5.zza(0);
                        zzb5.zzb(0);
                        zzb5.zzg(zzm2.zzc);
                        zzb5.zzc(zzm2.zzj);
                        zzb5.zzh(zzm2.zzd);
                        zzb5.zzd(zzm2.zze);
                        zzb5.zze(zzm2.zzf);
                        zzb5.zza(zzm2.zzh);
                        zzb5.zzp(zzm2.zzl);
                        zzb5.zzf(zzm2.zzt);
                        zze().zza(zzb5);
                    }
                    if (!TextUtils.isEmpty(zzb5.zzd())) {
                        zza5.zzi(zzb5.zzd());
                    }
                    if (!TextUtils.isEmpty(zzb5.zzi())) {
                        zza5.zzl(zzb5.zzi());
                    }
                    List<zzks> zza7 = zze().zza(zzm2.zza);
                    for (int i2 = 0; i2 < zza7.size(); i2++) {
                        zzbs.zzk.zza zza8 = zzbs.zzk.zzj().zza(zza7.get(i2).zzc).zza(zza7.get(i2).zzd);
                        zzh().zza(zza8, zza7.get(i2).zze);
                        zza5.zza(zza8);
                    }
                    try {
                        long zza9 = zze().zza((zzbs.zzg) ((zzfe) zza5.zzv()));
                        zzac zze3 = zze();
                        if (zzak.zze != null) {
                            Iterator<String> it = zzak.zze.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    boolean zzc6 = zzc().zzc(zzak.zza, zzak.zzb);
                                    zzab zza10 = zze().zza(zzx(), zzak.zza, false, false, false, false, false);
                                    if (zzc6 && zza10.zze < ((long) this.zzj.zzb().zza(zzak.zza))) {
                                        z = true;
                                    }
                                } else if (str3.equals(it.next())) {
                                    z = true;
                                    break;
                                } else {
                                    str3 = str3;
                                }
                            }
                            if (zze3.zza(zzak, zza9, z)) {
                                this.zzn = 0;
                            }
                            zze().b_();
                            if ((!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) && this.zzj.zzr().zza(2)) {
                                this.zzj.zzr().zzx().zza("Event recorded", this.zzj.zzj().zza(zzak));
                            }
                            zze().zzh();
                            zzz();
                            this.zzj.zzr().zzx().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                        }
                        z = false;
                        if (zze3.zza(zzak, zza9, z)) {
                        }
                    } catch (IOException e2) {
                        this.zzj.zzr().zzf().zza("Data loss. Failed to insert raw event metadata. appId", zzfb.zza(zza5.zzj()), e2);
                    }
                    zze().b_();
                    this.zzj.zzr().zzx().zza("Event recorded", this.zzj.zzj().zza(zzak));
                    zze().zzh();
                    zzz();
                    this.zzj.zzr().zzx().zza("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        zzg zzb2;
        String str;
        zzw();
        zzk();
        this.zzt = true;
        try {
            this.zzj.zzu();
            Boolean zzag = this.zzj.zzw().zzag();
            if (zzag == null) {
                this.zzj.zzr().zzi().zza("Upload data called on the client side before use of service was decided");
            } else if (zzag.booleanValue()) {
                this.zzj.zzr().zzf().zza("Upload called in the client side when service should be used");
                this.zzt = false;
                zzaa();
            } else if (this.zzn > 0) {
                zzz();
                this.zzt = false;
                zzaa();
            } else {
                zzw();
                if (this.zzw != null) {
                    this.zzj.zzr().zzx().zza("Uploading requested multiple times");
                    this.zzt = false;
                    zzaa();
                } else if (!zzd().zzf()) {
                    this.zzj.zzr().zzx().zza("Network not connected, ignoring upload request");
                    zzz();
                    this.zzt = false;
                    zzaa();
                } else {
                    long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
                    zza((String) null, currentTimeMillis - zzx.zzk());
                    long zza2 = this.zzj.zzc().zzc.zza();
                    if (zza2 != 0) {
                        this.zzj.zzr().zzw().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzy == -1) {
                            this.zzy = zze().zzaa();
                        }
                        List<Pair<zzbs.zzg, Long>> zza3 = zze().zza(d_, this.zzj.zzb().zzb(d_, zzap.zzf), Math.max(0, this.zzj.zzb().zzb(d_, zzap.zzg)));
                        if (!zza3.isEmpty()) {
                            Iterator<Pair<zzbs.zzg, Long>> it = zza3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzbs.zzg zzg2 = (zzbs.zzg) it.next().first;
                                if (!TextUtils.isEmpty(zzg2.zzad())) {
                                    str = zzg2.zzad();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zza3.size()) {
                                        break;
                                    }
                                    zzbs.zzg zzg3 = (zzbs.zzg) zza3.get(i).first;
                                    if (!(TextUtils.isEmpty(zzg3.zzad()) || zzg3.zzad().equals(str))) {
                                        zza3 = zza3.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            zzbs.zzf.zza zzb3 = zzbs.zzf.zzb();
                            int size = zza3.size();
                            ArrayList arrayList = new ArrayList(zza3.size());
                            boolean zzd2 = this.zzj.zzb().zzd(d_);
                            for (int i2 = 0; i2 < size; i2++) {
                                zzbs.zzg.zza zza4 = (zzbs.zzg.zza) ((zzbs.zzg) zza3.get(i2).first).zzbl();
                                arrayList.add((Long) zza3.get(i2).second);
                                zzbs.zzg.zza zza5 = zza4.zzg(this.zzj.zzb().zze()).zza(currentTimeMillis);
                                this.zzj.zzu();
                                zza5.zzb(false);
                                if (!zzd2) {
                                    zza4.zzn();
                                }
                                if (this.zzj.zzb().zze(d_, zzap.zzbe)) {
                                    zza4.zzl(zzh().zza(((zzbs.zzg) ((zzfe) zza4.zzv())).zzbi()));
                                }
                                zzb3.zza(zza4);
                            }
                            String zza6 = this.zzj.zzr().zza(2) ? zzh().zza((zzbs.zzf) ((zzfe) zzb3.zzv())) : null;
                            zzh();
                            byte[] zzbi = ((zzbs.zzf) ((zzfe) zzb3.zzv())).zzbi();
                            String zza7 = zzap.zzp.zza(null);
                            try {
                                URL url = new URL(zza7);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzw != null) {
                                    this.zzj.zzr().zzf().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzw = new ArrayList(arrayList);
                                }
                                this.zzj.zzc().zzd.zza(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = zzb3.zza(0).zzx();
                                }
                                this.zzj.zzr().zzx().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbi.length), zza6);
                                this.zzs = true;
                                zzff zzd3 = zzd();
                                zzkl zzkl = new zzkl(this, d_);
                                zzd3.zzd();
                                zzd3.zzak();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzbi);
                                Preconditions.checkNotNull(zzkl);
                                zzd3.zzq().zzb(new zzfj(zzd3, d_, url, zzbi, null, zzkl));
                            } catch (MalformedURLException e) {
                                this.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", zzfb.zza(d_), zza7);
                            }
                        }
                    } else {
                        this.zzy = -1;
                        String zza8 = zze().zza(currentTimeMillis - zzx.zzk());
                        if (!TextUtils.isEmpty(zza8) && (zzb2 = zze().zzb(zza8)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzt = false;
                    zzaa();
                }
            }
        } finally {
            this.zzt = false;
            zzaa();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r8 = null;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x025d, code lost:
        r9 = r4;
        r8 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
      PHI: (r4v143 android.database.Cursor) = (r4v141 android.database.Cursor), (r4v141 android.database.Cursor), (r4v141 android.database.Cursor), (r4v141 android.database.Cursor), (r4v0 android.database.Cursor), (r4v0 android.database.Cursor) binds: [B:22:0x0087, B:23:?, B:28:0x0098, B:29:?, B:10:0x0037, B:11:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:10:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x06ce  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x06e5  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0820  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x083d  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0857  */
    /* JADX WARNING: Removed duplicated region for block: B:530:0x1046  */
    /* JADX WARNING: Removed duplicated region for block: B:535:0x105d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x027e  */
    private final boolean zza(String str, long j) {
        Throwable th;
        Throwable th2;
        boolean z;
        long j2;
        zzbs.zzg.zza zza2;
        SecureRandom secureRandom;
        HashMap hashMap;
        zzbs.zzg.zza zza3;
        boolean z2;
        int i;
        long j3;
        zzbs.zzg.zza zza4;
        long j4;
        HashMap hashMap2;
        zzg zzb2;
        boolean z3;
        boolean z4;
        zzbs.zzc.zza zza5;
        boolean z5;
        int i2;
        zzbs.zzg.zza zza6;
        int i3;
        zzbs.zzg.zza zza7;
        int i4;
        zzbs.zzc.zza zza8;
        int i5;
        String str2;
        zzbs.zzc.zza zza9;
        int i6;
        int i7;
        boolean z6;
        int i8;
        zzbs.zzc.zza zza10;
        char c;
        boolean z7;
        Cursor cursor;
        String str3;
        SQLiteException sQLiteException;
        Throwable th3;
        String str4;
        String[] strArr;
        String str5;
        String[] strArr2;
        zzkj zzkj = this;
        String str6 = "_npa";
        zze().zzf();
        try {
            Cursor cursor2 = null;
            zza zza11 = new zza(zzkj, null);
            zzac zze2 = zze();
            long j5 = zzkj.zzy;
            Preconditions.checkNotNull(zza11);
            zze2.zzd();
            zze2.zzak();
            try {
                SQLiteDatabase c_ = zze2.c_();
                String str7 = "";
                if (TextUtils.isEmpty(null)) {
                    if (j5 != -1) {
                        try {
                            strArr2 = new String[]{String.valueOf(j5), String.valueOf(j)};
                        } catch (SQLiteException e) {
                            e = e;
                            cursor = cursor2;
                        } catch (Throwable th4) {
                        }
                    } else {
                        strArr2 = new String[]{String.valueOf(j)};
                    }
                    if (j5 != -1) {
                        str7 = "rowid <= ? and ";
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str7).length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str7);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursor2 = c_.rawQuery(sb.toString(), strArr2);
                    if (!cursor2.moveToFirst()) {
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (!(zza11.zzc != null || zza11.zzc.isEmpty())) {
                            zzbs.zzg.zza zzc2 = ((zzbs.zzg.zza) zza11.zza.zzbl()).zzc();
                            boolean zze3 = zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzay);
                            int i9 = -1;
                            zzbs.zzc.zza zza12 = null;
                            zzbs.zzc.zza zza13 = null;
                            int i10 = -1;
                            int i11 = 0;
                            boolean z8 = false;
                            long j6 = 0;
                            int i12 = 0;
                            while (true) {
                                z = z8;
                                if (i11 >= zza11.zzc.size()) {
                                    break;
                                }
                                zzbs.zzc.zza zza14 = (zzbs.zzc.zza) zza11.zzc.get(i11).zzbl();
                                if (zzc().zzb(zza11.zza.zzx(), zza14.zzd())) {
                                    zzkj.zzj.zzr().zzi().zza("Dropping blacklisted raw event. appId", zzfb.zza(zza11.zza.zzx()), zzkj.zzj.zzj().zza(zza14.zzd()));
                                    if (!(zzc().zzg(zza11.zza.zzx()) || zzc().zzh(zza11.zza.zzx())) && !"_err".equals(zza14.zzd())) {
                                        zzkj.zzj.zzi().zza(zza11.zza.zzx(), 11, "_ev", zza14.zzd(), 0);
                                    }
                                    z5 = zze3;
                                    zza5 = zza12;
                                    z8 = z;
                                    j6 = j6;
                                    i2 = i11;
                                    zza6 = zzc2;
                                } else {
                                    boolean zzc3 = zzc().zzc(zza11.zza.zzx(), zza14.zzd());
                                    if (!zzc3) {
                                        zzh();
                                        String zzd2 = zza14.zzd();
                                        Preconditions.checkNotEmpty(zzd2);
                                        z5 = zze3;
                                        int hashCode = zzd2.hashCode();
                                        i4 = i10;
                                        if (hashCode != 94660) {
                                            if (hashCode != 95025) {
                                                if (hashCode == 95027 && zzd2.equals("_ui")) {
                                                    c = 1;
                                                    if (c != 0 || c == 1 || c == 2) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (!z7) {
                                                        zza7 = zzc2;
                                                        i3 = i9;
                                                        zza5 = zza12;
                                                        zza8 = zza13;
                                                        z8 = z;
                                                        if (!zzc3) {
                                                            ArrayList arrayList = new ArrayList(zza14.zza());
                                                            int i13 = -1;
                                                            int i14 = -1;
                                                            for (int i15 = 0; i15 < arrayList.size(); i15++) {
                                                                if ("value".equals(((zzbs.zze) arrayList.get(i15)).zzb())) {
                                                                    i13 = i15;
                                                                } else if (FirebaseAnalytics.Param.CURRENCY.equals(((zzbs.zze) arrayList.get(i15)).zzb())) {
                                                                    i14 = i15;
                                                                }
                                                            }
                                                            if (i13 != -1) {
                                                                if (((zzbs.zze) arrayList.get(i13)).zze() || ((zzbs.zze) arrayList.get(i13)).zzg()) {
                                                                    if (i14 != -1) {
                                                                        String zzd3 = ((zzbs.zze) arrayList.get(i14)).zzd();
                                                                        if (zzd3.length() == 3) {
                                                                            int i16 = 0;
                                                                            while (true) {
                                                                                if (i16 >= zzd3.length()) {
                                                                                    z6 = false;
                                                                                    break;
                                                                                }
                                                                                int codePointAt = zzd3.codePointAt(i16);
                                                                                if (!Character.isLetter(codePointAt)) {
                                                                                    z6 = true;
                                                                                    break;
                                                                                }
                                                                                i16 += Character.charCount(codePointAt);
                                                                            }
                                                                        } else {
                                                                            z6 = true;
                                                                        }
                                                                    } else {
                                                                        z6 = true;
                                                                    }
                                                                    if (z6) {
                                                                        zzkj.zzj.zzr().zzk().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                        zza14.zzb(i13);
                                                                        zza(zza14, "_c");
                                                                        zza(zza14, 19, FirebaseAnalytics.Param.CURRENCY);
                                                                    }
                                                                } else {
                                                                    zzkj.zzj.zzr().zzk().zza("Value must be specified with a numeric type.");
                                                                    zza14.zzb(i13);
                                                                    zza(zza14, "_c");
                                                                    zza(zza14, 18, "value");
                                                                }
                                                            }
                                                        }
                                                        if (zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzax)) {
                                                            str2 = "_et";
                                                            i6 = i4;
                                                            zza6 = zza7;
                                                            i5 = i3;
                                                        } else if ("_e".equals(zza14.zzd())) {
                                                            zzh();
                                                            if (zzkr.zza((zzbs.zzc) ((zzfe) zza14.zzv()), "_fr") == null) {
                                                                if (zza8 == null) {
                                                                    zza6 = zza7;
                                                                    i5 = i3;
                                                                } else if (Math.abs(zza8.zzf() - zza14.zzf()) <= 1000) {
                                                                    zzbs.zzc.zza zza15 = (zzbs.zzc.zza) ((zzfe.zza) zza8.clone());
                                                                    if (zzkj.zza(zza14, zza15)) {
                                                                        zza6 = zza7;
                                                                        i5 = i3;
                                                                        zza6.zza(i5, zza15);
                                                                        str2 = "_et";
                                                                        i10 = i4;
                                                                        zza9 = null;
                                                                        zza5 = null;
                                                                        if (!z5 && "_e".equals(zza14.zzd())) {
                                                                            if (zza14.zzb() == 0) {
                                                                                zzkj.zzj.zzr().zzi().zza("Engagement event does not contain any parameters. appId", zzfb.zza(zza11.zza.zzx()));
                                                                            } else {
                                                                                zzh();
                                                                                Long l = (Long) zzkr.zzb((zzbs.zzc) ((zzfe) zza14.zzv()), str2);
                                                                                if (l == null) {
                                                                                    zzkj.zzj.zzr().zzi().zza("Engagement event does not include duration. appId", zzfb.zza(zza11.zza.zzx()));
                                                                                } else {
                                                                                    j6 += l.longValue();
                                                                                    i2 = i11;
                                                                                    zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                                    i12++;
                                                                                    zza6.zza(zza14);
                                                                                    zza13 = zza9;
                                                                                    i9 = i5;
                                                                                }
                                                                            }
                                                                        }
                                                                        j6 = j6;
                                                                        i2 = i11;
                                                                        zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                        i12++;
                                                                        zza6.zza(zza14);
                                                                        zza13 = zza9;
                                                                        i9 = i5;
                                                                    } else {
                                                                        zza6 = zza7;
                                                                        i5 = i3;
                                                                    }
                                                                } else {
                                                                    zza6 = zza7;
                                                                    i5 = i3;
                                                                }
                                                                zza5 = zza14;
                                                                zza9 = zza8;
                                                                str2 = "_et";
                                                                i10 = i12;
                                                                if (zza14.zzb() == 0) {
                                                                }
                                                                j6 = j6;
                                                                i2 = i11;
                                                                zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                i12++;
                                                                zza6.zza(zza14);
                                                                zza13 = zza9;
                                                                i9 = i5;
                                                            } else {
                                                                zza6 = zza7;
                                                                i5 = i3;
                                                                str2 = "_et";
                                                                i6 = i4;
                                                            }
                                                        } else {
                                                            zza6 = zza7;
                                                            i5 = i3;
                                                            if ("_vs".equals(zza14.zzd())) {
                                                                zzh();
                                                                str2 = "_et";
                                                                if (zzkr.zza((zzbs.zzc) ((zzfe) zza14.zzv()), str2) == null) {
                                                                    if (zza5 == null) {
                                                                        i7 = i4;
                                                                    } else if (Math.abs(zza5.zzf() - zza14.zzf()) <= 1000) {
                                                                        zzbs.zzc.zza zza16 = (zzbs.zzc.zza) ((zzfe.zza) zza5.clone());
                                                                        if (zzkj.zza(zza16, zza14)) {
                                                                            zza6.zza(i4, zza16);
                                                                            i10 = i4;
                                                                            zza9 = null;
                                                                            zza5 = null;
                                                                            if (zza14.zzb() == 0) {
                                                                            }
                                                                            j6 = j6;
                                                                            i2 = i11;
                                                                            zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                            i12++;
                                                                            zza6.zza(zza14);
                                                                            zza13 = zza9;
                                                                            i9 = i5;
                                                                        } else {
                                                                            i7 = i4;
                                                                        }
                                                                    } else {
                                                                        i7 = i4;
                                                                    }
                                                                    zza9 = zza14;
                                                                    i10 = i7;
                                                                    i5 = i12;
                                                                    if (zza14.zzb() == 0) {
                                                                    }
                                                                    j6 = j6;
                                                                    i2 = i11;
                                                                    zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                    i12++;
                                                                    zza6.zza(zza14);
                                                                    zza13 = zza9;
                                                                    i9 = i5;
                                                                } else {
                                                                    i6 = i4;
                                                                }
                                                            } else {
                                                                str2 = "_et";
                                                                i6 = i4;
                                                                if (zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzcj) && "_ab".equals(zza14.zzd())) {
                                                                    zzh();
                                                                    if (zzkr.zza((zzbs.zzc) ((zzfe) zza14.zzv()), str2) == null && zza5 != null && Math.abs(zza5.zzf() - zza14.zzf()) <= 4000) {
                                                                        zzbs.zzc.zza zza17 = (zzbs.zzc.zza) ((zzfe.zza) zza5.clone());
                                                                        zzkj.zzb(zza17, zza14);
                                                                        zza6.zza(i6, zza17);
                                                                        zza9 = zza8;
                                                                        zza5 = null;
                                                                        i10 = i6;
                                                                        if (zza14.zzb() == 0) {
                                                                        }
                                                                        j6 = j6;
                                                                        i2 = i11;
                                                                        zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                                        i12++;
                                                                        zza6.zza(zza14);
                                                                        zza13 = zza9;
                                                                        i9 = i5;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        zza9 = zza8;
                                                        i10 = i6;
                                                        if (zza14.zzb() == 0) {
                                                        }
                                                        j6 = j6;
                                                        i2 = i11;
                                                        zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                                        i12++;
                                                        zza6.zza(zza14);
                                                        zza13 = zza9;
                                                        i9 = i5;
                                                    }
                                                }
                                            } else if (zzd2.equals("_ug")) {
                                                c = 2;
                                                if (c != 0) {
                                                }
                                                z7 = true;
                                                if (!z7) {
                                                }
                                            }
                                        } else if (zzd2.equals("_in")) {
                                            c = 0;
                                            if (c != 0) {
                                            }
                                            z7 = true;
                                            if (!z7) {
                                            }
                                        }
                                        c = 65535;
                                        if (c != 0) {
                                        }
                                        z7 = true;
                                        if (!z7) {
                                        }
                                    } else {
                                        z5 = zze3;
                                        i4 = i10;
                                    }
                                    boolean z9 = false;
                                    boolean z10 = false;
                                    int i17 = 0;
                                    while (true) {
                                        zza5 = zza12;
                                        zza7 = zzc2;
                                        if (i17 >= zza14.zzb()) {
                                            break;
                                        }
                                        if ("_c".equals(zza14.zza(i17).zzb())) {
                                            zza14.zza(i17, (zzbs.zze) ((zzfe) ((zzbs.zze.zza) zza14.zza(i17).zzbl()).zza(1L).zzv()));
                                            i8 = i9;
                                            zza10 = zza13;
                                            z9 = true;
                                        } else if ("_r".equals(zza14.zza(i17).zzb())) {
                                            i8 = i9;
                                            zza10 = zza13;
                                            zza14.zza(i17, (zzbs.zze) ((zzfe) ((zzbs.zze.zza) zza14.zza(i17).zzbl()).zza(1L).zzv()));
                                            z10 = true;
                                        } else {
                                            i8 = i9;
                                            zza10 = zza13;
                                        }
                                        i17++;
                                        zza13 = zza10;
                                        zza12 = zza5;
                                        zzc2 = zza7;
                                        i9 = i8;
                                    }
                                    i3 = i9;
                                    if (!z9 && zzc3) {
                                        zzkj.zzj.zzr().zzx().zza("Marking event as conversion", zzkj.zzj.zzj().zza(zza14.zzd()));
                                        zza14.zza(zzbs.zze.zzk().zza("_c").zza(1L));
                                    }
                                    if (!z10) {
                                        zzkj.zzj.zzr().zzx().zza("Marking event as real-time", zzkj.zzj.zzj().zza(zza14.zzd()));
                                        zza14.zza(zzbs.zze.zzk().zza("_r").zza(1L));
                                    }
                                    zza8 = zza13;
                                    if (zze().zza(zzx(), zza11.zza.zzx(), false, false, false, false, true).zze > ((long) zzkj.zzj.zzb().zza(zza11.zza.zzx()))) {
                                        zza(zza14, "_r");
                                    } else {
                                        z = true;
                                    }
                                    if (zzkv.zza(zza14.zzd()) && zzc3 && zze().zza(zzx(), zza11.zza.zzx(), false, false, true, false, false).zzc > ((long) zzkj.zzj.zzb().zzb(zza11.zza.zzx(), zzap.zzm))) {
                                        zzkj.zzj.zzr().zzi().zza("Too many conversions. Not logging as conversion. appId", zzfb.zza(zza11.zza.zzx()));
                                        boolean z11 = false;
                                        int i18 = -1;
                                        zzbs.zze.zza zza18 = null;
                                        for (int i19 = 0; i19 < zza14.zzb(); i19++) {
                                            zzbs.zze zza19 = zza14.zza(i19);
                                            if ("_c".equals(zza19.zzb())) {
                                                zza18 = (zzbs.zze.zza) zza19.zzbl();
                                                i18 = i19;
                                            } else if ("_err".equals(zza19.zzb())) {
                                                z11 = true;
                                            }
                                        }
                                        if (z11 && zza18 != null) {
                                            zza14.zzb(i18);
                                        } else if (zza18 != null) {
                                            zza14.zza(i18, (zzbs.zze) ((zzfe) ((zzbs.zze.zza) ((zzfe.zza) zza18.clone())).zza("_err").zza(10L).zzv()));
                                        } else {
                                            zzkj.zzj.zzr().zzf().zza("Did not find conversion parameter. appId", zzfb.zza(zza11.zza.zzx()));
                                        }
                                    }
                                    z8 = z;
                                    if (!zzc3) {
                                    }
                                    if (zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzax)) {
                                    }
                                    zza9 = zza8;
                                    i10 = i6;
                                    if (zza14.zzb() == 0) {
                                    }
                                    j6 = j6;
                                    i2 = i11;
                                    zza11.zzc.set(i2, (zzbs.zzc) ((zzfe) zza14.zzv()));
                                    i12++;
                                    zza6.zza(zza14);
                                    zza13 = zza9;
                                    i9 = i5;
                                }
                                i11 = i2 + 1;
                                zzc2 = zza6;
                                str6 = str6;
                                zze3 = z5;
                                zza12 = zza5;
                            }
                            zzbs.zzg.zza zza20 = zzc2;
                            if (zze3) {
                                int i20 = i12;
                                long j7 = j6;
                                int i21 = 0;
                                while (i21 < i20) {
                                    zzbs.zzc zzb3 = zza20.zzb(i21);
                                    if ("_e".equals(zzb3.zzc())) {
                                        zzh();
                                        if (zzkr.zza(zzb3, "_fr") != null) {
                                            zza20.zzc(i21);
                                            i20--;
                                            i21--;
                                            i21++;
                                        }
                                    }
                                    zzh();
                                    zzbs.zze zza21 = zzkr.zza(zzb3, "_et");
                                    if (zza21 != null) {
                                        Long valueOf = zza21.zze() ? Long.valueOf(zza21.zzf()) : null;
                                        if (valueOf != null && valueOf.longValue() > 0) {
                                            j7 += valueOf.longValue();
                                        }
                                    }
                                    i21++;
                                }
                                j2 = j7;
                            } else {
                                j2 = j6;
                            }
                            zzkj.zza(zza20, j2, false);
                            if (zzkj.zzj.zzb().zze(zza20.zzj(), zzap.zzbm)) {
                                Iterator<zzbs.zzc> it = zza20.zza().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if ("_s".equals(it.next().zzc())) {
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        z4 = false;
                                        break;
                                    }
                                }
                                if (z4) {
                                    zze().zzb(zza20.zzj(), "_se");
                                }
                                if (zzms.zzb() && zzkj.zzj.zzb().zze(zza20.zzj(), zzap.zzbn)) {
                                    if (!(zzkr.zza(zza20, "_sid") >= 0)) {
                                        int zza22 = zzkr.zza(zza20, "_se");
                                        if (zza22 >= 0) {
                                            zza20.zze(zza22);
                                            if (!zzkw.zzb() || !zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzcx)) {
                                                zzkj.zzj.zzr().zzi().zza("Session engagement user property is in the bundle without session ID. appId", zzfb.zza(zza11.zza.zzx()));
                                            } else {
                                                zzkj.zzj.zzr().zzf().zza("Session engagement user property is in the bundle without session ID. appId", zzfb.zza(zza11.zza.zzx()));
                                            }
                                        }
                                    }
                                }
                                zzkj.zza(zza20, j2, true);
                            } else if (zzkj.zzj.zzb().zze(zza20.zzj(), zzap.zzbp)) {
                                zze().zzb(zza20.zzj(), "_se");
                            }
                            if (zzkj.zzj.zzb().zze(zza20.zzj(), zzap.zzaz)) {
                                zzkr zzh2 = zzh();
                                zzh2.zzr().zzx().zza("Checking account type status for ad personalization signals");
                                if (zzh2.zzj().zze(zza20.zzj()) && (zzb2 = zzh2.zzi().zzb(zza20.zzj())) != null && zzb2.zzaf() && zzh2.zzl().zzj()) {
                                    zzh2.zzr().zzw().zza("Turning off ad personalization due to account type");
                                    zzbs.zzk zzk2 = (zzbs.zzk) ((zzfe) zzbs.zzk.zzj().zza(str6).zza(zzh2.zzl().zzh()).zzb(1).zzv());
                                    int i22 = 0;
                                    while (true) {
                                        if (i22 >= zza20.zze()) {
                                            z3 = false;
                                            break;
                                        } else if (str6.equals(zza20.zzd(i22).zzc())) {
                                            zza20.zza(i22, zzk2);
                                            z3 = true;
                                            break;
                                        } else {
                                            i22++;
                                        }
                                    }
                                    if (!z3) {
                                        zza20.zza(zzk2);
                                    }
                                }
                            }
                            if (zzkj.zzj.zzb().zze(zza20.zzj(), zzap.zzce)) {
                                zza(zza20);
                            }
                            zza20.zzm().zzc(zzf().zza(zza20.zzj(), zza20.zza(), zza20.zzd(), Long.valueOf(zza20.zzf()), Long.valueOf(zza20.zzg())));
                            if (zzkj.zzj.zzb().zze(zza11.zza.zzx())) {
                                try {
                                    HashMap hashMap3 = new HashMap();
                                    ArrayList arrayList2 = new ArrayList();
                                    SecureRandom zzh3 = zzkj.zzj.zzi().zzh();
                                    int i23 = 0;
                                    while (i23 < zza20.zzb()) {
                                        zzbs.zzc.zza zza23 = (zzbs.zzc.zza) zza20.zzb(i23).zzbl();
                                        if (zza23.zzd().equals("_ep")) {
                                            zzh();
                                            String str8 = (String) zzkr.zzb((zzbs.zzc) ((zzfe) zza23.zzv()), "_en");
                                            zzaj zzaj = (zzaj) hashMap3.get(str8);
                                            if (zzaj == null) {
                                                zzaj = zze().zza(zza11.zza.zzx(), str8);
                                                hashMap3.put(str8, zzaj);
                                            }
                                            if (zzaj.zzi == null) {
                                                if (zzaj.zzj.longValue() > 1) {
                                                    zzh();
                                                    zzkr.zza(zza23, "_sr", zzaj.zzj);
                                                }
                                                if (zzaj.zzk != null && zzaj.zzk.booleanValue()) {
                                                    zzh();
                                                    zzkr.zza(zza23, "_efs", (Object) 1L);
                                                }
                                                arrayList2.add((zzbs.zzc) ((zzfe) zza23.zzv()));
                                            }
                                            zza20.zza(i23, zza23);
                                            hashMap = hashMap3;
                                            zza3 = zza20;
                                            secureRandom = zzh3;
                                        } else {
                                            long zzf2 = zzc().zzf(zza11.zza.zzx());
                                            zzkj.zzj.zzi();
                                            long zza24 = zzkv.zza(zza23.zzf(), zzf2);
                                            zzbs.zzc zzc4 = (zzbs.zzc) ((zzfe) zza23.zzv());
                                            Long l2 = 1L;
                                            if (TextUtils.isEmpty("_dbg") || l2 == null) {
                                                z2 = false;
                                            } else {
                                                Iterator<zzbs.zze> it2 = zzc4.zza().iterator();
                                                while (true) {
                                                    if (!it2.hasNext()) {
                                                        z2 = false;
                                                        break;
                                                    }
                                                    zzbs.zze next = it2.next();
                                                    if (!"_dbg".equals(next.zzb())) {
                                                        it2 = it2;
                                                    } else if ((!(l2 instanceof Long) || !l2.equals(Long.valueOf(next.zzf()))) && ((!(l2 instanceof String) || !l2.equals(next.zzd())) && (!(l2 instanceof Double) || !l2.equals(Double.valueOf(next.zzh()))))) {
                                                        z2 = false;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                }
                                            }
                                            if (!z2) {
                                                i = zzc().zzd(zza11.zza.zzx(), zza23.zzd());
                                            } else {
                                                i = 1;
                                            }
                                            if (i <= 0) {
                                                zzkj.zzj.zzr().zzi().zza("Sample rate must be positive. event, rate", zza23.zzd(), Integer.valueOf(i));
                                                arrayList2.add((zzbs.zzc) ((zzfe) zza23.zzv()));
                                                zza20.zza(i23, zza23);
                                                hashMap = hashMap3;
                                                zza3 = zza20;
                                                secureRandom = zzh3;
                                            } else {
                                                zzaj zzaj2 = (zzaj) hashMap3.get(zza23.zzd());
                                                if (zzaj2 == null) {
                                                    zzaj2 = zze().zza(zza11.zza.zzx(), zza23.zzd());
                                                    if (zzaj2 == null) {
                                                        j3 = zza24;
                                                        zzkj.zzj.zzr().zzi().zza("Event being bundled has no eventAggregate. appId, eventName", zza11.zza.zzx(), zza23.zzd());
                                                        if (zzkj.zzj.zzb().zze(zza11.zza.zzx(), zzap.zzbl)) {
                                                            zzaj2 = new zzaj(zza11.zza.zzx(), zza23.zzd(), 1, 1, 1, zza23.zzf(), 0, null, null, null, null);
                                                        } else {
                                                            zzaj2 = new zzaj(zza11.zza.zzx(), zza23.zzd(), 1, 1, zza23.zzf(), 0, null, null, null, null);
                                                        }
                                                    } else {
                                                        j3 = zza24;
                                                    }
                                                } else {
                                                    j3 = zza24;
                                                }
                                                zzh();
                                                Long l3 = (Long) zzkr.zzb((zzbs.zzc) ((zzfe) zza23.zzv()), "_eid");
                                                Boolean valueOf2 = Boolean.valueOf(l3 != null);
                                                if (i == 1) {
                                                    arrayList2.add((zzbs.zzc) ((zzfe) zza23.zzv()));
                                                    if (valueOf2.booleanValue() && !(zzaj2.zzi == null && zzaj2.zzj == null && zzaj2.zzk == null)) {
                                                        hashMap3.put(zza23.zzd(), zzaj2.zza(null, null, null));
                                                    }
                                                    zza20.zza(i23, zza23);
                                                    hashMap = hashMap3;
                                                    zza3 = zza20;
                                                    secureRandom = zzh3;
                                                } else {
                                                    if (zzh3.nextInt(i) == 0) {
                                                        zzh();
                                                        long j8 = (long) i;
                                                        zzkr.zza(zza23, "_sr", Long.valueOf(j8));
                                                        arrayList2.add((zzbs.zzc) ((zzfe) zza23.zzv()));
                                                        if (valueOf2.booleanValue()) {
                                                            zzaj2 = zzaj2.zza(null, Long.valueOf(j8), null);
                                                        }
                                                        hashMap3.put(zza23.zzd(), zzaj2.zza(zza23.zzf(), j3));
                                                        hashMap = hashMap3;
                                                        zza4 = zza20;
                                                        secureRandom = zzh3;
                                                    } else {
                                                        secureRandom = zzh3;
                                                        if (zzaj2.zzh != null) {
                                                            j4 = zzaj2.zzh.longValue();
                                                            hashMap2 = hashMap3;
                                                            zza4 = zza20;
                                                        } else {
                                                            zzkj.zzj.zzi();
                                                            zza4 = zza20;
                                                            hashMap2 = hashMap3;
                                                            j4 = zzkv.zza(zza23.zzg(), zzf2);
                                                        }
                                                        if (j4 != j3) {
                                                            zzh();
                                                            zzkr.zza(zza23, "_efs", (Object) 1L);
                                                            zzh();
                                                            long j9 = (long) i;
                                                            zzkr.zza(zza23, "_sr", Long.valueOf(j9));
                                                            arrayList2.add((zzbs.zzc) ((zzfe) zza23.zzv()));
                                                            if (valueOf2.booleanValue()) {
                                                                zzaj2 = zzaj2.zza(null, Long.valueOf(j9), true);
                                                            }
                                                            hashMap = hashMap2;
                                                            hashMap.put(zza23.zzd(), zzaj2.zza(zza23.zzf(), j3));
                                                        } else {
                                                            hashMap = hashMap2;
                                                            if (valueOf2.booleanValue()) {
                                                                hashMap.put(zza23.zzd(), zzaj2.zza(l3, null, null));
                                                            }
                                                        }
                                                    }
                                                    zza3 = zza4;
                                                    zza3.zza(i23, zza23);
                                                }
                                            }
                                        }
                                        i23++;
                                        zza20 = zza3;
                                        hashMap3 = hashMap;
                                        zzh3 = secureRandom;
                                        zzkj = this;
                                    }
                                    zza2 = zza20;
                                    if (arrayList2.size() < zza2.zzb()) {
                                        zza2.zzc().zza(arrayList2);
                                    }
                                    for (Map.Entry entry : hashMap3.entrySet()) {
                                        zze().zza((zzaj) entry.getValue());
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    zze().zzh();
                                    throw th;
                                }
                            } else {
                                zza2 = zza20;
                            }
                            try {
                                if (!this.zzj.zzb().zze(zza2.zzj(), zzap.zzce)) {
                                    zza(zza2);
                                }
                                String zzx2 = zza11.zza.zzx();
                                zzg zzb4 = zze().zzb(zzx2);
                                if (zzb4 == null) {
                                    this.zzj.zzr().zzf().zza("Bundling raw events w/o app info. appId", zzfb.zza(zza11.zza.zzx()));
                                } else if (zza2.zzb() > 0) {
                                    long zzk3 = zzb4.zzk();
                                    if (zzk3 != 0) {
                                        zza2.zze(zzk3);
                                    } else {
                                        zza2.zzi();
                                    }
                                    long zzj2 = zzb4.zzj();
                                    if (zzj2 != 0) {
                                        zzk3 = zzj2;
                                    }
                                    if (zzk3 != 0) {
                                        zza2.zzd(zzk3);
                                    } else {
                                        zza2.zzh();
                                    }
                                    zzb4.zzv();
                                    zza2.zzg((int) zzb4.zzs());
                                    zzb4.zza(zza2.zzf());
                                    zzb4.zzb(zza2.zzg());
                                    String zzad = zzb4.zzad();
                                    if (zzad != null) {
                                        zza2.zzj(zzad);
                                    } else {
                                        zza2.zzk();
                                    }
                                    zze().zza(zzb4);
                                }
                                if (zza2.zzb() > 0) {
                                    this.zzj.zzu();
                                    zzbq.zzb zza25 = zzc().zza(zza11.zza.zzx());
                                    if (zza25 != null) {
                                        if (zza25.zza()) {
                                            zza2.zzi(zza25.zzb());
                                            zze().zza((zzbs.zzg) ((zzfe) zza2.zzv()), z);
                                        }
                                    }
                                    if (TextUtils.isEmpty(zza11.zza.zzam())) {
                                        zza2.zzi(-1L);
                                    } else {
                                        this.zzj.zzr().zzi().zza("Did not find measurement config or missing version info. appId", zzfb.zza(zza11.zza.zzx()));
                                    }
                                    zze().zza((zzbs.zzg) ((zzfe) zza2.zzv()), z);
                                }
                                zzac zze4 = zze();
                                List<Long> list = zza11.zzb;
                                Preconditions.checkNotNull(list);
                                zze4.zzd();
                                zze4.zzak();
                                StringBuilder sb2 = new StringBuilder("rowid in (");
                                for (int i24 = 0; i24 < list.size(); i24++) {
                                    if (i24 != 0) {
                                        sb2.append(",");
                                    }
                                    sb2.append(list.get(i24).longValue());
                                }
                                sb2.append(")");
                                int delete = zze4.c_().delete("raw_events", sb2.toString(), null);
                                if (delete != list.size()) {
                                    zze4.zzr().zzf().zza("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
                                }
                                zzac zze5 = zze();
                                try {
                                    zze5.c_().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{zzx2, zzx2});
                                } catch (SQLiteException e2) {
                                    zze5.zzr().zzf().zza("Failed to remove unused event metadata. appId", zzfb.zza(zzx2), e2);
                                }
                                zze().b_();
                                zze().zzh();
                                return true;
                            } catch (Throwable th6) {
                                th = th6;
                                zze().zzh();
                                throw th;
                            }
                        } else {
                            zze().b_();
                            zze().zzh();
                            return false;
                        }
                    } else {
                        str3 = cursor2.getString(0);
                        String string = cursor2.getString(1);
                        cursor2.close();
                        cursor = cursor2;
                        str4 = string;
                    }
                } else {
                    String[] strArr3 = j5 != -1 ? new String[]{null, String.valueOf(j5)} : new String[]{null};
                    if (j5 != -1) {
                        str7 = " and rowid <= ?";
                    }
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str7).length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str7);
                    sb3.append(" order by rowid limit 1;");
                    Cursor rawQuery = c_.rawQuery(sb3.toString(), strArr3);
                    if (!rawQuery.moveToFirst()) {
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        if (!(zza11.zzc != null || zza11.zzc.isEmpty())) {
                        }
                    } else {
                        String string2 = rawQuery.getString(0);
                        rawQuery.close();
                        cursor = rawQuery;
                        str4 = string2;
                        str3 = null;
                    }
                }
                try {
                    Cursor query = c_.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, str4}, null, null, "rowid", "2");
                    if (!query.moveToFirst()) {
                        zze2.zzr().zzf().zza("Raw event metadata record is missing. appId", zzfb.zza(str3));
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        try {
                            zzbs.zzg zzg2 = (zzbs.zzg) ((zzfe) ((zzbs.zzg.zza) zzkr.zza(zzbs.zzg.zzbf(), query.getBlob(0))).zzv());
                            if (query.moveToNext()) {
                                zze2.zzr().zzi().zza("Get multiple raw event metadata records, expected one. appId", zzfb.zza(str3));
                            }
                            query.close();
                            zza11.zza(zzg2);
                            if (j5 != -1) {
                                str5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                strArr = new String[]{str3, str4, String.valueOf(j5)};
                            } else {
                                str5 = "app_id = ? and metadata_fingerprint = ?";
                                strArr = new String[]{str3, str4};
                            }
                            Cursor query2 = c_.query("raw_events", new String[]{"rowid", AppMeasurementSdk.ConditionalUserProperty.NAME, "timestamp", "data"}, str5, strArr, null, null, "rowid", null);
                            if (!query2.moveToFirst()) {
                                zze2.zzr().zzi().zza("Raw event data disappeared while in transaction. appId", zzfb.zza(str3));
                                if (query2 != null) {
                                    query2.close();
                                }
                            } else {
                                while (true) {
                                    long j10 = query2.getLong(0);
                                    try {
                                        zzbs.zzc.zza zza26 = (zzbs.zzc.zza) zzkr.zza(zzbs.zzc.zzj(), query2.getBlob(3));
                                        zza26.zza(query2.getString(1)).zza(query2.getLong(2));
                                        if (!zza11.zza(j10, (zzbs.zzc) ((zzfe) zza26.zzv()))) {
                                            if (query2 != null) {
                                                query2.close();
                                            }
                                        }
                                    } catch (IOException e3) {
                                        zze2.zzr().zzf().zza("Data loss. Failed to merge raw event. appId", zzfb.zza(str3), e3);
                                    }
                                    if (!query2.moveToNext()) {
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                    }
                                }
                            }
                        } catch (IOException e4) {
                            zze2.zzr().zzf().zza("Data loss. Failed to merge raw event metadata. appId", zzfb.zza(str3), e4);
                            if (query != null) {
                                query.close();
                            }
                        }
                    }
                } catch (SQLiteException e5) {
                    e = e5;
                    sQLiteException = e;
                    try {
                        zze2.zzr().zzf().zza("Data loss. Error selecting raw event. appId", zzfb.zza(str3), sQLiteException);
                        if (cursor != null) {
                        }
                        if (!(zza11.zzc != null || zza11.zzc.isEmpty())) {
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th8) {
                    th3 = th8;
                    cursor2 = cursor;
                    th2 = th3;
                    if (cursor2 != null) {
                    }
                    throw th2;
                }
            } catch (SQLiteException e6) {
                sQLiteException = e6;
                str3 = null;
                cursor = null;
                zze2.zzr().zzf().zza("Data loss. Error selecting raw event. appId", zzfb.zza(str3), sQLiteException);
                if (cursor != null) {
                    cursor.close();
                }
                if (!(zza11.zzc != null || zza11.zzc.isEmpty())) {
                }
            } catch (Throwable th9) {
                th3 = th9;
                cursor2 = null;
                th2 = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
            if (!(zza11.zzc != null || zza11.zzc.isEmpty())) {
            }
        } catch (Throwable th10) {
            th = th10;
            zze().zzh();
            throw th;
        }
    }

    private static void zza(zzbs.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbs.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    private final void zza(zzbs.zzg.zza zza2, long j, boolean z) {
        String str;
        zzks zzks;
        String str2;
        if (z) {
            str = "_se";
        } else {
            str = "_lte";
        }
        zzks zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzks = new zzks(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzks = new zzks(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbs.zzk zzk2 = (zzbs.zzk) ((zzfe) zzbs.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzks.zze).longValue()).zzv());
        boolean z2 = false;
        int zza3 = zzkr.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzks);
            if (z) {
                str2 = "session-scoped";
            } else {
                str2 = "lifetime";
            }
            if (!zzkw.zzb() || !this.zzj.zzb().zze(zza2.zzj(), zzap.zzcx)) {
                this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", str2, zzks.zze);
            } else {
                this.zzj.zzr().zzx().zza("Updated engagement user property. scope, value", str2, zzks.zze);
            }
        }
    }

    private final boolean zza(zzbs.zzc.zza zza2, zzbs.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbs.zze zza4 = zzkr.zza((zzbs.zzc) ((zzfe) zza2.zzv()), "_sc");
        String str = null;
        String zzd2 = zza4 == null ? null : zza4.zzd();
        zzh();
        zzbs.zze zza5 = zzkr.zza((zzbs.zzc) ((zzfe) zza3.zzv()), "_pc");
        if (zza5 != null) {
            str = zza5.zzd();
        }
        if (str == null || !str.equals(zzd2)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzbs.zzc.zza zza2, zzbs.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzbs.zze zza4 = zzkr.zza((zzbs.zzc) ((zzfe) zza2.zzv()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzbs.zze zza5 = zzkr.zza((zzbs.zzc) ((zzfe) zza3.zzv()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh();
            zzkr.zza(zza3, "_et", Long.valueOf(zzf2));
            zzh();
            zzkr.zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzbs.zzc.zza zza2, String str) {
        List<zzbs.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzbs.zzc.zza zza2, int i, String str) {
        List<zzbs.zze> zza3 = zza2.zza();
        for (int i2 = 0; i2 < zza3.size(); i2++) {
            if ("_err".equals(zza3.get(i2).zzb())) {
                return;
            }
        }
        zza2.zza((zzbs.zze) ((zzfe) zzbs.zze.zzk().zza("_err").zza(Long.valueOf((long) i).longValue()).zzv())).zza((zzbs.zze) ((zzfe) zzbs.zze.zzk().zza("_ev").zzb(str).zzv()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long l : list) {
                        try {
                            zzac zze2 = zze();
                            long longValue = l.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            try {
                                if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            if (this.zzx == null || !this.zzx.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzx = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzy = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzs = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzg zzg2) {
        ArrayMap arrayMap;
        zzw();
        if (!zzln.zzb() || !this.zzj.zzb().zze(zzg2.zzc(), zzap.zzcf)) {
            if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzf())) {
                zza(zzg2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzg2.zze()) && TextUtils.isEmpty(zzg2.zzg()) && TextUtils.isEmpty(zzg2.zzf())) {
            zza(zzg2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzj.zzb().zza(zzg2);
        try {
            URL url = new URL(zza2);
            this.zzj.zzr().zzx().zza("Fetching remote configuration", zzg2.zzc());
            zzbq.zzb zza3 = zzc().zza(zzg2.zzc());
            String zzb2 = zzc().zzb(zzg2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzff zzd2 = zzd();
            String zzc2 = zzg2.zzc();
            zzko zzko = new zzko(this);
            zzd2.zzd();
            zzd2.zzak();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzko);
            zzd2.zzq().zzb(new zzfj(zzd2, zzc2, url, null, arrayMap, zzko));
        } catch (MalformedURLException e) {
            this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzfb.zza(zzg2.zzc()), zza2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0152  */
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        String str2;
        zzw();
        zzk();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzr = false;
                zzaa();
                throw th2;
            }
        }
        this.zzj.zzr().zzx().zza("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zze().zzf();
        try {
            zzg zzb2 = zze().zzb(str);
            boolean z = true;
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzb2 == null) {
                this.zzj.zzr().zzi().zza("App does not exist in onConfigFetched. appId", zzfb.zza(str));
            } else {
                if (!z2) {
                    if (i != 404) {
                        zzb2.zzi(this.zzj.zzm().currentTimeMillis());
                        zze().zza(zzb2);
                        this.zzj.zzr().zzx().zza("Fetching config failed. code, error", Integer.valueOf(i), th);
                        zzc().zzc(str);
                        this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
                        if (i != 503) {
                            if (i != 429) {
                                z = false;
                            }
                        }
                        if (z) {
                            this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
                        }
                        zzz();
                    }
                }
                List<String> list = map != null ? map.get("Last-Modified") : null;
                if (list == null || list.size() <= 0) {
                    str2 = null;
                } else {
                    str2 = list.get(0);
                }
                if (i != 404) {
                    if (i != 304) {
                        if (!zzc().zza(str, bArr, str2)) {
                            zze().zzh();
                            this.zzr = false;
                            zzaa();
                            return;
                        }
                        zzb2.zzh(this.zzj.zzm().currentTimeMillis());
                        zze().zza(zzb2);
                        if (i != 404) {
                            this.zzj.zzr().zzk().zza("Config not found. Using empty config. appId", str);
                        } else {
                            this.zzj.zzr().zzx().zza("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                        }
                        if (zzd().zzf() || !zzy()) {
                            zzz();
                        } else {
                            zzl();
                        }
                    }
                }
                if (zzc().zza(str) == null && !zzc().zza(str, null, null)) {
                    zze().zzh();
                    this.zzr = false;
                    zzaa();
                    return;
                }
                zzb2.zzh(this.zzj.zzm().currentTimeMillis());
                zze().zza(zzb2);
                if (i != 404) {
                }
                if (zzd().zzf()) {
                }
                zzz();
            }
            zze().b_();
            zze().zzh();
            this.zzr = false;
            zzaa();
        } catch (Throwable th3) {
            zze().zzh();
            throw th3;
        }
    }

    private final void zzz() {
        long j;
        long j2;
        zzw();
        zzk();
        if (zzac() || this.zzj.zzb().zza(zzap.zzbb)) {
            if (this.zzn > 0) {
                long abs = 3600000 - Math.abs(this.zzj.zzm().elapsedRealtime() - this.zzn);
                if (abs > 0) {
                    this.zzj.zzr().zzx().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzt().zzb();
                    zzv().zzf();
                    return;
                }
                this.zzn = 0;
            }
            if (!this.zzj.zzah() || !zzy()) {
                this.zzj.zzr().zzx().zza("Nothing to upload or uploading impossible");
                zzt().zzb();
                zzv().zzf();
                return;
            }
            long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
            long max = Math.max(0L, zzap.zzz.zza(null).longValue());
            boolean z = zze().zzz() || zze().zzk();
            if (z) {
                String zzv2 = this.zzj.zzb().zzv();
                if (TextUtils.isEmpty(zzv2) || ".none.".equals(zzv2)) {
                    j = Math.max(0L, zzap.zzt.zza(null).longValue());
                } else {
                    j = Math.max(0L, zzap.zzu.zza(null).longValue());
                }
            } else {
                j = Math.max(0L, zzap.zzs.zza(null).longValue());
            }
            long zza2 = this.zzj.zzc().zzc.zza();
            long zza3 = this.zzj.zzc().zzd.zza();
            long max2 = Math.max(zze().zzw(), zze().zzx());
            if (max2 == 0) {
                j2 = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(zza3 - currentTimeMillis);
                long max3 = Math.max(abs3, abs4);
                j2 = abs2 + max;
                if (z && max3 > 0) {
                    j2 = Math.min(abs2, max3) + j;
                }
                if (!zzh().zza(max3, j)) {
                    j2 = max3 + j;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        if (i >= Math.min(20, Math.max(0, zzap.zzab.zza(null).intValue()))) {
                            j2 = 0;
                            break;
                        }
                        j2 += Math.max(0L, zzap.zzaa.zza(null).longValue()) * (1 << i);
                        if (j2 > abs4) {
                            break;
                        }
                        i++;
                    }
                }
            }
            if (j2 == 0) {
                this.zzj.zzr().zzx().zza("Next upload time is 0");
                zzt().zzb();
                zzv().zzf();
            } else if (!zzd().zzf()) {
                this.zzj.zzr().zzx().zza("No network");
                zzt().zza();
                zzv().zzf();
            } else {
                long zza4 = this.zzj.zzc().zze.zza();
                long max4 = Math.max(0L, zzap.zzq.zza(null).longValue());
                if (!zzh().zza(zza4, max4)) {
                    j2 = Math.max(j2, zza4 + max4);
                }
                zzt().zzb();
                long currentTimeMillis2 = j2 - this.zzj.zzm().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0L, zzap.zzv.zza(null).longValue());
                    this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                }
                this.zzj.zzr().zzx().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzv().zza(currentTimeMillis2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    private final void zzaa() {
        zzw();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzo.clear();
        }
    }

    private final Boolean zzb(zzg zzg2) {
        try {
            if (zzg2.zzm() != -2147483648L) {
                if (zzg2.zzm() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzg2.zzc(), 0).versionName;
                if (zzg2.zzl() != null && zzg2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzap.zzcd) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzv = channel;
                FileLock tryLock = channel.tryLock();
                this.zzu = tryLock;
                if (tryLock != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzj.zzb().zza(zzap.zzcs) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzm) {
            this.zzm = true;
            zzw();
            zzk();
            if ((this.zzj.zzb().zza(zzap.zzbb) || zzac()) && zzab()) {
                int zza2 = zza(this.zzv);
                int zzaf = this.zzj.zzy().zzaf();
                zzw();
                if (zza2 > zzaf) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                } else if (zza2 < zzaf) {
                    if (zza(zzaf, this.zzv)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzaf));
                    }
                }
            }
        }
        if (!this.zzl && !this.zzj.zzb().zza(zzap.zzbb)) {
            this.zzj.zzr().zzv().zza("This instance being marked as an uploader");
            this.zzl = true;
            zzz();
        }
    }

    private final boolean zzac() {
        zzw();
        zzk();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzm zzm2) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzac zze2 = zze();
        String str = zzm2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzfb.zza(str), e);
        }
        if (!zzkp.zzb() || !this.zzj.zzb().zza(zzap.zzck)) {
            zzm zza2 = zza(this.zzj.zzn(), zzm2.zza, zzm2.zzb, zzm2.zzh, zzm2.zzo, zzm2.zzp, zzm2.zzm, zzm2.zzr, zzm2.zzv);
            if (zzm2.zzh) {
                zzb(zza2);
            }
        } else if (zzm2.zzh) {
            zzb(zzm2);
        }
    }

    private final zzm zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        int i;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzfb.zza(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str6 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str6 = "";
        } else {
            str6 = str5;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    applicationLabel.toString();
                }
                str7 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                i = Integer.MIN_VALUE;
                str7 = "Unknown";
            }
            return new zzm(str, str2, str7, (long) i, str6, this.zzj.zzb().zze(), this.zzj.zzi().zza(context, str), (String) null, z, false, "", 0L, j, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null, (!zzln.zzb() || !this.zzj.zzb().zze(str, zzap.zzcf)) ? null : str4);
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzfb.zza(str), "Unknown");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkq zzkq, zzm zzm2) {
        zzaj zza2;
        int i;
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            int zzc2 = this.zzj.zzi().zzc(zzkq.zza);
            if (zzc2 != 0) {
                this.zzj.zzi();
                this.zzj.zzi().zza(zzm2.zza, zzc2, "_ev", zzkv.zza(zzkq.zza, 24, true), zzkq.zza != null ? zzkq.zza.length() : 0);
                return;
            }
            int zzb2 = this.zzj.zzi().zzb(zzkq.zza, zzkq.zza());
            if (zzb2 != 0) {
                this.zzj.zzi();
                String zza3 = zzkv.zza(zzkq.zza, 24, true);
                Object zza4 = zzkq.zza();
                if (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) {
                    i = 0;
                } else {
                    i = String.valueOf(zza4).length();
                }
                this.zzj.zzi().zza(zzm2.zza, zzb2, "_ev", zza3, i);
                return;
            }
            Object zzc3 = this.zzj.zzi().zzc(zzkq.zza, zzkq.zza());
            if (zzc3 != null) {
                if ("_sid".equals(zzkq.zza) && this.zzj.zzb().zze(zzm2.zza, zzap.zzap)) {
                    long j = zzkq.zzb;
                    String str = zzkq.zze;
                    long j2 = 0;
                    zzks zzc4 = zze().zzc(zzm2.zza, "_sno");
                    if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                        if (zzc4 != null) {
                            this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                        }
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzas) && (zza2 = zze().zza(zzm2.zza, "_s")) != null) {
                            j2 = zza2.zzc;
                            this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc4.zze).longValue();
                    }
                    zza(new zzkq("_sno", j, Long.valueOf(j2 + 1), str), zzm2);
                }
                zzks zzks = new zzks(zzm2.zza, zzkq.zze, zzkq.zza, zzkq.zzb, zzc3);
                if (!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) {
                    this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzks.zzc), zzc3);
                } else {
                    this.zzj.zzr().zzx().zza("Setting user property", this.zzj.zzj().zzc(zzks.zzc), zzc3);
                }
                zze().zzf();
                try {
                    zzc(zzm2);
                    boolean zza5 = zze().zza(zzks);
                    zze().b_();
                    if (!zza5) {
                        this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                        this.zzj.zzi().zza(zzm2.zza, 9, (String) null, (String) null, 0);
                    } else if (!zzkw.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcx)) {
                        this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                    }
                } finally {
                    zze().zzh();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzkq zzkq, zzm zzm2) {
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
            } else if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzaz)) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkq.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkq.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkq.zza));
                } finally {
                    zze().zzh();
                }
            } else if (!"_npa".equals(zzkq.zza) || zzm2.zzs == null) {
                this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzkq.zza));
                zze().zzf();
                try {
                    zzc(zzm2);
                    zze().zzb(zzm2.zza, zzkq.zza);
                    zze().b_();
                    this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzkq.zza));
                } finally {
                    zze().zzh();
                }
            } else {
                this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzkq("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto"), zzm2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkk zzkk) {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final zzgf zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0232  */
    public final void zzb(zzm zzm2) {
        String str;
        int i;
        String str2;
        zzaj zzaj;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        boolean z2;
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        if (zze(zzm2)) {
            zzg zzb2 = zze().zzb(zzm2.zza);
            if (zzb2 != null && TextUtils.isEmpty(zzb2.zze()) && !TextUtils.isEmpty(zzm2.zzb)) {
                zzb2.zzh(0);
                zze().zza(zzb2);
                zzc().zzd(zzm2.zza);
            }
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            long j = zzm2.zzm;
            if (j == 0) {
                j = this.zzj.zzm().currentTimeMillis();
            }
            if (this.zzj.zzb().zze(zzm2.zza, zzap.zzaz)) {
                this.zzj.zzx().zzi();
            }
            int i2 = zzm2.zzn;
            if (!(i2 == 0 || i2 == 1)) {
                this.zzj.zzr().zzi().zza("Incorrect app type, assuming installed app. appId, appType", zzfb.zza(zzm2.zza), Integer.valueOf(i2));
                i2 = 0;
            }
            zze().zzf();
            try {
                if (this.zzj.zzb().zze(zzm2.zza, zzap.zzaz)) {
                    zzks zzc2 = zze().zzc(zzm2.zza, "_npa");
                    if (zzc2 != null) {
                        if (!"auto".equals(zzc2.zzb)) {
                            str = "_sysu";
                            i = 1;
                        }
                    }
                    if (zzm2.zzs != null) {
                        str = "_sysu";
                        i = 1;
                        zzkq zzkq = new zzkq("_npa", j, Long.valueOf(zzm2.zzs.booleanValue() ? 1 : 0), "auto");
                        if (zzc2 == null || !zzc2.zze.equals(zzkq.zzc)) {
                            zza(zzkq, zzm2);
                        }
                    } else {
                        str = "_sysu";
                        i = 1;
                        if (zzc2 != null) {
                            zzb(new zzkq("_npa", j, null, "auto"), zzm2);
                        }
                    }
                } else {
                    str = "_sysu";
                    i = 1;
                }
                zzg zzb3 = zze().zzb(zzm2.zza);
                if (zzb3 != null) {
                    this.zzj.zzi();
                    if (zzkv.zza(zzm2.zzb, zzb3.zze(), zzm2.zzr, zzb3.zzf())) {
                        this.zzj.zzr().zzi().zza("New GMP App Id passed in. Removing cached database data. appId", zzfb.zza(zzb3.zzc()));
                        zzac zze2 = zze();
                        String zzc3 = zzb3.zzc();
                        zze2.zzak();
                        zze2.zzd();
                        Preconditions.checkNotEmpty(zzc3);
                        try {
                            SQLiteDatabase c_ = zze2.c_();
                            String[] strArr = new String[i];
                            strArr[0] = zzc3;
                            int delete = c_.delete("events", "app_id=?", strArr) + 0 + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("apps", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("event_filters", "app_id=?", strArr) + c_.delete("property_filters", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr);
                            if (delete > 0) {
                                zze2.zzr().zzx().zza("Deleted application data. app, records", zzc3, Integer.valueOf(delete));
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Error deleting application data. appId, error", zzfb.zza(zzc3), e);
                        }
                        zzb3 = null;
                    }
                }
                if (zzb3 != null) {
                    if (zzb3.zzm() != -2147483648L) {
                        str2 = "_sys";
                        if (zzb3.zzm() != zzm2.zzj) {
                            z2 = true;
                            if (z2 || ((zzb3.zzm() == -2147483648L || zzb3.zzl() == null || zzb3.zzl().equals(zzm2.zzc)) ? false : true)) {
                                Bundle bundle = new Bundle();
                                bundle.putString("_pv", zzb3.zzl());
                                zza(new zzan("_au", new zzam(bundle), "auto", j), zzm2);
                            }
                        }
                    } else {
                        str2 = "_sys";
                    }
                    z2 = false;
                    if (z2 || ((zzb3.zzm() == -2147483648L || zzb3.zzl() == null || zzb3.zzl().equals(zzm2.zzc)) ? false : true)) {
                    }
                } else {
                    str2 = "_sys";
                }
                zzc(zzm2);
                if (i2 == 0) {
                    zzaj = zze().zza(zzm2.zza, "_f");
                } else if (i2 == 1) {
                    zzaj = zze().zza(zzm2.zza, "_v");
                } else {
                    zzaj = null;
                }
                if (zzaj == null) {
                    long j2 = ((j / 3600000) + 1) * 3600000;
                    if (i2 == 0) {
                        zza(new zzkq("_fot", j, Long.valueOf(j2), "auto"), zzm2);
                        if (this.zzj.zzb().zze(zzm2.zzb, zzap.zzan)) {
                            zzw();
                            this.zzj.zzf().zza(zzm2.zza);
                        }
                        zzw();
                        zzk();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1);
                        bundle2.putLong("_r", 1);
                        bundle2.putLong("_uwa", 0);
                        bundle2.putLong("_pfo", 0);
                        bundle2.putLong(str2, 0);
                        bundle2.putLong(str, 0);
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzax)) {
                            bundle2.putLong("_et", 1);
                        }
                        if (zzm2.zzq) {
                            bundle2.putLong("_dac", 1);
                        }
                        zzac zze3 = zze();
                        String str4 = zzm2.zza;
                        Preconditions.checkNotEmpty(str4);
                        zze3.zzd();
                        zze3.zzak();
                        long zzh2 = zze3.zzh(str4, "first_open_count");
                        if (this.zzj.zzn().getPackageManager() == null) {
                            this.zzj.zzr().zzf().zza("PackageManager is null, first open report might be inaccurate. appId", zzfb.zza(zzm2.zza));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzm2.zza, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.zzj.zzr().zzf().zza("Package info is null, first open report might be inaccurate. appId", zzfb.zza(zzm2.zza), e2);
                                packageInfo = null;
                            }
                            if (packageInfo == null) {
                                str3 = str;
                            } else if (packageInfo.firstInstallTime != 0) {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    if (!this.zzj.zzb().zza(zzap.zzcl)) {
                                        bundle2.putLong("_uwa", 1);
                                    } else if (zzh2 == 0) {
                                        bundle2.putLong("_uwa", 1);
                                    }
                                    z = false;
                                } else {
                                    z = true;
                                }
                                str3 = str;
                                zza(new zzkq("_fi", j, Long.valueOf(z ? 1 : 0), "auto"), zzm2);
                            } else {
                                str3 = str;
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzj.zzn()).getApplicationInfo(zzm2.zza, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                this.zzj.zzr().zzf().zza("Application info is null, first open report might be inaccurate. appId", zzfb.zza(zzm2.zza), e3);
                                applicationInfo = null;
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    bundle2.putLong(str2, 1);
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle2.putLong(str3, 1);
                                }
                            }
                        }
                        if (zzh2 >= 0) {
                            bundle2.putLong("_pfo", zzh2);
                        }
                        zza(new zzan("_f", new zzam(bundle2), "auto", j), zzm2);
                    } else if (i2 == 1) {
                        zza(new zzkq("_fvt", j, Long.valueOf(j2), "auto"), zzm2);
                        zzw();
                        zzk();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1);
                        bundle3.putLong("_r", 1);
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzax)) {
                            bundle3.putLong("_et", 1);
                        }
                        if (zzm2.zzq) {
                            bundle3.putLong("_dac", 1);
                        }
                        zza(new zzan("_v", new zzam(bundle3), "auto", j), zzm2);
                    }
                    if (!this.zzj.zzb().zze(zzm2.zza, zzap.zzay)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_et", 1);
                        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzax)) {
                            bundle4.putLong("_fr", 1);
                        }
                        zza(new zzan("_e", new zzam(bundle4), "auto", j), zzm2);
                    }
                } else if (zzm2.zzi) {
                    zza(new zzan("_cd", new zzam(new Bundle()), "auto", j), zzm2);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    private final zzm zza(String str) {
        String str2;
        zzg zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            String zze2 = zzb2.zze();
            String zzl2 = zzb2.zzl();
            long zzm2 = zzb2.zzm();
            String zzn2 = zzb2.zzn();
            long zzo2 = zzb2.zzo();
            long zzp2 = zzb2.zzp();
            boolean zzr2 = zzb2.zzr();
            String zzi2 = zzb2.zzi();
            long zzae = zzb2.zzae();
            boolean zzaf = zzb2.zzaf();
            boolean zzag = zzb2.zzag();
            String zzf2 = zzb2.zzf();
            Boolean zzah = zzb2.zzah();
            long zzq2 = zzb2.zzq();
            List<String> zzai = zzb2.zzai();
            if (!zzln.zzb() || !this.zzj.zzb().zze(str, zzap.zzcf)) {
                str2 = null;
            } else {
                str2 = zzb2.zzg();
            }
            return new zzm(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, zzr2, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2);
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzfb.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zza(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzv zzv2, zzm zzm2) {
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzb);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zzv zzv3 = new zzv(zzv2);
            boolean z = false;
            zzv3.zze = false;
            zze().zzf();
            try {
                zzv zzd2 = zze().zzd(zzv3.zza, zzv3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzv3.zzb)) {
                    this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzv3.zzb = zzd2.zzb;
                    zzv3.zzd = zzd2.zzd;
                    zzv3.zzh = zzd2.zzh;
                    zzv3.zzf = zzd2.zzf;
                    zzv3.zzi = zzd2.zzi;
                    zzv3.zze = zzd2.zze;
                    zzv3.zzc = new zzkq(zzv3.zzc.zza, zzd2.zzc.zzb, zzv3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzv3.zzf)) {
                    zzv3.zzc = new zzkq(zzv3.zzc.zza, zzv3.zzd, zzv3.zzc.zza(), zzv3.zzc.zze);
                    zzv3.zze = true;
                    z = true;
                }
                if (zzv3.zze) {
                    zzkq zzkq = zzv3.zzc;
                    zzks zzks = new zzks(zzv3.zza, zzv3.zzb, zzkq.zza, zzkq.zzb, zzkq.zza());
                    if (zze().zza(zzks)) {
                        this.zzj.zzr().zzw().zza("User property updated immediately", zzv3.zza, this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                    } else {
                        this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzfb.zza(zzv3.zza), this.zzj.zzj().zzc(zzks.zzc), zzks.zze);
                    }
                    if (z && zzv3.zzi != null) {
                        zzb(new zzan(zzv3.zzi, zzv3.zzd), zzm2);
                    }
                }
                if (zze().zza(zzv3)) {
                    this.zzj.zzr().zzw().zza("Conditional property added", zzv3.zza, this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                } else {
                    this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzfb.zza(zzv3.zza), this.zzj.zzj().zzc(zzv3.zzc.zza), zzv3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2) {
        zzm zza2 = zza(zzv2.zza);
        if (zza2 != null) {
            zzb(zzv2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzv zzv2, zzm zzm2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzv2);
        Preconditions.checkNotEmpty(zzv2.zza);
        Preconditions.checkNotNull(zzv2.zzc);
        Preconditions.checkNotEmpty(zzv2.zzc.zza);
        zzw();
        zzk();
        if (zze(zzm2)) {
            if (!zzm2.zzh) {
                zzc(zzm2);
                return;
            }
            zze().zzf();
            try {
                zzc(zzm2);
                zzv zzd2 = zze().zzd(zzv2.zza, zzv2.zzc.zza);
                if (zzd2 != null) {
                    this.zzj.zzr().zzw().zza("Removing conditional user property", zzv2.zza, this.zzj.zzj().zzc(zzv2.zzc.zza));
                    zze().zze(zzv2.zza, zzv2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzv2.zza, zzv2.zzc.zza);
                    }
                    if (zzv2.zzk != null) {
                        if (zzv2.zzk.zzb != null) {
                            bundle = zzv2.zzk.zzb.zzb();
                        } else {
                            bundle = null;
                        }
                        zzb(this.zzj.zzi().zza(zzv2.zza, zzv2.zzk.zza, bundle, zzd2.zzb, zzv2.zzk.zzd, true, false), zzm2);
                    }
                } else {
                    this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzfb.zza(zzv2.zza), this.zzj.zzj().zzc(zzv2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    private final zzg zza(zzm zzm2, zzg zzg2, String str) {
        boolean z;
        boolean z2 = true;
        if (zzg2 == null) {
            zzg2 = new zzg(this.zzj, zzm2.zza);
            zzg2.zza(this.zzj.zzi().zzk());
            zzg2.zze(str);
            z = true;
        } else if (!str.equals(zzg2.zzh())) {
            zzg2.zze(str);
            zzg2.zza(this.zzj.zzi().zzk());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzm2.zzb, zzg2.zze())) {
            zzg2.zzb(zzm2.zzb);
            z = true;
        }
        if (!TextUtils.equals(zzm2.zzr, zzg2.zzf())) {
            zzg2.zzc(zzm2.zzr);
            z = true;
        }
        if (zzln.zzb() && this.zzj.zzb().zze(zzg2.zzc(), zzap.zzcf) && !TextUtils.equals(zzm2.zzv, zzg2.zzg())) {
            zzg2.zzd(zzm2.zzv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzk) && !zzm2.zzk.equals(zzg2.zzi())) {
            zzg2.zzf(zzm2.zzk);
            z = true;
        }
        if (!(zzm2.zze == 0 || zzm2.zze == zzg2.zzo())) {
            zzg2.zzd(zzm2.zze);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzc) && !zzm2.zzc.equals(zzg2.zzl())) {
            zzg2.zzg(zzm2.zzc);
            z = true;
        }
        if (zzm2.zzj != zzg2.zzm()) {
            zzg2.zzc(zzm2.zzj);
            z = true;
        }
        if (zzm2.zzd != null && !zzm2.zzd.equals(zzg2.zzn())) {
            zzg2.zzh(zzm2.zzd);
            z = true;
        }
        if (zzm2.zzf != zzg2.zzp()) {
            zzg2.zze(zzm2.zzf);
            z = true;
        }
        if (zzm2.zzh != zzg2.zzr()) {
            zzg2.zza(zzm2.zzh);
            z = true;
        }
        if (!TextUtils.isEmpty(zzm2.zzg) && !zzm2.zzg.equals(zzg2.zzac())) {
            zzg2.zzi(zzm2.zzg);
            z = true;
        }
        if (zzm2.zzl != zzg2.zzae()) {
            zzg2.zzp(zzm2.zzl);
            z = true;
        }
        if (zzm2.zzo != zzg2.zzaf()) {
            zzg2.zzb(zzm2.zzo);
            z = true;
        }
        if (zzm2.zzp != zzg2.zzag()) {
            zzg2.zzc(zzm2.zzp);
            z = true;
        }
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzaz) && zzm2.zzs != zzg2.zzah()) {
            zzg2.zza(zzm2.zzs);
            z = true;
        }
        if (zzm2.zzt == 0 || zzm2.zzt == zzg2.zzq()) {
            z2 = z;
        } else {
            zzg2.zzf(zzm2.zzt);
        }
        if (z2) {
            zze().zza(zzg2);
        }
        return zzg2;
    }

    /* access modifiers changed from: package-private */
    public final zzg zzc(zzm zzm2) {
        zzw();
        zzk();
        Preconditions.checkNotNull(zzm2);
        Preconditions.checkNotEmpty(zzm2.zza);
        zzg zzb2 = zze().zzb(zzm2.zza);
        String zzb3 = this.zzj.zzc().zzb(zzm2.zza);
        if (!zzkq.zzb() || !this.zzj.zzb().zza(zzap.zzcn)) {
            return zza(zzm2, zzb2, zzb3);
        }
        if (zzb2 == null) {
            zzb2 = new zzg(this.zzj, zzm2.zza);
            zzb2.zza(this.zzj.zzi().zzk());
            zzb2.zze(zzb3);
        } else if (!zzb3.equals(zzb2.zzh())) {
            zzb2.zze(zzb3);
            zzb2.zza(this.zzj.zzi().zzk());
        }
        zzb2.zzb(zzm2.zzb);
        zzb2.zzc(zzm2.zzr);
        if (zzln.zzb() && this.zzj.zzb().zze(zzb2.zzc(), zzap.zzcf)) {
            zzb2.zzd(zzm2.zzv);
        }
        if (!TextUtils.isEmpty(zzm2.zzk)) {
            zzb2.zzf(zzm2.zzk);
        }
        if (zzm2.zze != 0) {
            zzb2.zzd(zzm2.zze);
        }
        if (!TextUtils.isEmpty(zzm2.zzc)) {
            zzb2.zzg(zzm2.zzc);
        }
        zzb2.zzc(zzm2.zzj);
        if (zzm2.zzd != null) {
            zzb2.zzh(zzm2.zzd);
        }
        zzb2.zze(zzm2.zzf);
        zzb2.zza(zzm2.zzh);
        if (!TextUtils.isEmpty(zzm2.zzg)) {
            zzb2.zzi(zzm2.zzg);
        }
        zzb2.zzp(zzm2.zzl);
        zzb2.zzb(zzm2.zzo);
        zzb2.zzc(zzm2.zzp);
        if (this.zzj.zzb().zze(zzm2.zza, zzap.zzaz)) {
            zzb2.zza(zzm2.zzs);
        }
        zzb2.zzf(zzm2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzm zzm2) {
        try {
            return (String) this.zzj.zzq().zza(new zzkn(this, zzm2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzfb.zza(zzm2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }

    private final boolean zze(zzm zzm2) {
        return (!zzln.zzb() || !this.zzj.zzb().zze(zzm2.zza, zzap.zzcf)) ? !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzr) : !TextUtils.isEmpty(zzm2.zzb) || !TextUtils.isEmpty(zzm2.zzv) || !TextUtils.isEmpty(zzm2.zzr);
    }
}
