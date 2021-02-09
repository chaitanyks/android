package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzfj implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfh zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzff zzf;

    public zzfj(zzff zzff, String str, URL url, byte[] bArr, Map<String, String> map, zzfh zzfh) {
        this.zzf = zzff;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfh);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfh;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d5 A[SYNTHETIC, Splitter:B:46:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0110 A[SYNTHETIC, Splitter:B:59:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x012a  */
    public final void run() {
        Map<String, List<String>> map;
        IOException iOException;
        int i;
        HttpURLConnection httpURLConnection;
        IOException e;
        Map<String, List<String>> map2;
        int i2;
        Throwable th;
        Throwable th2;
        int responseCode;
        IOException e2;
        this.zzf.zzc();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                if (this.zze != null) {
                    for (Map.Entry<String, String> entry : this.zze.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (this.zzb != null) {
                    byte[] zzc2 = this.zzf.zzg().zzc(this.zzb);
                    this.zzf.zzr().zzx().zza("Uploading data. size", Integer.valueOf(zzc2.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(zzc2.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(zzc2);
                        outputStream2.close();
                    } catch (IOException e3) {
                        map = null;
                        iOException = e3;
                        outputStream = outputStream2;
                    } catch (Throwable th3) {
                        map2 = null;
                        th = th3;
                        outputStream = outputStream2;
                        i2 = 0;
                        if (outputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i2, null, null, map2));
                        throw th;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
            } catch (IOException e4) {
                e = e4;
                map = null;
                iOException = e;
                i = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i, iOException, null, map));
            } catch (Throwable th4) {
                th2 = th4;
                map2 = null;
                th = th2;
                i2 = 0;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i2, null, null, map2));
                throw th;
            }
            try {
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                try {
                    zzff zzff = this.zzf;
                    byte[] bArr = zzff.zza(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, responseCode, null, bArr, headerFields));
                } catch (IOException e5) {
                    e2 = e5;
                    i = responseCode;
                    map = headerFields;
                    iOException = e2;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i, iOException, null, map));
                } catch (Throwable th5) {
                    th = th5;
                    i2 = responseCode;
                    map2 = headerFields;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                map = null;
                i = responseCode;
                iOException = e2;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i, iOException, null, map));
            } catch (Throwable th6) {
                map2 = null;
                th = th6;
                i2 = responseCode;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i2, null, null, map2));
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            httpURLConnection = null;
            map = null;
            iOException = e;
            i = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    this.zzf.zzr().zzf().zza("Error closing HTTP compressed POST connection output stream. appId", zzfb.zza(this.zzd), e8);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i, iOException, null, map));
        } catch (Throwable th7) {
            th2 = th7;
            httpURLConnection = null;
            map2 = null;
            th = th2;
            i2 = 0;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                    this.zzf.zzr().zzf().zza("Error closing HTTP compressed POST connection output stream. appId", zzfb.zza(this.zzd), e9);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzf.zzq().zza(new zzfk(this.zzd, this.zzc, i2, null, null, map2));
            throw th;
        }
    }
}
