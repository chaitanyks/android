package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
abstract class zzhx<T, B> {
    zzhx() {
    }

    /* access modifiers changed from: package-private */
    public abstract B zza();

    /* access modifiers changed from: package-private */
    public abstract T zza(B b);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzdw zzdw);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zziq zziq) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzhc zzhc);

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zziq zziq) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* access modifiers changed from: package-private */
    public abstract int zzf(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    public final boolean zza(B b, zzhc zzhc) throws IOException {
        int zzb = zzhc.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza(b, i, zzhc.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b, i, zzhc.zzi());
            return true;
        } else if (i2 == 2) {
            zza((Object) b, i, zzhc.zzn());
            return true;
        } else if (i2 == 3) {
            B zza = zza();
            int i3 = 4 | (i << 3);
            while (zzhc.zza() != Integer.MAX_VALUE && zza((Object) zza, zzhc)) {
                while (zzhc.zza() != Integer.MAX_VALUE) {
                    while (zzhc.zza() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (i3 == zzhc.zzb()) {
                zza((Object) b, i, (Object) zza((Object) zza));
                return true;
            }
            throw zzfm.zze();
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zza((Object) b, i, zzhc.zzj());
                return true;
            }
            throw zzfm.zzf();
        }
    }
}
