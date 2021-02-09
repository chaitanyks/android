package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzeu<V> {
    private static final Object zzf = new Object();
    private final String zza;
    private final zzes<V> zzb;
    private final V zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzg;
    private volatile V zzh;

    private zzeu(String str, V v, V v2, zzes<V> zzes) {
        this.zze = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = str;
        this.zzc = v;
        this.zzd = v2;
        this.zzb = zzes;
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4 = com.google.android.gms.measurement.internal.zzap.zzcz.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r4.hasNext() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0034, code lost:
        r0 = (com.google.android.gms.measurement.internal.zzeu) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        if (com.google.android.gms.measurement.internal.zzw.zza() != false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r0.zzb == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0046, code lost:
        r1 = r0.zzb.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0060, code lost:
        throw new java.lang.IllegalStateException("Refreshing flag cache must be done on a worker thread.");
     */
    public final V zza(V v) {
        zzeu zzeu;
        V v2;
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzer.zza == null) {
            return this.zzc;
        }
        zzw zzw = zzer.zza;
        synchronized (zzf) {
            if (zzw.zza()) {
                return this.zzh == null ? this.zzc : this.zzh;
            }
        }
        zzes<V> zzes = this.zzb;
        if (zzes == null) {
            zzw zzw2 = zzer.zza;
            return this.zzc;
        }
        try {
            return zzes.zza();
        } catch (SecurityException e) {
            zzw zzw3 = zzer.zza;
            return this.zzc;
        } catch (IllegalStateException e2) {
            zzw zzw4 = zzer.zza;
            return this.zzc;
        }
        synchronized (zzf) {
            zzeu.zzh = v2;
        }
    }
}
