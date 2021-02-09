package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzds {
    static int zza(byte[] bArr, int i, zzdr zzdr) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzdr);
        }
        zzdr.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdr zzdr) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdr.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdr.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdr.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdr.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdr.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdr zzdr) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzdr.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzdr.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdr zzdr) throws zzfm {
        int zza = zza(bArr, i, zzdr);
        int i2 = zzdr.zza;
        if (i2 < 0) {
            throw zzfm.zzb();
        } else if (i2 == 0) {
            zzdr.zzc = "";
            return zza;
        } else {
            zzdr.zzc = new String(bArr, zza, i2, zzfh.zza);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzdr zzdr) throws zzfm {
        int zza = zza(bArr, i, zzdr);
        int i2 = zzdr.zza;
        if (i2 < 0) {
            throw zzfm.zzb();
        } else if (i2 == 0) {
            zzdr.zzc = "";
            return zza;
        } else {
            zzdr.zzc = zzif.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzdr zzdr) throws zzfm {
        int zza = zza(bArr, i, zzdr);
        int i2 = zzdr.zza;
        if (i2 < 0) {
            throw zzfm.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzfm.zza();
        } else if (i2 == 0) {
            zzdr.zzc = zzdw.zza;
            return zza;
        } else {
            zzdr.zzc = zzdw.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zza(zzhf zzhf, byte[] bArr, int i, int i2, zzdr zzdr) throws IOException {
        byte b;
        int i3;
        int i4 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            i3 = zza(b2, bArr, i4, zzdr);
            b = zzdr.zza;
        } else {
            i3 = i4;
            b = b2;
        }
        if (b < 0 || b > i2 - i3) {
            throw zzfm.zza();
        }
        Object zza = zzhf.zza();
        int i5 = (b == 1 ? 1 : 0) + i3;
        zzhf.zza(zza, bArr, i3, i5, zzdr);
        zzhf.zzc(zza);
        zzdr.zzc = zza;
        return i5;
    }

    static int zza(zzhf zzhf, byte[] bArr, int i, int i2, int i3, zzdr zzdr) throws IOException {
        zzgq zzgq = (zzgq) zzhf;
        Object zza = zzgq.zza();
        int zza2 = zzgq.zza(zza, bArr, i, i2, i3, zzdr);
        zzgq.zzc(zza);
        zzdr.zzc = zza;
        return zza2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfn<?> zzfn, zzdr zzdr) {
        zzff zzff = (zzff) zzfn;
        int zza = zza(bArr, i2, zzdr);
        zzff.zzd(zzdr.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdr);
            if (i != zzdr.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzdr);
            zzff.zzd(zzdr.zza);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzfn<?> zzfn, zzdr zzdr) throws IOException {
        zzff zzff = (zzff) zzfn;
        int zza = zza(bArr, i, zzdr);
        int i2 = zzdr.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzdr);
            zzff.zzd(zzdr.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzfm.zza();
    }

    static int zza(zzhf<?> zzhf, int i, byte[] bArr, int i2, int i3, zzfn<?> zzfn, zzdr zzdr) throws IOException {
        int zza = zza(zzhf, bArr, i2, i3, zzdr);
        zzfn.add(zzdr.zzc);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdr);
            if (i != zzdr.zza) {
                break;
            }
            zza = zza(zzhf, bArr, zza2, i3, zzdr);
            zzfn.add(zzdr.zzc);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhw zzhw, zzdr zzdr) throws zzfm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzdr);
                zzhw.zza(i, Long.valueOf(zzdr.zzb));
                return zzb;
            } else if (i4 == 1) {
                zzhw.zza(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzdr);
                int i5 = zzdr.zza;
                if (i5 < 0) {
                    throw zzfm.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzhw.zza(i, zzdw.zza);
                    } else {
                        zzhw.zza(i, zzdw.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzfm.zza();
                }
            } else if (i4 == 3) {
                zzhw zzb2 = zzhw.zzb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzdr);
                    int i8 = zzdr.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zza(i8, bArr, zza2, i3, zzb2, zzdr);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzfm.zzg();
                }
                zzhw.zza(i, zzb2);
                return i2;
            } else if (i4 == 5) {
                zzhw.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzfm.zzd();
            }
        } else {
            throw zzfm.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdr zzdr) throws zzfm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzdr);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzdr) + zzdr.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzdr);
                    i6 = zzdr.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzdr);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzfm.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzfm.zzd();
            }
        } else {
            throw zzfm.zzd();
        }
    }
}
