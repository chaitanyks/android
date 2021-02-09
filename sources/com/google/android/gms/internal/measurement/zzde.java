package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzde {
    private static final zzdh zza;
    private static final int zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
    static final class zza extends zzdh {
        zza() {
        }

        @Override // com.google.android.gms.internal.measurement.zzdh
        public final void zza(Throwable th, Throwable th2) {
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }

    private static Integer zza() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        zzdh zzdh;
        Integer num;
        Throwable th;
        int i = 1;
        try {
            num = zza();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzdh = new zzdk();
                        zza = zzdh;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzb = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    PrintStream printStream = System.err;
                    String name = zza.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzdh = new zza();
                    zza = zzdh;
                    if (num != null) {
                    }
                    zzb = i;
                }
            }
            if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                zzdh = new zzdi();
            } else {
                zzdh = new zza();
            }
        } catch (Throwable th3) {
            th = th3;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = zza.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            zzdh = new zza();
            zza = zzdh;
            if (num != null) {
            }
            zzb = i;
        }
        zza = zzdh;
        if (num != null) {
        }
        zzb = i;
    }
}
