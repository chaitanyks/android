package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzik implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzih zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzii zzf;

    public zzik(zzii zzii, String str, URL url, byte[] bArr, Map<String, String> map, zzih zzih) {
        this.zzf = zzii;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzih);
        this.zza = url;
        this.zzc = zzih;
        this.zzd = str;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    public final void run() {
        Map<String, List<String>> map;
        IOException e;
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map2;
        Throwable th;
        Map<String, List<String>> headerFields;
        this.zzf.zzc();
        int i = 0;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                if (this.zze != null) {
                    for (Map.Entry<String, String> entry : this.zze.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                i = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e2) {
                e = e2;
                map = null;
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map);
            } catch (Throwable th2) {
                th = th2;
                map2 = null;
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map2);
                throw th;
            }
            try {
                zzii zzii = this.zzf;
                byte[] bArr = zzii.zza(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, null, bArr, headerFields);
            } catch (IOException e3) {
                map = headerFields;
                e = e3;
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map);
            } catch (Throwable th3) {
                map2 = headerFields;
                th = th3;
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map2);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            map = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, e, null, map);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            map2 = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, null, null, map2);
            throw th;
        }
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzq().zza(new zzij(this, i, exc, bArr, map));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
