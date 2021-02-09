package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzfe implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfb zzf;

    zzfe(zzfb zzfb, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzfb;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfo zzc2 = this.zzf.zzx.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzf()) {
                    zzfb zzfb = this.zzf;
                    zzfb.zzu();
                    zzfb.zza = 'C';
                } else {
                    zzfb zzfb2 = this.zzf;
                    zzfb2.zzu();
                    zzfb2.zza = 'c';
                }
            }
            if (this.zzf.zzb < 0) {
                zzfb zzfb3 = this.zzf;
                zzfb3.zzb = zzfb3.zzt().zze();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char c = this.zzf.zza;
            long j = this.zzf.zzb;
            String zza2 = zzfb.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
            sb.append("2");
            sb.append(charAt);
            sb.append(c);
            sb.append(j);
            sb.append(":");
            sb.append(zza2);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
