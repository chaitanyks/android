package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public abstract class zzcn<T> {
    private static final Object zza = new Object();
    private static Context zzb = null;
    private static boolean zzc = false;
    private static zzdb<zzcw<zzcj>> zzd;
    private static final AtomicInteger zzh = new AtomicInteger();
    private final zzct zze;
    private final String zzf;
    private final T zzg;
    private volatile int zzi;
    private volatile T zzj;

    public static void zza(Context context) {
        synchronized (zza) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzb != context) {
                zzbz.zzc();
                zzcs.zza();
                zzce.zza();
                zzh.incrementAndGet();
                zzb = context;
                zzd = zzda.zza(zzcm.zza);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(Object obj);

    static void zza() {
        zzh.incrementAndGet();
    }

    private zzcn(zzct zzct, String str, T t) {
        this.zzi = -1;
        if (zzct.zzb != null) {
            this.zze = zzct;
            this.zzf = str;
            this.zzg = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzf;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzf);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zzb() {
        return zza(this.zze.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7  */
    public final T zzc() {
        T t;
        zzcw<zzcj> zza2;
        zzcd zzcd;
        Object zza3;
        int i = zzh.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    if (zzb != null) {
                        String str = (String) zzce.zza(zzb).zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
                        if (!(str != null && zzbv.zzb.matcher(str).matches())) {
                            if (this.zze.zzb == null) {
                                zzcd = zzcs.zza(zzb, (String) null);
                            } else if (zzcl.zza(zzb, this.zze.zzb)) {
                                zzcd = zzbz.zza(zzb.getContentResolver(), this.zze.zzb);
                            } else {
                                zzcd = null;
                            }
                            if (zzcd != null && (zza3 = zzcd.zza(zzb())) != null) {
                                t = zza(zza3);
                                if (t != null) {
                                    Object zza4 = zzce.zza(zzb).zza(zza(this.zze.zzc));
                                    if (zza4 != null) {
                                        t = zza(zza4);
                                    } else {
                                        t = null;
                                    }
                                    if (t == null) {
                                        t = this.zzg;
                                    }
                                }
                                zza2 = zzd.zza();
                                if (zza2.zza()) {
                                    String zza5 = zza2.zzb().zza(this.zze.zzb, null, this.zze.zzd, this.zzf);
                                    t = zza5 == null ? this.zzg : zza((Object) zza5);
                                }
                                this.zzj = t;
                                this.zzi = i;
                            }
                        } else if (Log.isLoggable("PhenotypeFlag", 3)) {
                            String valueOf = String.valueOf(zzb());
                            Log.d("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
                        }
                        t = null;
                        if (t != null) {
                        }
                        zza2 = zzd.zza();
                        if (zza2.zza()) {
                        }
                        this.zzj = t;
                        this.zzi = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzj;
    }

    /* access modifiers changed from: private */
    public static zzcn<Long> zzb(zzct zzct, String str, long j) {
        return new zzcp(zzct, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzcn<Boolean> zzb(zzct zzct, String str, boolean z) {
        return new zzco(zzct, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static zzcn<Double> zzb(zzct zzct, String str, double d) {
        return new zzcr(zzct, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzcn<String> zzb(zzct zzct, String str, String str2) {
        return new zzcq(zzct, str, str2);
    }

    static final /* synthetic */ zzcw zzd() {
        new zzci();
        return zzci.zza(zzb);
    }

    /* synthetic */ zzcn(zzct zzct, String str, Object obj, zzcp zzcp) {
        this(zzct, str, obj);
    }
}
