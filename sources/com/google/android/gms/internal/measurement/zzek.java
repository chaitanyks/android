package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzek extends zzei {
    private final byte[] zzd;
    private final boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private zzek(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzk = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zza() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int zzv = zzv();
        this.zzj = zzv;
        if ((zzv >>> 3) != 0) {
            return zzv;
        }
        throw zzfm.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final void zza(int i) throws zzfm {
        if (this.zzj != i) {
            throw zzfm.zze();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final boolean zzb(int i) throws IOException {
        int zza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzfm.zzc();
            }
            while (i3 < 10) {
                if (zzaa() < 0) {
                    i3++;
                }
            }
            throw zzfm.zzc();
            return true;
        } else if (i2 == 1) {
            zzf(8);
            return true;
        } else if (i2 == 2) {
            zzf(zzv());
            return true;
        } else if (i2 == 3) {
            do {
                zza = zza();
                if (zza == 0) {
                    break;
                }
            } while (zzb(zza));
            zza(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzfm.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zzd() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zzg() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final boolean zzi() throws IOException {
        return zzw() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final String zzj() throws IOException {
        int zzv = zzv();
        if (zzv > 0 && zzv <= this.zzf - this.zzh) {
            String str = new String(this.zzd, this.zzh, zzv, zzfh.zza);
            this.zzh += zzv;
            return str;
        } else if (zzv == 0) {
            return "";
        } else {
            if (zzv < 0) {
                throw zzfm.zzb();
            }
            throw zzfm.zza();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final String zzk() throws IOException {
        int zzv = zzv();
        if (zzv > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzv <= i - i2) {
                String zzb = zzif.zzb(this.zzd, i2, zzv);
                this.zzh += zzv;
                return zzb;
            }
        }
        if (zzv == 0) {
            return "";
        }
        if (zzv <= 0) {
            throw zzfm.zzb();
        }
        throw zzfm.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final zzdw zzl() throws IOException {
        byte[] bArr;
        int zzv = zzv();
        if (zzv > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (zzv <= i - i2) {
                zzdw zza = zzdw.zza(this.zzd, i2, zzv);
                this.zzh += zzv;
                return zza;
            }
        }
        if (zzv == 0) {
            return zzdw.zza;
        }
        if (zzv > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (zzv <= i3 - i4) {
                int i5 = zzv + i4;
                this.zzh = i5;
                bArr = Arrays.copyOfRange(this.zzd, i4, i5);
                return zzdw.zza(bArr);
            }
        }
        if (zzv > 0) {
            throw zzfm.zza();
        } else if (zzv == 0) {
            bArr = zzfh.zzb;
            return zzdw.zza(bArr);
        } else {
            throw zzfm.zzb();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzm() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzn() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzo() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zzp() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzq() throws IOException {
        return zze(zzv());
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zzr() throws IOException {
        return zza(zzw());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    private final int zzv() throws IOException {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zzd;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
                return b;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ -128;
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                        i5 = i7;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ -2080896;
                        } else {
                            int i10 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i10 + 1;
                                if (bArr[i10] < 0) {
                                    i10 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i10 + 1;
                                        if (bArr[i10] < 0) {
                                            i10 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i10 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                            i5 = i10;
                        }
                    }
                }
                this.zzh = i5;
                return i;
            }
        }
        return (int) zzs();
    }

    private final long zzw() throws IOException {
        long j;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
                return (long) b;
            } else if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                int i5 = b ^ (bArr[i3] << 7);
                if (i5 < 0) {
                    j = (long) (i5 ^ -128);
                } else {
                    int i6 = i4 + 1;
                    int i7 = i5 ^ (bArr[i4] << 14);
                    if (i7 >= 0) {
                        i4 = i6;
                        j = (long) (i7 ^ 16256);
                    } else {
                        i4 = i6 + 1;
                        int i8 = i7 ^ (bArr[i6] << 21);
                        if (i8 < 0) {
                            j = (long) (i8 ^ -2080896);
                        } else {
                            long j2 = (long) i8;
                            int i9 = i4 + 1;
                            long j3 = j2 ^ (((long) bArr[i4]) << 28);
                            if (j3 >= 0) {
                                j = 266354560 ^ j3;
                                i4 = i9;
                            } else {
                                i4 = i9 + 1;
                                long j4 = j3 ^ (((long) bArr[i9]) << 35);
                                if (j4 < 0) {
                                    j = j4 ^ -34093383808L;
                                } else {
                                    int i10 = i4 + 1;
                                    long j5 = j4 ^ (((long) bArr[i4]) << 42);
                                    if (j5 >= 0) {
                                        j = 4363953127296L ^ j5;
                                        i4 = i10;
                                    } else {
                                        i4 = i10 + 1;
                                        long j6 = j5 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j = j6 ^ -558586000294016L;
                                        } else {
                                            int i11 = i4 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i11 + 1;
                                                if (((long) bArr[i11]) >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                i4 = i11;
                                                j = j7;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.zzh = i4;
                return j;
            }
        }
        return zzs();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzei
    public final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzaa = zzaa();
            j |= ((long) (zzaa & Byte.MAX_VALUE)) << i;
            if ((zzaa & 128) == 0) {
                return j;
            }
        }
        throw zzfm.zzc();
    }

    private final int zzx() throws IOException {
        int i = this.zzh;
        if (this.zzf - i >= 4) {
            byte[] bArr = this.zzd;
            this.zzh = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzfm.zza();
    }

    private final long zzy() throws IOException {
        int i = this.zzh;
        if (this.zzf - i >= 8) {
            byte[] bArr = this.zzd;
            this.zzh = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzfm.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzc(int i) throws zzfm {
        if (i >= 0) {
            int zzu = i + zzu();
            int i2 = this.zzk;
            if (zzu <= i2) {
                this.zzk = zzu;
                zzz();
                return i2;
            }
            throw zzfm.zza();
        }
        throw zzfm.zzb();
    }

    private final void zzz() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final void zzd(int i) {
        this.zzk = i;
        zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final boolean zzt() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzei
    public final int zzu() {
        return this.zzh - this.zzi;
    }

    private final byte zzaa() throws IOException {
        int i = this.zzh;
        if (i != this.zzf) {
            byte[] bArr = this.zzd;
            this.zzh = i + 1;
            return bArr[i];
        }
        throw zzfm.zza();
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzfm.zzb();
        }
        throw zzfm.zza();
    }
}
