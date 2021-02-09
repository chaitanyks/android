package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzgs<T> implements zzhf<T> {
    private final zzgm zza;
    private final zzhx<?, ?> zzb;
    private final boolean zzc;
    private final zzet<?> zzd;

    private zzgs(zzhx<?, ?> zzhx, zzet<?> zzet, zzgm zzgm) {
        this.zzb = zzhx;
        this.zzc = zzet.zza(zzgm);
        this.zzd = zzet;
        this.zza = zzgm;
    }

    static <T> zzgs<T> zza(zzhx<?, ?> zzhx, zzet<?> zzet, zzgm zzgm) {
        return new zzgs<>(zzhx, zzet, zzgm);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final T zza() {
        return (T) this.zza.zzbr().zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zzb(T t, T t2) {
        zzhh.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhh.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T t, zziq zziq) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzew zzew = (zzew) next.getKey();
            if (zzew.zzc() != zzir.MESSAGE || zzew.zzd() || zzew.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzft) {
                zziq.zza(zzew.zza(), (Object) ((zzft) next).zza().zzc());
            } else {
                zziq.zza(zzew.zza(), next.getValue());
            }
        }
        zzhx<?, ?> zzhx = this.zzb;
        zzhx.zzb(zzhx.zzb(t), zziq);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T t, byte[] bArr, int i, int i2, zzdr zzdr) throws IOException {
        T t2 = t;
        zzhw zzhw = t2.zzb;
        if (zzhw == zzhw.zza()) {
            zzhw = zzhw.zzb();
            t2.zzb = zzhw;
        }
        t.zza();
        zzfe.zzd zzd2 = null;
        while (i < i2) {
            int zza2 = zzds.zza(bArr, i, zzdr);
            int i3 = zzdr.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzdw zzdw = null;
                while (zza2 < i2) {
                    zza2 = zzds.zza(bArr, zza2, zzdr);
                    int i5 = zzdr.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzd2 != null) {
                                zzhb.zza();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza2 = zzds.zze(bArr, zza2, zzdr);
                                zzdw = (zzdw) zzdr.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza2 = zzds.zza(bArr, zza2, zzdr);
                        i4 = zzdr.zza;
                        zzd2 = (zzfe.zzd) this.zzd.zza(zzdr.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza2 = zzds.zza(i5, bArr, zza2, i2, zzdr);
                }
                if (zzdw != null) {
                    zzhw.zza((i4 << 3) | 2, zzdw);
                }
                i = zza2;
            } else if ((i3 & 7) == 2) {
                zzd2 = (zzfe.zzd) this.zzd.zza(zzdr.zzd, this.zza, i3 >>> 3);
                if (zzd2 == null) {
                    i = zzds.zza(i3, bArr, zza2, i2, zzhw, zzdr);
                } else {
                    zzhb.zza();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzds.zza(i3, bArr, zza2, i2, zzdr);
            }
        }
        if (i != i2) {
            throw zzfm.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T t, zzhc zzhc, zzer zzer) throws IOException {
        boolean z;
        zzhx<?, ?> zzhx = this.zzb;
        zzet<?> zzet = this.zzd;
        Object zzc2 = zzhx.zzc(t);
        zzeu<?> zzb2 = zzet.zzb(t);
        do {
            try {
                if (zzhc.zza() == Integer.MAX_VALUE) {
                    zzhx.zzb(t, zzc2);
                    return;
                }
                int zzb3 = zzhc.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdw zzdw = null;
                    while (zzhc.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzhc.zzb();
                        if (zzb4 == 16) {
                            i = zzhc.zzo();
                            obj = zzet.zza(zzer, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzet.zza(zzhc, obj, zzer, zzb2);
                            } else {
                                zzdw = zzhc.zzn();
                            }
                        } else if (!zzhc.zzc()) {
                            break;
                        }
                    }
                    if (zzhc.zzb() != 12) {
                        throw zzfm.zze();
                    } else if (zzdw != null) {
                        if (obj != null) {
                            zzet.zza(zzdw, obj, zzer, zzb2);
                        } else {
                            zzhx.zza(zzc2, i, zzdw);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzet.zza(zzer, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzet.zza(zzhc, zza2, zzer, zzb2);
                    } else {
                        z = zzhx.zza(zzc2, zzhc);
                        continue;
                    }
                } else {
                    z = zzhc.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzhx.zzb(t, zzc2);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final int zzb(T t) {
        zzhx<?, ?> zzhx = this.zzb;
        int zze = zzhx.zze(zzhx.zzb(t)) + 0;
        if (this.zzc) {
            return zze + this.zzd.zza((Object) t).zzg();
        }
        return zze;
    }
}
