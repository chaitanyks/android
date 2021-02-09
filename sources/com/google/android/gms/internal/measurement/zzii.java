package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzii extends zzih {
    zzii() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00be, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.zzih
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j = (long) i2;
            int i5 = (int) (((long) i3) - j);
            if (i5 >= 16) {
                long j2 = j;
                i4 = 0;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j3 = j2 + 1;
                    if (zzid.zza(bArr, j2) < 0) {
                        break;
                    }
                    i4++;
                    j2 = j3;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j4 = j + ((long) i4);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j5 = j4 + 1;
                    b = zzid.zza(bArr, j4);
                    if (b < 0) {
                        j4 = j5;
                        break;
                    }
                    i6--;
                    j4 = j5;
                }
                if (i6 != 0) {
                    int i7 = i6 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i7 >= 3) {
                                i6 = i7 - 3;
                                long j6 = j4 + 1;
                                byte zza = zzid.zza(bArr, j4);
                                if (zza > -65 || (((b << 28) + (zza + 112)) >> 30) != 0) {
                                    break;
                                }
                                long j7 = j6 + 1;
                                if (zzid.zza(bArr, j6) > -65) {
                                    break;
                                }
                                long j8 = j7 + 1;
                                if (zzid.zza(bArr, j7) > -65) {
                                    break;
                                }
                                j4 = j8;
                            } else {
                                return zza(bArr, b, j4, i7);
                            }
                        } else if (i7 >= 2) {
                            i6 = i7 - 2;
                            long j9 = j4 + 1;
                            byte zza2 = zzid.zza(bArr, j4);
                            if (zza2 > -65 || ((b == -32 && zza2 < -96) || (b == -19 && zza2 >= -96))) {
                                break;
                            }
                            j4 = j9 + 1;
                            if (zzid.zza(bArr, j9) > -65) {
                                break;
                            }
                        } else {
                            return zza(bArr, b, j4, i7);
                        }
                    } else if (i7 != 0) {
                        i6 = i7 - 1;
                        if (b < -62) {
                            break;
                        }
                        long j10 = j4 + 1;
                        if (zzid.zza(bArr, j4) > -65) {
                            break;
                        }
                        j4 = j10;
                    } else {
                        return b;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzih
    public final String zza(byte[] bArr, int i, int i2) throws zzfm {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte zza = zzid.zza(bArr, (long) i);
                if (!(zzie.zzd(zza))) {
                    break;
                }
                i++;
                zzie.zzb(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte zza2 = zzid.zza(bArr, (long) i);
                if (zzie.zzd(zza2)) {
                    int i7 = i5 + 1;
                    zzie.zzb(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzid.zza(bArr, (long) i6);
                        if (!(zzie.zzd(zza3))) {
                            break;
                        }
                        i6++;
                        zzie.zzb(zza3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (zzie.zze(zza2)) {
                    if (i6 < i3) {
                        int i8 = i6 + 1;
                        zzie.zzb(zza2, zzid.zza(bArr, (long) i6), cArr, i5);
                        i = i8;
                        i5++;
                    } else {
                        throw zzfm.zzh();
                    }
                } else if (zzie.zzf(zza2)) {
                    if (i6 < i3 - 1) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzie.zzb(zza2, zzid.zza(bArr, (long) i6), zzid.zza(bArr, (long) i9), cArr, i5);
                        i = i10;
                        i5++;
                    } else {
                        throw zzfm.zzh();
                    }
                } else if (i6 < i3 - 2) {
                    int i11 = i6 + 1;
                    int i12 = i11 + 1;
                    zzie.zzb(zza2, zzid.zza(bArr, (long) i6), zzid.zza(bArr, (long) i11), zzid.zza(bArr, (long) i12), cArr, i5);
                    i = i12 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzfm.zzh();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fd, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:37:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:37:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fd] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:37:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.measurement.zzih
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        int i3;
        char charAt;
        long j3 = (long) i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            char c = 128;
            long j5 = 1;
            if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                zzid.zza(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            } else if (i4 != length) {
                return (int) j3;
            } else {
                while (i4 < length) {
                    char charAt3 = charSequence.charAt(i4);
                    if (charAt3 < c && j3 < j4) {
                        long j6 = j3 + j5;
                        zzid.zza(bArr, j3, (byte) charAt3);
                        j2 = j5;
                        j = j6;
                    } else if (charAt3 < 2048 && j3 <= j4 - 2) {
                        long j7 = j3 + j5;
                        zzid.zza(bArr, j3, (byte) ((charAt3 >>> 6) | 960));
                        zzid.zza(bArr, j7, (byte) ((charAt3 & '?') | 128));
                        j = j7 + j5;
                        j2 = j5;
                    } else if ((charAt3 < 55296 || 57343 < charAt3) && j3 <= j4 - 3) {
                        long j8 = j3 + j5;
                        zzid.zza(bArr, j3, (byte) ((charAt3 >>> '\f') | 480));
                        long j9 = j8 + j5;
                        zzid.zza(bArr, j8, (byte) (((charAt3 >>> 6) & 63) | 128));
                        zzid.zza(bArr, j9, (byte) ((charAt3 & '?') | 128));
                        j = j9 + 1;
                        j2 = 1;
                    } else if (j3 <= j4 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j10 = j3 + 1;
                                zzid.zza(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                long j11 = j10 + 1;
                                zzid.zza(bArr, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j12 = j11 + 1;
                                zzid.zza(bArr, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                                j2 = 1;
                                j = j12 + 1;
                                zzid.zza(bArr, j12, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzij(i4 - 1, length);
                    } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j3);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    } else {
                        throw new zzij(i4, length);
                    }
                    i4++;
                    c = 128;
                    j3 = j;
                    j5 = j2;
                }
                return (int) j3;
            }
        }
        if (i4 != length) {
        }
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzif.zzb(i);
        }
        if (i2 == 1) {
            return zzif.zzb(i, zzid.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzif.zzb(i, zzid.zza(bArr, j), zzid.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
