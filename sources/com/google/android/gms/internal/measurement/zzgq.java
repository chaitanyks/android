package com.google.android.gms.internal.measurement;

import android.util.EventLogTags;
import com.google.android.gms.internal.measurement.zzfe;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzgq<T> implements zzhf<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzid.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgu zzo;
    private final zzfw zzp;
    private final zzhx<?, ?> zzq;
    private final zzet<?> zzr;
    private final zzgj zzs;

    private zzgq(int[] iArr, Object[] objArr, int i, int i2, zzgm zzgm, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgu zzgu, zzfw zzfw, zzhx<?, ?> zzhx, zzet<?> zzet, zzgj zzgj) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgm instanceof zzfe;
        this.zzj = z;
        this.zzh = zzet != null && zzet.zza(zzgm);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgu;
        this.zzp = zzfw;
        this.zzq = zzhx;
        this.zzr = zzet;
        this.zzg = zzgm;
        this.zzs = zzgj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x037b  */
    static <T> zzgq<T> zza(Class<T> cls, zzgk zzgk, zzgu zzgu, zzfw zzfw, zzhx<?, ?> zzhx, zzet<?> zzet, zzgj zzgj) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        zzhd zzhd;
        int i11;
        Class<?> cls2;
        int i12;
        String str;
        int i13;
        int i14;
        int i15;
        int i16;
        Field field;
        int i17;
        char charAt;
        Field field2;
        Field field3;
        int i18;
        char charAt2;
        int i19;
        char charAt3;
        int i20;
        char charAt4;
        int i21;
        int i22;
        char charAt5;
        int i23;
        char charAt6;
        int i24;
        char charAt7;
        int i25;
        char charAt8;
        int i26;
        char charAt9;
        int i27;
        char charAt10;
        int i28;
        char charAt11;
        int i29;
        char charAt12;
        int i30;
        char charAt13;
        char charAt14;
        if (zzgk instanceof zzhd) {
            zzhd zzhd2 = (zzhd) zzgk;
            int i31 = 0;
            boolean z2 = zzhd2.zza() == zzfe.zzf.zzi;
            String zzd2 = zzhd2.zzd();
            int length = zzd2.length();
            int charAt15 = zzd2.charAt(0);
            if (charAt15 >= 55296) {
                int i32 = charAt15 & 8191;
                int i33 = 1;
                int i34 = 13;
                while (true) {
                    i = i33 + 1;
                    charAt14 = zzd2.charAt(i33);
                    if (charAt14 < 55296) {
                        break;
                    }
                    i32 |= (charAt14 & 8191) << i34;
                    i34 += 13;
                    i33 = i;
                }
                charAt15 = i32 | (charAt14 << i34);
            } else {
                i = 1;
            }
            int i35 = i + 1;
            int charAt16 = zzd2.charAt(i);
            if (charAt16 >= 55296) {
                int i36 = charAt16 & 8191;
                int i37 = 13;
                while (true) {
                    i30 = i35 + 1;
                    charAt13 = zzd2.charAt(i35);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i36 |= (charAt13 & 8191) << i37;
                    i37 += 13;
                    i35 = i30;
                }
                charAt16 = i36 | (charAt13 << i37);
                i35 = i30;
            }
            if (charAt16 == 0) {
                iArr = zza;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i38 = i35 + 1;
                int charAt17 = zzd2.charAt(i35);
                if (charAt17 >= 55296) {
                    int i39 = charAt17 & 8191;
                    int i40 = 13;
                    while (true) {
                        i29 = i38 + 1;
                        charAt12 = zzd2.charAt(i38);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i39 |= (charAt12 & 8191) << i40;
                        i40 += 13;
                        i38 = i29;
                    }
                    charAt17 = i39 | (charAt12 << i40);
                    i38 = i29;
                }
                int i41 = i38 + 1;
                int charAt18 = zzd2.charAt(i38);
                if (charAt18 >= 55296) {
                    int i42 = charAt18 & 8191;
                    int i43 = 13;
                    while (true) {
                        i28 = i41 + 1;
                        charAt11 = zzd2.charAt(i41);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i42 |= (charAt11 & 8191) << i43;
                        i43 += 13;
                        i41 = i28;
                    }
                    charAt18 = i42 | (charAt11 << i43);
                    i41 = i28;
                }
                int i44 = i41 + 1;
                i5 = zzd2.charAt(i41);
                if (i5 >= 55296) {
                    int i45 = i5 & 8191;
                    int i46 = 13;
                    while (true) {
                        i27 = i44 + 1;
                        charAt10 = zzd2.charAt(i44);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i45 |= (charAt10 & 8191) << i46;
                        i46 += 13;
                        i44 = i27;
                    }
                    i5 = i45 | (charAt10 << i46);
                    i44 = i27;
                }
                int i47 = i44 + 1;
                int charAt19 = zzd2.charAt(i44);
                if (charAt19 >= 55296) {
                    int i48 = charAt19 & 8191;
                    int i49 = 13;
                    while (true) {
                        i26 = i47 + 1;
                        charAt9 = zzd2.charAt(i47);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i48 |= (charAt9 & 8191) << i49;
                        i49 += 13;
                        i47 = i26;
                    }
                    charAt19 = i48 | (charAt9 << i49);
                    i47 = i26;
                }
                int i50 = i47 + 1;
                i3 = zzd2.charAt(i47);
                if (i3 >= 55296) {
                    int i51 = i3 & 8191;
                    int i52 = 13;
                    while (true) {
                        i25 = i50 + 1;
                        charAt8 = zzd2.charAt(i50);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i51 |= (charAt8 & 8191) << i52;
                        i52 += 13;
                        i50 = i25;
                    }
                    i3 = i51 | (charAt8 << i52);
                    i50 = i25;
                }
                int i53 = i50 + 1;
                int charAt20 = zzd2.charAt(i50);
                if (charAt20 >= 55296) {
                    int i54 = charAt20 & 8191;
                    int i55 = 13;
                    while (true) {
                        i24 = i53 + 1;
                        charAt7 = zzd2.charAt(i53);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i54 |= (charAt7 & 8191) << i55;
                        i55 += 13;
                        i53 = i24;
                    }
                    charAt20 = i54 | (charAt7 << i55);
                    i53 = i24;
                }
                int i56 = i53 + 1;
                int charAt21 = zzd2.charAt(i53);
                if (charAt21 >= 55296) {
                    int i57 = charAt21 & 8191;
                    int i58 = i56;
                    int i59 = 13;
                    while (true) {
                        i23 = i58 + 1;
                        charAt6 = zzd2.charAt(i58);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i57 |= (charAt6 & 8191) << i59;
                        i59 += 13;
                        i58 = i23;
                    }
                    charAt21 = i57 | (charAt6 << i59);
                    i21 = i23;
                } else {
                    i21 = i56;
                }
                int i60 = i21 + 1;
                int charAt22 = zzd2.charAt(i21);
                if (charAt22 >= 55296) {
                    int i61 = charAt22 & 8191;
                    int i62 = i60;
                    int i63 = 13;
                    while (true) {
                        i22 = i62 + 1;
                        charAt5 = zzd2.charAt(i62);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i61 |= (charAt5 & 8191) << i63;
                        i63 += 13;
                        i62 = i22;
                    }
                    charAt22 = i61 | (charAt5 << i63);
                    i60 = i22;
                }
                int i64 = (charAt17 << 1) + charAt18;
                i6 = charAt19;
                i4 = i64;
                i2 = charAt22;
                i31 = charAt17;
                i35 = i60;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                i7 = charAt20;
            }
            Unsafe unsafe = zzb;
            Object[] zze2 = zzhd2.zze();
            Class<?> cls3 = zzhd2.zzc().getClass();
            int[] iArr2 = new int[(i3 * 3)];
            Object[] objArr = new Object[(i3 << 1)];
            int i65 = i2 + i7;
            int i66 = i2;
            int i67 = i35;
            int i68 = i65;
            int i69 = 0;
            int i70 = 0;
            while (i67 < length) {
                int i71 = i67 + 1;
                int charAt23 = zzd2.charAt(i67);
                if (charAt23 >= 55296) {
                    int i72 = charAt23 & 8191;
                    int i73 = i71;
                    int i74 = 13;
                    while (true) {
                        i20 = i73 + 1;
                        charAt4 = zzd2.charAt(i73);
                        i8 = i2;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i72 |= (charAt4 & 8191) << i74;
                        i74 += 13;
                        i73 = i20;
                        i2 = i8;
                    }
                    charAt23 = i72 | (charAt4 << i74);
                    i9 = i20;
                } else {
                    i8 = i2;
                    i9 = i71;
                }
                int i75 = i9 + 1;
                int charAt24 = zzd2.charAt(i9);
                if (charAt24 >= 55296) {
                    int i76 = charAt24 & 8191;
                    int i77 = i75;
                    int i78 = 13;
                    while (true) {
                        i19 = i77 + 1;
                        charAt3 = zzd2.charAt(i77);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i76 |= (charAt3 & 8191) << i78;
                        i78 += 13;
                        i77 = i19;
                        z2 = z;
                    }
                    charAt24 = i76 | (charAt3 << i78);
                    i10 = i19;
                } else {
                    z = z2;
                    i10 = i75;
                }
                int i79 = charAt24 & 255;
                if ((charAt24 & 1024) != 0) {
                    iArr[i69] = i70;
                    i69++;
                }
                if (i79 >= 51) {
                    int i80 = i10 + 1;
                    int charAt25 = zzd2.charAt(i10);
                    char c = 55296;
                    if (charAt25 >= 55296) {
                        int i81 = charAt25 & 8191;
                        int i82 = 13;
                        while (true) {
                            i18 = i80 + 1;
                            charAt2 = zzd2.charAt(i80);
                            if (charAt2 < c) {
                                break;
                            }
                            i81 |= (charAt2 & 8191) << i82;
                            i82 += 13;
                            i80 = i18;
                            c = 55296;
                        }
                        charAt25 = i81 | (charAt2 << i82);
                        i80 = i18;
                    }
                    int i83 = i79 - 51;
                    if (i83 == 9 || i83 == 17) {
                        objArr[((i70 / 3) << 1) + 1] = zze2[i4];
                        i4++;
                    } else if (i83 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i70 / 3) << 1) + 1] = zze2[i4];
                        i4++;
                    }
                    int i84 = charAt25 << 1;
                    Object obj = zze2[i84];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zze2[i84] = field2;
                    }
                    zzhd = zzhd2;
                    i14 = (int) unsafe.objectFieldOffset(field2);
                    int i85 = i84 + 1;
                    Object obj2 = zze2[i85];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zze2[i85] = field3;
                    }
                    cls2 = cls3;
                    i11 = i4;
                    i10 = i80;
                    str = zzd2;
                    i12 = 0;
                    i13 = (int) unsafe.objectFieldOffset(field3);
                    i15 = i31;
                } else {
                    zzhd = zzhd2;
                    int i86 = i4 + 1;
                    Field zza2 = zza(cls3, (String) zze2[i4]);
                    if (i79 == 9) {
                        i16 = 1;
                    } else if (i79 == 17) {
                        i16 = 1;
                    } else if (i79 == 27 || i79 == 49) {
                        i16 = 1;
                        objArr[((i70 / 3) << 1) + 1] = zze2[i86];
                        i86++;
                        i14 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == i16 || i79 > 17) {
                            i11 = i86;
                            i15 = i31;
                            cls2 = cls3;
                            str = zzd2;
                            i13 = 0;
                            i12 = 0;
                        } else {
                            int i87 = i10 + 1;
                            str = zzd2;
                            int charAt26 = str.charAt(i10);
                            if (charAt26 >= 55296) {
                                int i88 = charAt26 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = str.charAt(i87);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i88 |= (charAt & 8191) << i89;
                                    i89 += 13;
                                    i87 = i17;
                                }
                                charAt26 = i88 | (charAt << i89);
                                i87 = i17;
                            }
                            int i90 = (i31 << 1) + (charAt26 / 32);
                            Object obj3 = zze2[i90];
                            i11 = i86;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zze2[i90] = field;
                            }
                            i15 = i31;
                            cls2 = cls3;
                            i13 = (int) unsafe.objectFieldOffset(field);
                            i12 = charAt26 % 32;
                            i10 = i87;
                        }
                        if (i79 >= 18 && i79 <= 49) {
                            iArr[i68] = i14;
                            i68++;
                        }
                    } else if (i79 == 12 || i79 == 30 || i79 == 44) {
                        if ((charAt15 & 1) == 1) {
                            objArr[((i70 / 3) << 1) + 1] = zze2[i86];
                            i86++;
                            i16 = 1;
                        } else {
                            i16 = 1;
                        }
                        i14 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == i16) {
                        }
                        i11 = i86;
                        i15 = i31;
                        cls2 = cls3;
                        str = zzd2;
                        i13 = 0;
                        i12 = 0;
                        iArr[i68] = i14;
                        i68++;
                    } else {
                        if (i79 == 50) {
                            int i91 = i66 + 1;
                            iArr[i66] = i70;
                            int i92 = (i70 / 3) << 1;
                            int i93 = i86 + 1;
                            objArr[i92] = zze2[i86];
                            if ((charAt24 & 2048) != 0) {
                                i86 = i93 + 1;
                                objArr[i92 + 1] = zze2[i93];
                                i66 = i91;
                                i16 = 1;
                            } else {
                                i86 = i93;
                                i16 = 1;
                                i66 = i91;
                            }
                        } else {
                            i16 = 1;
                        }
                        i14 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt15 & 1) == i16) {
                        }
                        i11 = i86;
                        i15 = i31;
                        cls2 = cls3;
                        str = zzd2;
                        i13 = 0;
                        i12 = 0;
                        iArr[i68] = i14;
                        i68++;
                    }
                    objArr[((i70 / 3) << i16) + i16] = zza2.getType();
                    i14 = (int) unsafe.objectFieldOffset(zza2);
                    if ((charAt15 & 1) == i16) {
                    }
                    i11 = i86;
                    i15 = i31;
                    cls2 = cls3;
                    str = zzd2;
                    i13 = 0;
                    i12 = 0;
                    iArr[i68] = i14;
                    i68++;
                }
                int i94 = i70 + 1;
                iArr2[i70] = charAt23;
                int i95 = i94 + 1;
                iArr2[i94] = i14 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (i79 << 20);
                i70 = i95 + 1;
                iArr2[i95] = (i12 << 20) | i13;
                i31 = i15;
                zzd2 = str;
                i67 = i10;
                cls3 = cls2;
                i6 = i6;
                length = length;
                i2 = i8;
                z2 = z;
                i5 = i5;
                i4 = i11;
                zzhd2 = zzhd;
            }
            return new zzgq<>(iArr2, objArr, i5, i6, zzhd2.zzc(), z2, false, iArr, i2, i65, zzgu, zzfw, zzhx, zzet, zzgj);
        }
        ((zzhq) zzgk).zza();
        int i96 = zzfe.zzf.zzi;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzd2 = zzd(i);
                long j = (long) (zzd2 & 1048575);
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzid.zze(t, j)) != Double.doubleToLongBits(zzid.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzid.zzd(t, j)) != Float.floatToIntBits(zzid.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzid.zzb(t, j) != zzid.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzid.zzb(t, j) != zzid.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzid.zzb(t, j) != zzid.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzid.zzc(t, j) != zzid.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzid.zzb(t, j) != zzid.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzid.zza(t, j) != zzid.zza(t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzid.zzb(t, j) != zzid.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j));
                        break;
                    case 50:
                        z = zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zze2 = (long) (zze(i) & 1048575);
                        if (zzid.zza(t, zze2) != zzid.zza(t2, zze2) || !zzhh.zza(zzid.zzf(t, j), zzid.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final int zza(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzd2 = zzd(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzd2);
            int i4 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzfh.zza(Double.doubleToLongBits(zzid.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzid.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzfh.zza(zzid.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzfh.zza(zzid.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzfh.zza(zzid.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzfh.zza(zzid.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzid.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zzid.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzid.zzf(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzfh.zza(zzid.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzid.zza(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzfh.zza(zzid.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zzid.zzf(t, j);
                    if (zzf3 != null) {
                        i4 = zzf3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzid.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzid.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(Double.doubleToLongBits(zzb(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(zzc(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zze(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zze(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zze(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zzf(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + ((String) zzid.zzf(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzid.zzf(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzid.zzf(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zze(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzd(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzfh.zza(zze(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzid.zzf(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzq.zzb(t).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzr.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (zza((Object) t2, i)) {
                            zzid.zza(t, j, zzid.zze(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzd(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((Object) t2, i)) {
                            zzid.zza(t, j, zzid.zzc(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((Object) t2, i)) {
                            zzid.zza(t, j, zzid.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (zza((Object) t2, i)) {
                            zzid.zza(t, j, zzid.zzf(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zza(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((Object) t2, i)) {
                            zzid.zza((Object) t, j, zzid.zzb(t2, j));
                            zzb((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzhh.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (zza(t2, i2, i)) {
                            zzid.zza(t, j, zzid.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (zza(t2, i2, i)) {
                            zzid.zza(t, j, zzid.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzhh.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzhh.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzf2 = zzid.zzf(t, zzd2);
            Object zzf3 = zzid.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzid.zza(t, zzd2, zzfh.zza(zzf2, zzf3));
                zzb((Object) t, i);
            } else if (zzf3 != null) {
                zzid.zza(t, zzd2, zzf3);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzid.zzf(t, j);
            Object zzf3 = zzid.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzid.zza(t, j, zzfh.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzid.zza(t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final int zzb(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int i4 = 267386880;
        int i5 = 1;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.zzc.length) {
                int zzd2 = zzd(i6);
                int i8 = (zzd2 & i4) >>> 20;
                int i9 = this.zzc[i6];
                long j2 = (long) (zzd2 & 1048575);
                if (i8 < zzez.DOUBLE_LIST_PACKED.zza() || i8 > zzez.SINT64_LIST_PACKED.zza()) {
                    i3 = 0;
                } else {
                    i3 = this.zzc[i6 + 2] & 1048575;
                }
                switch (i8) {
                    case 0:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzb(i9, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzd(i9, zzid.zzb(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zze(i9, zzid.zzb(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzf(i9, zzid.zza(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzi(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzb(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((Object) t, i6)) {
                            Object zzf2 = zzid.zzf(t, j2);
                            if (zzf2 instanceof zzdw) {
                                i7 += zzel.zzc(i9, (zzdw) zzf2);
                                break;
                            } else {
                                i7 += zzel.zzb(i9, (String) zzf2);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((Object) t, i6)) {
                            i7 += zzhh.zza(i9, zzid.zzf(t, j2), zza(i6));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzc(i9, (zzdw) zzid.zzf(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzg(i9, zzid.zza(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzk(i9, zzid.zza(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzj(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzh(i9, zzid.zza(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzf(i9, zzid.zzb(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((Object) t, i6)) {
                            i7 += zzel.zzc(i9, (zzgm) zzid.zzf(t, j2), zza(i6));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i7 += zzhh.zzi(i9, zza(t, j2), false);
                        break;
                    case 19:
                        i7 += zzhh.zzh(i9, zza(t, j2), false);
                        break;
                    case 20:
                        i7 += zzhh.zza(i9, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        i7 += zzhh.zzb(i9, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        i7 += zzhh.zze(i9, zza(t, j2), false);
                        break;
                    case 23:
                        i7 += zzhh.zzi(i9, zza(t, j2), false);
                        break;
                    case 24:
                        i7 += zzhh.zzh(i9, zza(t, j2), false);
                        break;
                    case 25:
                        i7 += zzhh.zzj(i9, zza(t, j2), false);
                        break;
                    case 26:
                        i7 += zzhh.zza(i9, zza(t, j2));
                        break;
                    case 27:
                        i7 += zzhh.zza(i9, zza(t, j2), zza(i6));
                        break;
                    case 28:
                        i7 += zzhh.zzb(i9, zza(t, j2));
                        break;
                    case 29:
                        i7 += zzhh.zzf(i9, zza(t, j2), false);
                        break;
                    case 30:
                        i7 += zzhh.zzd(i9, zza(t, j2), false);
                        break;
                    case 31:
                        i7 += zzhh.zzh(i9, zza(t, j2), false);
                        break;
                    case 32:
                        i7 += zzhh.zzi(i9, zza(t, j2), false);
                        break;
                    case 33:
                        i7 += zzhh.zzg(i9, zza(t, j2), false);
                        break;
                    case 34:
                        i7 += zzhh.zzc(i9, zza(t, j2), false);
                        break;
                    case 35:
                        int zzi2 = zzhh.zzi((List) unsafe.getObject(t, j2));
                        if (zzi2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzi2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzi2) + zzi2;
                            break;
                        }
                    case 36:
                        int zzh2 = zzhh.zzh((List) unsafe.getObject(t, j2));
                        if (zzh2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzh2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzh2) + zzh2;
                            break;
                        }
                    case 37:
                        int zza2 = zzhh.zza((List) unsafe.getObject(t, j2));
                        if (zza2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zza2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zza2) + zza2;
                            break;
                        }
                    case 38:
                        int zzb2 = zzhh.zzb((List) unsafe.getObject(t, j2));
                        if (zzb2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzb2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzb2) + zzb2;
                            break;
                        }
                    case 39:
                        int zze2 = zzhh.zze((List) unsafe.getObject(t, j2));
                        if (zze2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zze2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zze2) + zze2;
                            break;
                        }
                    case 40:
                        int zzi3 = zzhh.zzi((List) unsafe.getObject(t, j2));
                        if (zzi3 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzi3);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzi3) + zzi3;
                            break;
                        }
                    case 41:
                        int zzh3 = zzhh.zzh((List) unsafe.getObject(t, j2));
                        if (zzh3 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzh3);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzh3) + zzh3;
                            break;
                        }
                    case 42:
                        int zzj2 = zzhh.zzj((List) unsafe.getObject(t, j2));
                        if (zzj2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzj2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzj2) + zzj2;
                            break;
                        }
                    case 43:
                        int zzf3 = zzhh.zzf((List) unsafe.getObject(t, j2));
                        if (zzf3 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzf3);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzf3) + zzf3;
                            break;
                        }
                    case 44:
                        int zzd3 = zzhh.zzd((List) unsafe.getObject(t, j2));
                        if (zzd3 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzd3);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzd3) + zzd3;
                            break;
                        }
                    case 45:
                        int zzh4 = zzhh.zzh((List) unsafe.getObject(t, j2));
                        if (zzh4 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzh4);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzh4) + zzh4;
                            break;
                        }
                    case 46:
                        int zzi4 = zzhh.zzi((List) unsafe.getObject(t, j2));
                        if (zzi4 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzi4);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzi4) + zzi4;
                            break;
                        }
                    case 47:
                        int zzg2 = zzhh.zzg((List) unsafe.getObject(t, j2));
                        if (zzg2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzg2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzg2) + zzg2;
                            break;
                        }
                    case 48:
                        int zzc2 = zzhh.zzc((List) unsafe.getObject(t, j2));
                        if (zzc2 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i3, zzc2);
                            }
                            i7 += zzel.zze(i9) + zzel.zzg(zzc2) + zzc2;
                            break;
                        }
                    case 49:
                        i7 += zzhh.zzb(i9, (List<zzgm>) zza(t, j2), zza(i6));
                        break;
                    case 50:
                        i7 += this.zzs.zza(i9, zzid.zzf(t, j2), zzb(i6));
                        break;
                    case 51:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzb(i9, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzb(i9, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzd(i9, zze(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zze(i9, zze(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzf(i9, zzd(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzg(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzi(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzb(i9, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i9, i6)) {
                            Object zzf4 = zzid.zzf(t, j2);
                            if (zzf4 instanceof zzdw) {
                                i7 += zzel.zzc(i9, (zzdw) zzf4);
                                break;
                            } else {
                                i7 += zzel.zzb(i9, (String) zzf4);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i9, i6)) {
                            i7 += zzhh.zza(i9, zzid.zzf(t, j2), zza(i6));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzc(i9, (zzdw) zzid.zzf(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzg(i9, zzd(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzk(i9, zzd(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzj(i9, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzh(i9, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzh(i9, zzd(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzf(i9, zze(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i9, i6)) {
                            i7 += zzel.zzc(i9, (zzgm) zzid.zzf(t, j2), zza(i6));
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i4 = 267386880;
            }
            return i7 + zza((zzhx) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < this.zzc.length) {
            int zzd4 = zzd(i11);
            int[] iArr = this.zzc;
            int i14 = iArr[i11];
            int i15 = (zzd4 & 267386880) >>> 20;
            if (i15 <= 17) {
                int i16 = iArr[i11 + 2];
                int i17 = i16 & 1048575;
                i = i5 << (i16 >>> 20);
                if (i17 != i10) {
                    i13 = unsafe2.getInt(t, (long) i17);
                    i10 = i17;
                }
                i2 = i16;
            } else if (!this.zzk || i15 < zzez.DOUBLE_LIST_PACKED.zza() || i15 > zzez.SINT64_LIST_PACKED.zza()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzc[i11 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzd4 & 1048575);
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzb(i14, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzb(i14, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzd(i14, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i12 += zzel.zze(i14, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzf(i14, unsafe2.getInt(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i) != 0) {
                        j = 0;
                        i12 += zzel.zzg(i14, 0L);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzi(i14, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzb(i14, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i13 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzdw) {
                            i12 += zzel.zzc(i14, (zzdw) object);
                            j = 0;
                            break;
                        } else {
                            i12 += zzel.zzb(i14, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i13 & i) != 0) {
                        i12 += zzhh.zza(i14, unsafe2.getObject(t, j3), zza(i11));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzc(i14, (zzdw) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzg(i14, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzk(i14, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzj(i14, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzh(i14, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzh(i14, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzf(i14, unsafe2.getLong(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i13 & i) != 0) {
                        i12 += zzel.zzc(i14, (zzgm) unsafe2.getObject(t, j3), zza(i11));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i12 += zzhh.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 19:
                    i12 += zzhh.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 20:
                    i12 += zzhh.zza(i14, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    j = 0;
                    break;
                case 21:
                    i12 += zzhh.zzb(i14, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    j = 0;
                    break;
                case 22:
                    i12 += zzhh.zze(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 23:
                    i12 += zzhh.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 24:
                    i12 += zzhh.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 25:
                    i12 += zzhh.zzj(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 26:
                    i12 += zzhh.zza(i14, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 27:
                    i12 += zzhh.zza(i14, (List<?>) ((List) unsafe2.getObject(t, j3)), zza(i11));
                    j = 0;
                    break;
                case 28:
                    i12 += zzhh.zzb(i14, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 29:
                    i12 += zzhh.zzf(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 30:
                    i12 += zzhh.zzd(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 31:
                    i12 += zzhh.zzh(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 32:
                    i12 += zzhh.zzi(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 33:
                    i12 += zzhh.zzg(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 34:
                    i12 += zzhh.zzc(i14, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zzhh.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi5 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzi5);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzi5) + zzi5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zzhh.zzh((List) unsafe2.getObject(t, j3));
                    if (zzh5 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzh5);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzh5) + zzh5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zzhh.zza((List) unsafe2.getObject(t, j3));
                    if (zza3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zza3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zza3) + zza3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zzhh.zzb((List) unsafe2.getObject(t, j3));
                    if (zzb3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzb3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzb3) + zzb3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zzhh.zze((List) unsafe2.getObject(t, j3));
                    if (zze3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zze3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zze3) + zze3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zzhh.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi6 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzi6);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzi6) + zzi6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zzhh.zzh((List) unsafe2.getObject(t, j3));
                    if (zzh6 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzh6);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzh6) + zzh6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int zzj3 = zzhh.zzj((List) unsafe2.getObject(t, j3));
                    if (zzj3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzj3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzj3) + zzj3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zzhh.zzf((List) unsafe2.getObject(t, j3));
                    if (zzf5 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzf5);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzf5) + zzf5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int zzd5 = zzhh.zzd((List) unsafe2.getObject(t, j3));
                    if (zzd5 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzd5);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzd5) + zzd5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zzhh.zzh((List) unsafe2.getObject(t, j3));
                    if (zzh7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzh7);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzh7) + zzh7;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int zzi7 = zzhh.zzi((List) unsafe2.getObject(t, j3));
                    if (zzi7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzi7);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzi7) + zzi7;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zzhh.zzg((List) unsafe2.getObject(t, j3));
                    if (zzg3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzg3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzg3) + zzg3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc3 = zzhh.zzc((List) unsafe2.getObject(t, j3));
                    if (zzc3 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, zzc3);
                        }
                        i12 += zzel.zze(i14) + zzel.zzg(zzc3) + zzc3;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i12 += zzhh.zzb(i14, (List) unsafe2.getObject(t, j3), zza(i11));
                    j = 0;
                    break;
                case 50:
                    i12 += this.zzs.zza(i14, unsafe2.getObject(t, j3), zzb(i11));
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzb(i14, 0.0d);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzb(i14, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzd(i14, zze(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zze(i14, zze(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzf(i14, zzd(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzg(i14, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzi(i14, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzb(i14, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (zza(t, i14, i11)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzdw) {
                            i12 += zzel.zzc(i14, (zzdw) object2);
                            j = 0;
                            break;
                        } else {
                            i12 += zzel.zzb(i14, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (zza(t, i14, i11)) {
                        i12 += zzhh.zza(i14, unsafe2.getObject(t, j3), zza(i11));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzc(i14, (zzdw) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzg(i14, zzd(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzk(i14, zzd(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzj(i14, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzh(i14, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzh(i14, zzd(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzf(i14, zze(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (zza(t, i14, i11)) {
                        i12 += zzel.zzc(i14, (zzgm) unsafe2.getObject(t, j3), zza(i11));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
            i11 += 3;
            i5 = 1;
        }
        int i18 = 0;
        int zza4 = i12 + zza((zzhx) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza4;
        }
        zzeu<?> zza5 = this.zzr.zza((Object) t);
        for (int i19 = 0; i19 < zza5.zza.zzc(); i19++) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i19);
            i18 += zzeu.zza((zzew<?>) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry<T, Object> entry : zza5.zza.zzd()) {
            i18 += zzeu.zza((zzew<?>) entry.getKey(), entry.getValue());
        }
        return zza4 + i18;
    }

    private static <UT, UB> int zza(zzhx<UT, UB> zzhx, T t) {
        return zzhx.zzf(zzhx.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzid.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5e  */
    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T t, zziq zziq) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        if (zziq.zza() == zzfe.zzf.zzk) {
            zza(this.zzq, t, zziq);
            if (this.zzh) {
                zzeu<?> zza2 = this.zzr.zza((Object) t);
                if (!zza2.zza.isEmpty()) {
                    it2 = zza2.zze();
                    entry2 = it2.next();
                    for (length2 = this.zzc.length - 3; length2 >= 0; length2 -= 3) {
                        int zzd2 = zzd(length2);
                        int i2 = this.zzc[length2];
                        while (entry2 != null && this.zzr.zza(entry2) > i2) {
                            this.zzr.zza(zziq, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzd2 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, length2)) {
                                    zziq.zzc(i2, zzid.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, length2)) {
                                    zziq.zzc(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, length2)) {
                                    zziq.zzd(i2, zzid.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, length2)) {
                                    zziq.zzd(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, length2)) {
                                    zza(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zziq);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, (zzdw) zzid.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, length2)) {
                                    zziq.zze(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, length2)) {
                                    zziq.zzb(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, length2)) {
                                    zziq.zza(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, length2)) {
                                    zziq.zzb(i2, zzid.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, length2)) {
                                    zziq.zzf(i2, zzid.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, length2)) {
                                    zziq.zze(i2, zzid.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, length2)) {
                                    zziq.zzb(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzhh.zza(this.zzc[length2], (List<Double>) ((List) zzid.zzf(t, (long) (zzd2 & 1048575))), zziq, false);
                                break;
                            case 19:
                                zzhh.zzb(this.zzc[length2], (List<Float>) ((List) zzid.zzf(t, (long) (zzd2 & 1048575))), zziq, false);
                                break;
                            case 20:
                                zzhh.zzc(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 21:
                                zzhh.zzd(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 22:
                                zzhh.zzh(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 23:
                                zzhh.zzf(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 24:
                                zzhh.zzk(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 25:
                                zzhh.zzn(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 26:
                                zzhh.zza(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq);
                                break;
                            case 27:
                                zzhh.zza(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, zza(length2));
                                break;
                            case 28:
                                zzhh.zzb(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq);
                                break;
                            case 29:
                                zzhh.zzi(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 30:
                                zzhh.zzm(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 31:
                                zzhh.zzl(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 32:
                                zzhh.zzg(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 33:
                                zzhh.zzj(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 34:
                                zzhh.zze(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, false);
                                break;
                            case 35:
                                zzhh.zza(this.zzc[length2], (List<Double>) ((List) zzid.zzf(t, (long) (zzd2 & 1048575))), zziq, true);
                                break;
                            case 36:
                                zzhh.zzb(this.zzc[length2], (List<Float>) ((List) zzid.zzf(t, (long) (zzd2 & 1048575))), zziq, true);
                                break;
                            case 37:
                                zzhh.zzc(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 38:
                                zzhh.zzd(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 39:
                                zzhh.zzh(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 40:
                                zzhh.zzf(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 41:
                                zzhh.zzk(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 42:
                                zzhh.zzn(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 43:
                                zzhh.zzi(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 44:
                                zzhh.zzm(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 45:
                                zzhh.zzl(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 46:
                                zzhh.zzg(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 47:
                                zzhh.zzj(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 48:
                                zzhh.zze(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, true);
                                break;
                            case 49:
                                zzhh.zzb(this.zzc[length2], (List) zzid.zzf(t, (long) (zzd2 & 1048575)), zziq, zza(length2));
                                break;
                            case 50:
                                zza(zziq, i2, zzid.zzf(t, (long) (zzd2 & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i2, length2)) {
                                    zziq.zzc(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i2, length2)) {
                                    zziq.zzc(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i2, length2)) {
                                    zziq.zzd(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i2, length2)) {
                                    zziq.zzd(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i2, length2)) {
                                    zza(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zziq);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, (zzdw) zzid.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i2, length2)) {
                                    zziq.zze(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i2, length2)) {
                                    zziq.zzb(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i2, length2)) {
                                    zziq.zza(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i2, length2)) {
                                    zziq.zzb(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i2, length2)) {
                                    zziq.zzf(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i2, length2)) {
                                    zziq.zze(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i2, length2)) {
                                    zziq.zzb(i2, zzid.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzr.zza(zziq, entry2);
                        entry2 = it2.hasNext() ? it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry2 = null;
            while (length2 >= 0) {
            }
            while (entry2 != null) {
            }
        } else if (this.zzj) {
            if (this.zzh) {
                zzeu<?> zza3 = this.zzr.zza((Object) t);
                if (!zza3.zza.isEmpty()) {
                    it = zza3.zzd();
                    entry = it.next();
                    length = this.zzc.length;
                    for (i = 0; i < length; i += 3) {
                        int zzd3 = zzd(i);
                        int i3 = this.zzc[i];
                        while (entry != null && this.zzr.zza(entry) <= i3) {
                            this.zzr.zza(zziq, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzd3 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, i)) {
                                    zziq.zzc(i3, zzid.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, i)) {
                                    zziq.zzc(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, i)) {
                                    zziq.zzd(i3, zzid.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, i)) {
                                    zziq.zzd(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, i)) {
                                    zza(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zziq);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, (zzdw) zzid.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, i)) {
                                    zziq.zze(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, i)) {
                                    zziq.zzb(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, i)) {
                                    zziq.zza(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, i)) {
                                    zziq.zzb(i3, zzid.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, i)) {
                                    zziq.zzf(i3, zzid.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, i)) {
                                    zziq.zze(i3, zzid.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, i)) {
                                    zziq.zzb(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzhh.zza(this.zzc[i], (List<Double>) ((List) zzid.zzf(t, (long) (zzd3 & 1048575))), zziq, false);
                                break;
                            case 19:
                                zzhh.zzb(this.zzc[i], (List<Float>) ((List) zzid.zzf(t, (long) (zzd3 & 1048575))), zziq, false);
                                break;
                            case 20:
                                zzhh.zzc(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 21:
                                zzhh.zzd(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 22:
                                zzhh.zzh(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 23:
                                zzhh.zzf(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 24:
                                zzhh.zzk(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 25:
                                zzhh.zzn(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 26:
                                zzhh.zza(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq);
                                break;
                            case 27:
                                zzhh.zza(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, zza(i));
                                break;
                            case 28:
                                zzhh.zzb(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq);
                                break;
                            case 29:
                                zzhh.zzi(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 30:
                                zzhh.zzm(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 31:
                                zzhh.zzl(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 32:
                                zzhh.zzg(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 33:
                                zzhh.zzj(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 34:
                                zzhh.zze(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, false);
                                break;
                            case 35:
                                zzhh.zza(this.zzc[i], (List<Double>) ((List) zzid.zzf(t, (long) (zzd3 & 1048575))), zziq, true);
                                break;
                            case 36:
                                zzhh.zzb(this.zzc[i], (List<Float>) ((List) zzid.zzf(t, (long) (zzd3 & 1048575))), zziq, true);
                                break;
                            case 37:
                                zzhh.zzc(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 38:
                                zzhh.zzd(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 39:
                                zzhh.zzh(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 40:
                                zzhh.zzf(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 41:
                                zzhh.zzk(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 42:
                                zzhh.zzn(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 43:
                                zzhh.zzi(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 44:
                                zzhh.zzm(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 45:
                                zzhh.zzl(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 46:
                                zzhh.zzg(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 47:
                                zzhh.zzj(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 48:
                                zzhh.zze(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, true);
                                break;
                            case 49:
                                zzhh.zzb(this.zzc[i], (List) zzid.zzf(t, (long) (zzd3 & 1048575)), zziq, zza(i));
                                break;
                            case 50:
                                zza(zziq, i3, zzid.zzf(t, (long) (zzd3 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i3, i)) {
                                    zziq.zzc(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i3, i)) {
                                    zziq.zzc(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i3, i)) {
                                    zziq.zzd(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i3, i)) {
                                    zziq.zzd(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i3, i)) {
                                    zza(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zziq);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, (zzdw) zzid.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i3, i)) {
                                    zziq.zze(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i3, i)) {
                                    zziq.zzb(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i3, i)) {
                                    zziq.zza(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i3, i)) {
                                    zziq.zzb(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i3, i)) {
                                    zziq.zzf(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i3, i)) {
                                    zziq.zze(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i3, i)) {
                                    zziq.zzb(i3, zzid.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzr.zza(zziq, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzq, t, zziq);
                }
            }
            it = null;
            entry = null;
            length = this.zzc.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzq, t, zziq);
        } else {
            zzb((Object) t, zziq);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    private final void zzb(T t, zziq zziq) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        int i3;
        int i4;
        if (this.zzh) {
            zzeu<?> zza2 = this.zzr.zza((Object) t);
            if (!zza2.zza.isEmpty()) {
                it = zza2.zzd();
                entry = it.next();
                int i5 = -1;
                length = this.zzc.length;
                Unsafe unsafe = zzb;
                i = 0;
                int i6 = 0;
                while (i < length) {
                    int zzd2 = zzd(i);
                    int[] iArr = this.zzc;
                    int i7 = iArr[i];
                    int i8 = (267386880 & zzd2) >>> 20;
                    if (this.zzj || i8 > 17) {
                        i2 = i;
                        i3 = 0;
                    } else {
                        int i9 = iArr[i + 2];
                        int i10 = i9 & 1048575;
                        if (i10 != i5) {
                            i2 = i;
                            i6 = unsafe.getInt(t, (long) i10);
                            i5 = i10;
                        } else {
                            i2 = i;
                        }
                        i3 = 1 << (i9 >>> 20);
                    }
                    while (entry != null && this.zzr.zza(entry) <= i7) {
                        this.zzr.zza(zziq, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzd2 & 1048575);
                    switch (i8) {
                        case 0:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, zzid.zze(t, j));
                                break;
                            }
                        case 1:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, zzid.zzd(t, j));
                                break;
                            }
                        case 2:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, unsafe.getLong(t, j));
                                break;
                            }
                        case 3:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzc(i7, unsafe.getLong(t, j));
                                break;
                            }
                        case 4:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzc(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 5:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzd(i7, unsafe.getLong(t, j));
                                break;
                            }
                        case 6:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzd(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 7:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, zzid.zzc(t, j));
                                break;
                            }
                        case 8:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zza(i7, unsafe.getObject(t, j), zziq);
                                break;
                            }
                        case 9:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, unsafe.getObject(t, j), zza(i4));
                                break;
                            }
                        case 10:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, (zzdw) unsafe.getObject(t, j));
                                break;
                            }
                        case 11:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zze(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 12:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzb(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 13:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zza(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 14:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzb(i7, unsafe.getLong(t, j));
                                break;
                            }
                        case 15:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzf(i7, unsafe.getInt(t, j));
                                break;
                            }
                        case 16:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zze(i7, unsafe.getLong(t, j));
                                break;
                            }
                        case 17:
                            i4 = i2;
                            if ((i3 & i6) == 0) {
                                break;
                            } else {
                                zziq.zzb(i7, unsafe.getObject(t, j), zza(i4));
                                break;
                            }
                        case 18:
                            i4 = i2;
                            zzhh.zza(this.zzc[i4], (List<Double>) ((List) unsafe.getObject(t, j)), zziq, false);
                            break;
                        case 19:
                            i4 = i2;
                            zzhh.zzb(this.zzc[i4], (List<Float>) ((List) unsafe.getObject(t, j)), zziq, false);
                            break;
                        case 20:
                            i4 = i2;
                            zzhh.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 21:
                            i4 = i2;
                            zzhh.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 22:
                            i4 = i2;
                            zzhh.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 23:
                            i4 = i2;
                            zzhh.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 24:
                            i4 = i2;
                            zzhh.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 25:
                            i4 = i2;
                            zzhh.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 26:
                            i4 = i2;
                            zzhh.zza(this.zzc[i4], (List) unsafe.getObject(t, j), zziq);
                            break;
                        case 27:
                            i4 = i2;
                            zzhh.zza(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, zza(i4));
                            break;
                        case 28:
                            i4 = i2;
                            zzhh.zzb(this.zzc[i4], (List) unsafe.getObject(t, j), zziq);
                            break;
                        case 29:
                            i4 = i2;
                            zzhh.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 30:
                            i4 = i2;
                            zzhh.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 31:
                            i4 = i2;
                            zzhh.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 32:
                            i4 = i2;
                            zzhh.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 33:
                            i4 = i2;
                            zzhh.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 34:
                            i4 = i2;
                            zzhh.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, false);
                            break;
                        case 35:
                            i4 = i2;
                            zzhh.zza(this.zzc[i4], (List<Double>) ((List) unsafe.getObject(t, j)), zziq, true);
                            break;
                        case 36:
                            i4 = i2;
                            zzhh.zzb(this.zzc[i4], (List<Float>) ((List) unsafe.getObject(t, j)), zziq, true);
                            break;
                        case 37:
                            i4 = i2;
                            zzhh.zzc(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 38:
                            i4 = i2;
                            zzhh.zzd(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 39:
                            i4 = i2;
                            zzhh.zzh(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 40:
                            i4 = i2;
                            zzhh.zzf(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 41:
                            i4 = i2;
                            zzhh.zzk(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 42:
                            i4 = i2;
                            zzhh.zzn(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 43:
                            i4 = i2;
                            zzhh.zzi(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 44:
                            i4 = i2;
                            zzhh.zzm(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 45:
                            i4 = i2;
                            zzhh.zzl(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 46:
                            i4 = i2;
                            zzhh.zzg(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 47:
                            i4 = i2;
                            zzhh.zzj(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 48:
                            i4 = i2;
                            zzhh.zze(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, true);
                            break;
                        case 49:
                            i4 = i2;
                            zzhh.zzb(this.zzc[i4], (List) unsafe.getObject(t, j), zziq, zza(i4));
                            break;
                        case 50:
                            i4 = i2;
                            zza(zziq, i7, unsafe.getObject(t, j), i4);
                            break;
                        case 51:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, zzb(t, j));
                                break;
                            }
                        case 52:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, zzc(t, j));
                                break;
                            }
                        case 53:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, zze(t, j));
                                break;
                            }
                        case 54:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzc(i7, zze(t, j));
                                break;
                            }
                        case 55:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzc(i7, zzd(t, j));
                                break;
                            }
                        case 56:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzd(i7, zze(t, j));
                                break;
                            }
                        case 57:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzd(i7, zzd(t, j));
                                break;
                            }
                        case 58:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, zzf(t, j));
                                break;
                            }
                        case 59:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zza(i7, unsafe.getObject(t, j), zziq);
                                break;
                            }
                        case 60:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, unsafe.getObject(t, j), zza(i4));
                                break;
                            }
                        case 61:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, (zzdw) unsafe.getObject(t, j));
                                break;
                            }
                        case 62:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zze(i7, zzd(t, j));
                                break;
                            }
                        case 63:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzb(i7, zzd(t, j));
                                break;
                            }
                        case 64:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zza(i7, zzd(t, j));
                                break;
                            }
                        case 65:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzb(i7, zze(t, j));
                                break;
                            }
                        case 66:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzf(i7, zzd(t, j));
                                break;
                            }
                        case 67:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zze(i7, zze(t, j));
                                break;
                            }
                        case 68:
                            i4 = i2;
                            if (!zza(t, i7, i4)) {
                                break;
                            } else {
                                zziq.zzb(i7, unsafe.getObject(t, j), zza(i4));
                                break;
                            }
                        default:
                            i4 = i2;
                            break;
                    }
                    i = i4 + 3;
                }
                while (entry != null) {
                    this.zzr.zza(zziq, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzq, t, zziq);
            }
        }
        it = null;
        entry = null;
        int i52 = -1;
        length = this.zzc.length;
        Unsafe unsafe2 = zzb;
        i = 0;
        int i62 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzq, t, zziq);
    }

    private final <K, V> void zza(zziq zziq, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zziq.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzhx<UT, UB> zzhx, T t, zziq zziq) throws IOException {
        zzhx.zza(zzhx.zzb(t), zziq);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzhc r14, com.google.android.gms.internal.measurement.zzer r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1716
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgq.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhc, com.google.android.gms.internal.measurement.zzer):void");
    }

    private static zzhw zze(Object obj) {
        zzfe zzfe = (zzfe) obj;
        zzhw zzhw = zzfe.zzb;
        if (zzhw != zzhw.zza()) {
            return zzhw;
        }
        zzhw zzb2 = zzhw.zzb();
        zzfe.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzik zzik, Class<?> cls, zzdr zzdr) throws IOException {
        switch (zzgt.zza[zzik.ordinal()]) {
            case 1:
                int zzb2 = zzds.zzb(bArr, i, zzdr);
                zzdr.zzc = Boolean.valueOf(zzdr.zzb != 0);
                return zzb2;
            case 2:
                return zzds.zze(bArr, i, zzdr);
            case 3:
                zzdr.zzc = Double.valueOf(zzds.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzdr.zzc = Integer.valueOf(zzds.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzdr.zzc = Long.valueOf(zzds.zzb(bArr, i));
                return i + 8;
            case 8:
                zzdr.zzc = Float.valueOf(zzds.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzds.zza(bArr, i, zzdr);
                zzdr.zzc = Integer.valueOf(zzdr.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzds.zzb(bArr, i, zzdr);
                zzdr.zzc = Long.valueOf(zzdr.zzb);
                return zzb3;
            case 14:
                return zzds.zza(zzhb.zza().zza((Class) cls), bArr, i, i2, zzdr);
            case 15:
                int zza3 = zzds.zza(bArr, i, zzdr);
                zzdr.zzc = Integer.valueOf(zzei.zze(zzdr.zza));
                return zza3;
            case 16:
                int zzb4 = zzds.zzb(bArr, i, zzdr);
                zzdr.zzc = Long.valueOf(zzei.zza(zzdr.zzb));
                return zzb4;
            case 17:
                return zzds.zzd(bArr, i, zzdr);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzdr zzdr) throws IOException {
        int i8;
        zzfn zzfn = (zzfn) zzb.getObject(t, j2);
        if (!zzfn.zza()) {
            int size = zzfn.size();
            zzfn = zzfn.zza(size == 0 ? 10 : size << 1);
            zzb.putObject(t, j2, zzfn);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzeq zzeq = (zzeq) zzfn;
                    int zza2 = zzds.zza(bArr, i, zzdr);
                    int i9 = zzdr.zza + zza2;
                    while (zza2 < i9) {
                        zzeq.zza(zzds.zzc(bArr, zza2));
                        zza2 += 8;
                    }
                    if (zza2 == i9) {
                        return zza2;
                    }
                    throw zzfm.zza();
                } else if (i5 == 1) {
                    zzeq zzeq2 = (zzeq) zzfn;
                    zzeq2.zza(zzds.zzc(bArr, i));
                    int i10 = i + 8;
                    while (i10 < i2) {
                        int zza3 = zzds.zza(bArr, i10, zzdr);
                        if (i3 != zzdr.zza) {
                            return i10;
                        }
                        zzeq2.zza(zzds.zzc(bArr, zza3));
                        i10 = zza3 + 8;
                    }
                    return i10;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzfa zzfa = (zzfa) zzfn;
                    int zza4 = zzds.zza(bArr, i, zzdr);
                    int i11 = zzdr.zza + zza4;
                    while (zza4 < i11) {
                        zzfa.zza(zzds.zzd(bArr, zza4));
                        zza4 += 4;
                    }
                    if (zza4 == i11) {
                        return zza4;
                    }
                    throw zzfm.zza();
                } else if (i5 == 5) {
                    zzfa zzfa2 = (zzfa) zzfn;
                    zzfa2.zza(zzds.zzd(bArr, i));
                    int i12 = i + 4;
                    while (i12 < i2) {
                        int zza5 = zzds.zza(bArr, i12, zzdr);
                        if (i3 != zzdr.zza) {
                            return i12;
                        }
                        zzfa2.zza(zzds.zzd(bArr, zza5));
                        i12 = zza5 + 4;
                    }
                    return i12;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzga zzga = (zzga) zzfn;
                    int zza6 = zzds.zza(bArr, i, zzdr);
                    int i13 = zzdr.zza + zza6;
                    while (zza6 < i13) {
                        zza6 = zzds.zzb(bArr, zza6, zzdr);
                        zzga.zza(zzdr.zzb);
                    }
                    if (zza6 == i13) {
                        return zza6;
                    }
                    throw zzfm.zza();
                } else if (i5 == 0) {
                    zzga zzga2 = (zzga) zzfn;
                    int zzb2 = zzds.zzb(bArr, i, zzdr);
                    zzga2.zza(zzdr.zzb);
                    while (zzb2 < i2) {
                        int zza7 = zzds.zza(bArr, zzb2, zzdr);
                        if (i3 != zzdr.zza) {
                            return zzb2;
                        }
                        zzb2 = zzds.zzb(bArr, zza7, zzdr);
                        zzga2.zza(zzdr.zzb);
                    }
                    return zzb2;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzds.zza(bArr, i, zzfn, zzdr);
                }
                if (i5 == 0) {
                    return zzds.zza(i3, bArr, i, i2, zzfn, zzdr);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzga zzga3 = (zzga) zzfn;
                    int zza8 = zzds.zza(bArr, i, zzdr);
                    int i14 = zzdr.zza + zza8;
                    while (zza8 < i14) {
                        zzga3.zza(zzds.zzb(bArr, zza8));
                        zza8 += 8;
                    }
                    if (zza8 == i14) {
                        return zza8;
                    }
                    throw zzfm.zza();
                } else if (i5 == 1) {
                    zzga zzga4 = (zzga) zzfn;
                    zzga4.zza(zzds.zzb(bArr, i));
                    int i15 = i + 8;
                    while (i15 < i2) {
                        int zza9 = zzds.zza(bArr, i15, zzdr);
                        if (i3 != zzdr.zza) {
                            return i15;
                        }
                        zzga4.zza(zzds.zzb(bArr, zza9));
                        i15 = zza9 + 8;
                    }
                    return i15;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzff zzff = (zzff) zzfn;
                    int zza10 = zzds.zza(bArr, i, zzdr);
                    int i16 = zzdr.zza + zza10;
                    while (zza10 < i16) {
                        zzff.zzd(zzds.zza(bArr, zza10));
                        zza10 += 4;
                    }
                    if (zza10 == i16) {
                        return zza10;
                    }
                    throw zzfm.zza();
                } else if (i5 == 5) {
                    zzff zzff2 = (zzff) zzfn;
                    zzff2.zzd(zzds.zza(bArr, i));
                    int i17 = i + 4;
                    while (i17 < i2) {
                        int zza11 = zzds.zza(bArr, i17, zzdr);
                        if (i3 != zzdr.zza) {
                            return i17;
                        }
                        zzff2.zzd(zzds.zza(bArr, zza11));
                        i17 = zza11 + 4;
                    }
                    return i17;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzdu zzdu = (zzdu) zzfn;
                    int zza12 = zzds.zza(bArr, i, zzdr);
                    int i18 = zzdr.zza + zza12;
                    while (zza12 < i18) {
                        zza12 = zzds.zzb(bArr, zza12, zzdr);
                        zzdu.zza(zzdr.zzb != 0);
                    }
                    if (zza12 == i18) {
                        return zza12;
                    }
                    throw zzfm.zza();
                } else if (i5 == 0) {
                    zzdu zzdu2 = (zzdu) zzfn;
                    int zzb3 = zzds.zzb(bArr, i, zzdr);
                    zzdu2.zza(zzdr.zzb != 0);
                    while (zzb3 < i2) {
                        int zza13 = zzds.zza(bArr, zzb3, zzdr);
                        if (i3 != zzdr.zza) {
                            return zzb3;
                        }
                        zzb3 = zzds.zzb(bArr, zza13, zzdr);
                        zzdu2.zza(zzdr.zzb != 0);
                    }
                    return zzb3;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza14 = zzds.zza(bArr, i, zzdr);
                        int i19 = zzdr.zza;
                        if (i19 >= 0) {
                            if (i19 == 0) {
                                zzfn.add("");
                            } else {
                                zzfn.add(new String(bArr, zza14, i19, zzfh.zza));
                                zza14 += i19;
                            }
                            while (zza14 < i2) {
                                int zza15 = zzds.zza(bArr, zza14, zzdr);
                                if (i3 != zzdr.zza) {
                                    return zza14;
                                }
                                zza14 = zzds.zza(bArr, zza15, zzdr);
                                int i20 = zzdr.zza;
                                if (i20 < 0) {
                                    throw zzfm.zzb();
                                } else if (i20 == 0) {
                                    zzfn.add("");
                                } else {
                                    zzfn.add(new String(bArr, zza14, i20, zzfh.zza));
                                    zza14 += i20;
                                }
                            }
                            return zza14;
                        }
                        throw zzfm.zzb();
                    }
                    int zza16 = zzds.zza(bArr, i, zzdr);
                    int i21 = zzdr.zza;
                    if (i21 >= 0) {
                        if (i21 == 0) {
                            zzfn.add("");
                        } else {
                            int i22 = zza16 + i21;
                            if (zzif.zza(bArr, zza16, i22)) {
                                zzfn.add(new String(bArr, zza16, i21, zzfh.zza));
                                zza16 = i22;
                            } else {
                                throw zzfm.zzh();
                            }
                        }
                        while (zza16 < i2) {
                            int zza17 = zzds.zza(bArr, zza16, zzdr);
                            if (i3 != zzdr.zza) {
                                return zza16;
                            }
                            zza16 = zzds.zza(bArr, zza17, zzdr);
                            int i23 = zzdr.zza;
                            if (i23 < 0) {
                                throw zzfm.zzb();
                            } else if (i23 == 0) {
                                zzfn.add("");
                            } else {
                                int i24 = zza16 + i23;
                                if (zzif.zza(bArr, zza16, i24)) {
                                    zzfn.add(new String(bArr, zza16, i23, zzfh.zza));
                                    zza16 = i24;
                                } else {
                                    throw zzfm.zzh();
                                }
                            }
                        }
                        return zza16;
                    }
                    throw zzfm.zzb();
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zzds.zza(zza(i6), i3, bArr, i, i2, zzfn, zzdr);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int zza18 = zzds.zza(bArr, i, zzdr);
                    int i25 = zzdr.zza;
                    if (i25 < 0) {
                        throw zzfm.zzb();
                    } else if (i25 <= bArr.length - zza18) {
                        if (i25 == 0) {
                            zzfn.add(zzdw.zza);
                        } else {
                            zzfn.add(zzdw.zza(bArr, zza18, i25));
                            zza18 += i25;
                        }
                        while (zza18 < i2) {
                            int zza19 = zzds.zza(bArr, zza18, zzdr);
                            if (i3 != zzdr.zza) {
                                return zza18;
                            }
                            zza18 = zzds.zza(bArr, zza19, zzdr);
                            int i26 = zzdr.zza;
                            if (i26 < 0) {
                                throw zzfm.zzb();
                            } else if (i26 > bArr.length - zza18) {
                                throw zzfm.zza();
                            } else if (i26 == 0) {
                                zzfn.add(zzdw.zza);
                            } else {
                                zzfn.add(zzdw.zza(bArr, zza18, i26));
                                zza18 += i26;
                            }
                        }
                        return zza18;
                    } else {
                        throw zzfm.zza();
                    }
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    i8 = zzds.zza(bArr, i, zzfn, zzdr);
                } else if (i5 == 0) {
                    i8 = zzds.zza(i3, bArr, i, i2, zzfn, zzdr);
                }
                T t2 = t;
                zzhw zzhw = t2.zzb;
                if (zzhw == zzhw.zza()) {
                    zzhw = null;
                }
                zzhw zzhw2 = (zzhw) zzhh.zza(i4, zzfn, zzc(i6), zzhw, this.zzq);
                if (zzhw2 != null) {
                    t2.zzb = zzhw2;
                }
                return i8;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzff zzff3 = (zzff) zzfn;
                    int zza20 = zzds.zza(bArr, i, zzdr);
                    int i27 = zzdr.zza + zza20;
                    while (zza20 < i27) {
                        zza20 = zzds.zza(bArr, zza20, zzdr);
                        zzff3.zzd(zzei.zze(zzdr.zza));
                    }
                    if (zza20 == i27) {
                        return zza20;
                    }
                    throw zzfm.zza();
                } else if (i5 == 0) {
                    zzff zzff4 = (zzff) zzfn;
                    int zza21 = zzds.zza(bArr, i, zzdr);
                    zzff4.zzd(zzei.zze(zzdr.zza));
                    while (zza21 < i2) {
                        int zza22 = zzds.zza(bArr, zza21, zzdr);
                        if (i3 != zzdr.zza) {
                            return zza21;
                        }
                        zza21 = zzds.zza(bArr, zza22, zzdr);
                        zzff4.zzd(zzei.zze(zzdr.zza));
                    }
                    return zza21;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzga zzga5 = (zzga) zzfn;
                    int zza23 = zzds.zza(bArr, i, zzdr);
                    int i28 = zzdr.zza + zza23;
                    while (zza23 < i28) {
                        zza23 = zzds.zzb(bArr, zza23, zzdr);
                        zzga5.zza(zzei.zza(zzdr.zzb));
                    }
                    if (zza23 == i28) {
                        return zza23;
                    }
                    throw zzfm.zza();
                } else if (i5 == 0) {
                    zzga zzga6 = (zzga) zzfn;
                    int zzb4 = zzds.zzb(bArr, i, zzdr);
                    zzga6.zza(zzei.zza(zzdr.zzb));
                    while (zzb4 < i2) {
                        int zza24 = zzds.zza(bArr, zzb4, zzdr);
                        if (i3 != zzdr.zza) {
                            return zzb4;
                        }
                        zzb4 = zzds.zzb(bArr, zza24, zzdr);
                        zzga6.zza(zzei.zza(zzdr.zzb));
                    }
                    return zzb4;
                }
                break;
            case 49:
                if (i5 == 3) {
                    zzhf zza25 = zza(i6);
                    int i29 = (i3 & -8) | 4;
                    int zza26 = zzds.zza(zza25, bArr, i, i2, i29, zzdr);
                    zzfn.add(zzdr.zzc);
                    while (zza26 < i2) {
                        int zza27 = zzds.zza(bArr, zza26, zzdr);
                        if (i3 != zzdr.zza) {
                            return zza26;
                        }
                        zza26 = zzds.zza(zza25, bArr, zza27, i2, i29, zzdr);
                        zzfn.add(zzdr.zzc);
                    }
                    return zza26;
                }
                break;
        }
        return i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0040 */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzdr zzdr) throws IOException {
        int i4;
        int i5;
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzd(object)) {
            Object zzf2 = this.zzs.zzf(zzb2);
            this.zzs.zza(zzf2, object);
            unsafe.putObject(t, j, zzf2);
            object = zzf2;
        }
        zzgh<?, ?> zzb3 = this.zzs.zzb(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzds.zza(bArr, i, zzdr);
        int i6 = zzdr.zza;
        if (i6 < 0 || i6 > i2 - zza3) {
            throw zzfm.zza();
        }
        int i7 = i6 + zza3;
        EventLogTags eventLogTags = (K) zzb3.zzb;
        EventLogTags eventLogTags2 = (V) zzb3.zzd;
        while (zza3 < i7) {
            int i8 = zza3 + 1;
            byte b = bArr[zza3];
            if (b < 0) {
                i5 = zzds.zza(b, bArr, i8, zzdr);
                i4 = zzdr.zza;
            } else {
                i5 = i8;
                i4 = b;
            }
            int i9 = (i4 == 1 ? 1 : 0) >>> 3;
            int i10 = (i4 == 1 ? 1 : 0) & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzb3.zzc.zzb()) {
                    zza3 = zza(bArr, i5, i2, zzb3.zzc, zzb3.zzd.getClass(), zzdr);
                    eventLogTags2 = (V) zzdr.zzc;
                }
            } else if (i10 == zzb3.zza.zzb()) {
                zza3 = zza(bArr, i5, i2, zzb3.zza, (Class<?>) null, zzdr);
                eventLogTags = (K) zzdr.zzc;
            }
            zza3 = zzds.zza(i4, bArr, i5, i2, zzdr);
        }
        if (zza3 == i7) {
            zza2.put(eventLogTags, eventLogTags2);
            return i7;
        }
        throw zzfm.zzg();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzdr zzdr) throws IOException {
        int i9;
        Object obj;
        Object obj2;
        Unsafe unsafe = zzb;
        long j2 = (long) (this.zzc[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzds.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzds.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzds.zzb(bArr, i, zzdr);
                    unsafe.putObject(t, j, Long.valueOf(zzdr.zzb));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzds.zza(bArr, i, zzdr);
                    unsafe.putObject(t, j, Integer.valueOf(zzdr.zza));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzds.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzds.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzds.zzb(bArr, i, zzdr);
                    unsafe.putObject(t, j, Boolean.valueOf(zzdr.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzds.zza(bArr, i, zzdr);
                    int i10 = zzdr.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzif.zza(bArr, zza2, zza2 + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza2, i10, zzfh.zza));
                        zza2 += i10;
                    } else {
                        throw zzfm.zzh();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzds.zza(zza(i8), bArr, i, i2, zzdr);
                    if (unsafe.getInt(t, j2) == i4) {
                        obj = unsafe.getObject(t, j);
                    } else {
                        obj = null;
                    }
                    if (obj == null) {
                        unsafe.putObject(t, j, zzdr.zzc);
                    } else {
                        unsafe.putObject(t, j, zzfh.zza(obj, zzdr.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzds.zze(bArr, i, zzdr);
                    unsafe.putObject(t, j, zzdr.zzc);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzds.zza(bArr, i, zzdr);
                    int i11 = zzdr.zza;
                    zzfi zzc2 = zzc(i8);
                    if (zzc2 == null || zzc2.zza(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza4;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zze(t).zza(i3, Long.valueOf((long) i11));
                    return zza4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzds.zza(bArr, i, zzdr);
                    unsafe.putObject(t, j, Integer.valueOf(zzei.zze(zzdr.zza)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzds.zzb(bArr, i, zzdr);
                    unsafe.putObject(t, j, Long.valueOf(zzei.zza(zzdr.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzds.zza(zza(i8), bArr, i, i2, (i3 & -8) | 4, zzdr);
                    if (unsafe.getInt(t, j2) == i4) {
                        obj2 = unsafe.getObject(t, j);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        unsafe.putObject(t, j, zzdr.zzc);
                    } else {
                        unsafe.putObject(t, j, zzfh.zza(obj2, zzdr.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzhf zza(int i) {
        int i2 = (i / 3) << 1;
        zzhf zzhf = (zzhf) this.zzd[i2];
        if (zzhf != null) {
            return zzhf;
        }
        zzhf<T> zza2 = zzhb.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfi zzc(int i) {
        return (zzfi) this.zzd[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzdr zzdr) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzgq<T> zzgq;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        zzdr zzdr2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        zzdr zzdr3;
        zzgq<T> zzgq2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i18 = i2;
        int i19 = i3;
        zzdr zzdr4 = zzdr;
        Unsafe unsafe2 = zzb;
        int i20 = i;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = -1;
        while (true) {
            if (i20 < i18) {
                int i26 = i20 + 1;
                byte b2 = bArr2[i20];
                if (b2 < 0) {
                    i5 = zzds.zza(b2, bArr2, i26, zzdr4);
                    b = zzdr4.zza;
                } else {
                    b = b2;
                    i5 = i26;
                }
                int i27 = b >>> 3;
                int i28 = b & 7;
                if (i27 > i21) {
                    i6 = zzgq2.zza(i27, i22 / 3);
                } else {
                    i6 = zzgq2.zzg(i27);
                }
                if (i6 == -1) {
                    i8 = i27;
                    i10 = i5;
                    i7 = b;
                    unsafe = unsafe2;
                    i9 = 0;
                } else {
                    int[] iArr = zzgq2.zzc;
                    int i29 = iArr[i6 + 1];
                    int i30 = (i29 & 267386880) >>> 20;
                    long j = (long) (i29 & 1048575);
                    if (i30 <= 17) {
                        int i31 = iArr[i6 + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        if (i33 != i25) {
                            if (i25 != -1) {
                                unsafe2.putInt(t4, (long) i25, i24);
                            }
                            i24 = unsafe2.getInt(t4, (long) i33);
                            i25 = i33;
                        }
                        switch (i30) {
                            case 0:
                                i15 = i6;
                                i14 = i27;
                                i13 = i25;
                                i16 = b;
                                bArr2 = bArr;
                                i17 = i5;
                                if (i28 == 1) {
                                    zzid.zza(t4, j, zzds.zzc(bArr2, i17));
                                    i20 = i17 + 8;
                                    i24 |= i32;
                                    i25 = i13;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                }
                                i10 = i17;
                                i7 = i16;
                                i9 = i15;
                                unsafe = unsafe2;
                                i8 = i14;
                                i25 = i13;
                                break;
                            case 1:
                                i15 = i6;
                                i14 = i27;
                                i13 = i25;
                                i16 = b;
                                bArr2 = bArr;
                                i17 = i5;
                                if (i28 == 5) {
                                    zzid.zza((Object) t4, j, zzds.zzd(bArr2, i17));
                                    i20 = i17 + 4;
                                    i24 |= i32;
                                    i25 = i13;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                }
                                i10 = i17;
                                i7 = i16;
                                i9 = i15;
                                unsafe = unsafe2;
                                i8 = i14;
                                i25 = i13;
                                break;
                            case 2:
                            case 3:
                                i15 = i6;
                                i14 = i27;
                                i13 = i25;
                                i16 = b;
                                bArr2 = bArr;
                                i17 = i5;
                                if (i28 == 0) {
                                    int zzb2 = zzds.zzb(bArr2, i17, zzdr);
                                    unsafe2.putLong(t, j, zzdr.zzb);
                                    i24 |= i32;
                                    i20 = zzb2;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i25 = i13;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                }
                                i10 = i17;
                                i7 = i16;
                                i9 = i15;
                                unsafe = unsafe2;
                                i8 = i14;
                                i25 = i13;
                                break;
                            case 4:
                            case 11:
                                i15 = i6;
                                i14 = i27;
                                i13 = i25;
                                i16 = b;
                                bArr2 = bArr;
                                i17 = i5;
                                if (i28 == 0) {
                                    i20 = zzds.zza(bArr2, i17, zzdr);
                                    unsafe2.putInt(t4, j, zzdr.zza);
                                    i24 |= i32;
                                    i25 = i13;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                }
                                i10 = i17;
                                i7 = i16;
                                i9 = i15;
                                unsafe = unsafe2;
                                i8 = i14;
                                i25 = i13;
                                break;
                            case 5:
                            case 14:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 1) {
                                    unsafe2.putLong(t, j, zzds.zzb(bArr2, i5));
                                    i20 = i5 + 8;
                                    i24 |= i32;
                                    i25 = i25;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 6:
                            case 13:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 5) {
                                    unsafe2.putInt(t4, j, zzds.zza(bArr2, i5));
                                    i20 = i5 + 4;
                                    i24 |= i32;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i19 = i3;
                                    i18 = i2;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 7:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    int zzb3 = zzds.zzb(bArr2, i5, zzdr);
                                    zzid.zza(t4, j, zzdr.zzb != 0);
                                    i24 |= i32;
                                    i20 = zzb3;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i19 = i3;
                                    i18 = i2;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 8:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    if ((i29 & 536870912) == 0) {
                                        i20 = zzds.zzc(bArr2, i5, zzdr);
                                    } else {
                                        i20 = zzds.zzd(bArr2, i5, zzdr);
                                    }
                                    unsafe2.putObject(t4, j, zzdr.zzc);
                                    i24 |= i32;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i19 = i3;
                                    i18 = i2;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 9:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    i20 = zzds.zza(zzgq2.zza(i15), bArr2, i5, i2, zzdr);
                                    if ((i24 & i32) == 0) {
                                        unsafe2.putObject(t4, j, zzdr.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j, zzfh.zza(unsafe2.getObject(t4, j), zzdr.zzc));
                                    }
                                    i24 |= i32;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i19 = i3;
                                    i18 = i2;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 10:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    i20 = zzds.zze(bArr2, i5, zzdr);
                                    unsafe2.putObject(t4, j, zzdr.zzc);
                                    i24 |= i32;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 12:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i20 = zzds.zza(bArr2, i5, zzdr);
                                    int i34 = zzdr.zza;
                                    zzfi zzc2 = zzgq2.zzc(i15);
                                    if (zzc2 != null && !zzc2.zza(i34)) {
                                        zze(t).zza(i16, Long.valueOf((long) i34));
                                        i23 = i16;
                                        i22 = i15;
                                        i21 = i14;
                                        zzdr4 = zzdr;
                                        i18 = i2;
                                        i19 = i3;
                                        break;
                                    } else {
                                        unsafe2.putInt(t4, j, i34);
                                        i24 |= i32;
                                        i23 = i16;
                                        i22 = i15;
                                        i21 = i14;
                                        zzdr4 = zzdr;
                                        i18 = i2;
                                        i19 = i3;
                                        break;
                                    }
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 15:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i20 = zzds.zza(bArr2, i5, zzdr);
                                    unsafe2.putInt(t4, j, zzei.zze(zzdr.zza));
                                    i24 |= i32;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 16:
                                i15 = i6;
                                i14 = i27;
                                i16 = b;
                                if (i28 == 0) {
                                    bArr2 = bArr;
                                    int zzb4 = zzds.zzb(bArr2, i5, zzdr);
                                    unsafe2.putLong(t, j, zzei.zza(zzdr.zzb));
                                    i24 |= i32;
                                    i20 = zzb4;
                                    i23 = i16;
                                    i22 = i15;
                                    i21 = i14;
                                    zzdr4 = zzdr;
                                    i18 = i2;
                                    i19 = i3;
                                    break;
                                } else {
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            case 17:
                                if (i28 == 3) {
                                    i20 = zzds.zza(zzgq2.zza(i6), bArr, i5, i2, (i27 << 3) | 4, zzdr);
                                    if ((i24 & i32) == 0) {
                                        zzdr3 = zzdr;
                                        unsafe2.putObject(t4, j, zzdr3.zzc);
                                    } else {
                                        zzdr3 = zzdr;
                                        unsafe2.putObject(t4, j, zzfh.zza(unsafe2.getObject(t4, j), zzdr3.zzc));
                                    }
                                    i24 |= i32;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i23 = b;
                                    i22 = i6;
                                    i21 = i27;
                                    i19 = i3;
                                    zzdr4 = zzdr3;
                                    break;
                                } else {
                                    i15 = i6;
                                    i14 = i27;
                                    i16 = b;
                                    i13 = i25;
                                    i17 = i5;
                                    i10 = i17;
                                    i7 = i16;
                                    i9 = i15;
                                    unsafe = unsafe2;
                                    i8 = i14;
                                    i25 = i13;
                                    break;
                                }
                            default:
                                i15 = i6;
                                i14 = i27;
                                i13 = i25;
                                i16 = b;
                                i17 = i5;
                                i10 = i17;
                                i7 = i16;
                                i9 = i15;
                                unsafe = unsafe2;
                                i8 = i14;
                                i25 = i13;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (i30 != 27) {
                            i11 = i24;
                            if (i30 <= 49) {
                                i8 = i27;
                                i7 = b;
                                i9 = i6;
                                unsafe = unsafe2;
                                i20 = zza(t, bArr, i5, i2, b, i27, i28, i6, (long) i29, i30, j, zzdr);
                                if (i20 == i5) {
                                    i10 = i20;
                                    i25 = i25;
                                    i24 = i11;
                                } else {
                                    zzgq2 = this;
                                    t4 = t;
                                    bArr2 = bArr;
                                    i18 = i2;
                                    i19 = i3;
                                    zzdr4 = zzdr;
                                    i25 = i25;
                                    i22 = i9;
                                    i24 = i11;
                                    i21 = i8;
                                    i23 = i7;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i8 = i27;
                                i12 = i5;
                                i7 = b;
                                i9 = i6;
                                unsafe = unsafe2;
                                if (i30 != 50) {
                                    i20 = zza(t, bArr, i12, i2, i7, i8, i28, i29, i30, j, i9, zzdr);
                                    if (i20 == i12) {
                                        i10 = i20;
                                        i25 = i25;
                                        i24 = i11;
                                    } else {
                                        i23 = i7;
                                        zzgq2 = this;
                                        zzdr4 = zzdr;
                                        i21 = i8;
                                        t4 = t;
                                        i25 = i25;
                                        i22 = i9;
                                        i24 = i11;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        i18 = i2;
                                        i19 = i3;
                                    }
                                } else if (i28 == 2) {
                                    i20 = zza(t, bArr, i12, i2, i9, j, zzdr);
                                    if (i20 == i12) {
                                        i10 = i20;
                                        i25 = i25;
                                        i24 = i11;
                                    } else {
                                        zzgq2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i18 = i2;
                                        i19 = i3;
                                        zzdr4 = zzdr;
                                        i25 = i25;
                                        i22 = i9;
                                        i24 = i11;
                                        i21 = i8;
                                        i23 = i7;
                                        unsafe2 = unsafe;
                                    }
                                }
                            }
                        } else if (i28 == 2) {
                            zzfn zzfn = (zzfn) unsafe2.getObject(t4, j);
                            if (!zzfn.zza()) {
                                int size = zzfn.size();
                                zzfn = zzfn.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzfn);
                            }
                            i20 = zzds.zza(zzgq2.zza(i6), b, bArr, i5, i2, zzfn, zzdr);
                            i19 = i3;
                            i21 = i27;
                            i23 = b;
                            i22 = i6;
                            zzdr4 = zzdr4;
                            i25 = i25;
                            i24 = i24;
                            i18 = i2;
                        } else {
                            i11 = i24;
                            i8 = i27;
                            i12 = i5;
                            i7 = b;
                            i9 = i6;
                            unsafe = unsafe2;
                        }
                        i10 = i12;
                        i25 = i25;
                        i24 = i11;
                    }
                }
                i4 = i3;
                if (i7 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzdr2 = zzdr;
                        if (zzdr2.zzd == zzer.zza()) {
                            t3 = t;
                        } else if (zzdr2.zzd.zza(this.zzg, i8) == null) {
                            i20 = zzds.zza(i7, bArr, i10, i2, zze(t), zzdr);
                            t4 = t;
                            i18 = i2;
                            i23 = i7;
                            zzgq2 = this;
                            zzdr4 = zzdr2;
                            i21 = i8;
                            i22 = i9;
                            unsafe2 = unsafe;
                            bArr2 = bArr;
                            i19 = i4;
                        } else {
                            T t5 = t;
                            t5.zza();
                            zzeu<zzfe.zze> zzeu = t5.zzc;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        t3 = t;
                        zzdr2 = zzdr;
                    }
                    i20 = zzds.zza(i7, bArr, i10, i2, zze(t), zzdr);
                    i23 = i7;
                    zzgq2 = this;
                    zzdr4 = zzdr2;
                    i21 = i8;
                    t4 = t3;
                    i22 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i18 = i2;
                    i19 = i4;
                } else {
                    zzgq = this;
                    t2 = t;
                    i20 = i10;
                    i23 = i7;
                }
            } else {
                unsafe = unsafe2;
                i4 = i19;
                t2 = t4;
                zzgq = zzgq2;
            }
        }
        if (i25 != -1) {
            unsafe.putInt(t2, (long) i25, i24);
        }
        zzhw zzhw = null;
        for (int i35 = zzgq.zzm; i35 < zzgq.zzn; i35++) {
            zzhw = (zzhw) zzgq.zza(t2, zzgq.zzl[i35], zzhw, (zzhx<UT, UB>) zzgq.zzq);
        }
        if (zzhw != null) {
            zzgq.zzq.zzb(t2, zzhw);
        }
        if (i4 == 0) {
            if (i20 != i2) {
                throw zzfm.zzg();
            }
        } else if (i20 > i2 || i23 != i4) {
            throw zzfm.zzg();
        }
        return i20;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zza(T t, byte[] bArr, int i, int i2, zzdr zzdr) throws IOException {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        zzgq<T> zzgq = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i2;
        zzdr zzdr2 = zzdr;
        if (zzgq.zzj) {
            Unsafe unsafe2 = zzb;
            int i10 = -1;
            int i11 = i;
            int i12 = -1;
            int i13 = 0;
            while (i11 < i9) {
                int i14 = i11 + 1;
                byte b2 = bArr2[i11];
                if (b2 < 0) {
                    i3 = zzds.zza(b2, bArr2, i14, zzdr2);
                    b = zzdr2.zza;
                } else {
                    b = b2;
                    i3 = i14;
                }
                int i15 = b >>> 3;
                int i16 = b & 7;
                if (i15 > i12) {
                    i4 = zzgq.zza(i15, i13 / 3);
                } else {
                    i4 = zzgq.zzg(i15);
                }
                if (i4 == i10) {
                    i5 = i15;
                    i7 = i3;
                    unsafe = unsafe2;
                    i6 = 0;
                } else {
                    int i17 = zzgq.zzc[i4 + 1];
                    int i18 = (267386880 & i17) >>> 20;
                    long j = (long) (1048575 & i17);
                    if (i18 <= 17) {
                        boolean z = true;
                        switch (i18) {
                            case 0:
                                if (i16 != 1) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    zzid.zza(t2, j, zzds.zzc(bArr2, i3));
                                    i11 = i3 + 8;
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 1:
                                if (i16 != 5) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    zzid.zza((Object) t2, j, zzds.zzd(bArr2, i3));
                                    i11 = i3 + 4;
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 2:
                            case 3:
                                if (i16 != 0) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    int zzb2 = zzds.zzb(bArr2, i3, zzdr2);
                                    unsafe2.putLong(t, j, zzdr2.zzb);
                                    i11 = zzb2;
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 4:
                            case 11:
                                if (i16 != 0) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    i11 = zzds.zza(bArr2, i3, zzdr2);
                                    unsafe2.putInt(t2, j, zzdr2.zza);
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 5:
                            case 14:
                                if (i16 != 1) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, zzds.zzb(bArr2, i3));
                                    i11 = i3 + 8;
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 6:
                            case 13:
                                if (i16 != 5) {
                                    i6 = i4;
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    unsafe2.putInt(t2, j, zzds.zza(bArr2, i3));
                                    i11 = i3 + 4;
                                    i13 = i4;
                                    i12 = i15;
                                    i10 = -1;
                                    continue;
                                }
                            case 7:
                                if (i16 != 0) {
                                    i6 = i4;
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    int zzb3 = zzds.zzb(bArr2, i3, zzdr2);
                                    if (zzdr2.zzb == 0) {
                                        z = false;
                                    }
                                    zzid.zza(t2, j, z);
                                    i11 = zzb3;
                                    i13 = i4;
                                    i12 = i15;
                                    i10 = -1;
                                    continue;
                                }
                            case 8:
                                if (i16 != 2) {
                                    i6 = i4;
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    if ((536870912 & i17) == 0) {
                                        i11 = zzds.zzc(bArr2, i3, zzdr2);
                                    } else {
                                        i11 = zzds.zzd(bArr2, i3, zzdr2);
                                    }
                                    unsafe2.putObject(t2, j, zzdr2.zzc);
                                    i13 = i4;
                                    i12 = i15;
                                    i10 = -1;
                                    continue;
                                }
                            case 9:
                                if (i16 != 2) {
                                    i6 = i4;
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    i11 = zzds.zza(zzgq.zza(i4), bArr2, i3, i9, zzdr2);
                                    Object object = unsafe2.getObject(t2, j);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j, zzdr2.zzc);
                                    } else {
                                        unsafe2.putObject(t2, j, zzfh.zza(object, zzdr2.zzc));
                                    }
                                    i13 = i4;
                                    i12 = i15;
                                    i10 = -1;
                                    continue;
                                }
                            case 10:
                                if (i16 != 2) {
                                    i6 = i4;
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    break;
                                } else {
                                    i11 = zzds.zze(bArr2, i3, zzdr2);
                                    unsafe2.putObject(t2, j, zzdr2.zzc);
                                    i13 = i4;
                                    i12 = i15;
                                    i10 = -1;
                                    continue;
                                }
                            case 12:
                                if (i16 != 0) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    i11 = zzds.zza(bArr2, i3, zzdr2);
                                    unsafe2.putInt(t2, j, zzdr2.zza);
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 15:
                                if (i16 != 0) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    i11 = zzds.zza(bArr2, i3, zzdr2);
                                    unsafe2.putInt(t2, j, zzei.zze(zzdr2.zza));
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            case 16:
                                if (i16 != 0) {
                                    i5 = i15;
                                    i8 = i3;
                                    unsafe = unsafe2;
                                    i6 = i4;
                                    break;
                                } else {
                                    int zzb4 = zzds.zzb(bArr2, i3, zzdr2);
                                    unsafe2.putLong(t, j, zzei.zza(zzdr2.zzb));
                                    i11 = zzb4;
                                    i12 = i15;
                                    i13 = i4;
                                    i10 = -1;
                                    continue;
                                }
                            default:
                                i5 = i15;
                                i8 = i3;
                                unsafe = unsafe2;
                                i6 = i4;
                                break;
                        }
                    } else if (i18 != 27) {
                        i6 = i4;
                        if (i18 <= 49) {
                            i5 = i15;
                            unsafe = unsafe2;
                            i11 = zza(t, bArr, i3, i2, b, i15, i16, i6, (long) i17, i18, j, zzdr);
                            if (i11 == i3) {
                                i7 = i11;
                            } else {
                                zzgq = this;
                                t2 = t;
                                bArr2 = bArr;
                                i9 = i2;
                                zzdr2 = zzdr;
                                unsafe2 = unsafe;
                                i13 = i6;
                                i12 = i5;
                                i10 = -1;
                            }
                        } else {
                            i5 = i15;
                            i8 = i3;
                            unsafe = unsafe2;
                            if (i18 != 50) {
                                i11 = zza(t, bArr, i8, i2, b, i5, i16, i17, i18, j, i6, zzdr);
                                if (i11 == i8) {
                                    i7 = i11;
                                } else {
                                    zzgq = this;
                                    t2 = t;
                                    bArr2 = bArr;
                                    i9 = i2;
                                    zzdr2 = zzdr;
                                    unsafe2 = unsafe;
                                    i13 = i6;
                                    i12 = i5;
                                    i10 = -1;
                                }
                            } else if (i16 == 2) {
                                i11 = zza(t, bArr, i8, i2, i6, j, zzdr);
                                if (i11 == i8) {
                                    i7 = i11;
                                } else {
                                    zzgq = this;
                                    t2 = t;
                                    bArr2 = bArr;
                                    i9 = i2;
                                    zzdr2 = zzdr;
                                    unsafe2 = unsafe;
                                    i13 = i6;
                                    i12 = i5;
                                    i10 = -1;
                                }
                            }
                        }
                    } else if (i16 == 2) {
                        zzfn zzfn = (zzfn) unsafe2.getObject(t2, j);
                        if (!zzfn.zza()) {
                            int size = zzfn.size();
                            zzfn = zzfn.zza(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j, zzfn);
                        }
                        i11 = zzds.zza(zzgq.zza(i4), b, bArr, i3, i2, zzfn, zzdr);
                        i12 = i15;
                        i13 = i4;
                        i10 = -1;
                    } else {
                        i6 = i4;
                        i5 = i15;
                        i8 = i3;
                        unsafe = unsafe2;
                    }
                    i7 = i8;
                }
                i11 = zzds.zza(b, bArr, i7, i2, zze(t), zzdr);
                zzgq = this;
                t2 = t;
                bArr2 = bArr;
                i9 = i2;
                zzdr2 = zzdr;
                unsafe2 = unsafe;
                i13 = i6;
                i12 = i5;
                i10 = -1;
            }
            if (i11 != i2) {
                throw zzfm.zzg();
            }
            return;
        }
        zza(t, bArr, i, i2, 0, zzdr);
    }

    @Override // com.google.android.gms.internal.measurement.zzhf
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzid.zzf(t, zzd2);
            if (zzf2 != null) {
                zzid.zza(t, zzd2, this.zzs.zze(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhx<UT, UB> zzhx) {
        zzfi zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzid.zzf(obj, (long) (zzd(i) & 1048575));
        return (zzf2 == null || (zzc2 = zzc(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzs.zza(zzf2), zzc2, ub, zzhx);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfi zzfi, UB ub, zzhx<UT, UB> zzhx) {
        zzgh<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfi.zza(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzhx.zza();
                }
                zzee zzc2 = zzdw.zzc(zzge.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzge.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzhx.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.zzhf] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.zzhf] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzhf
    public final boolean zzd(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzm) {
                return !this.zzh || this.zzr.zza(t).zzf();
            }
            int i5 = this.zzl[i3];
            int i6 = this.zzc[i5];
            int zzd2 = zzd(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzb.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzd2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzc2 = this.zzs.zzc(zzid.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i5)).zzc.zza() == zzir.MESSAGE) {
                                    zzhf<T> zzhf = 0;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhf == null) {
                                            zzhf = zzhb.zza().zza((Class) next.getClass());
                                        }
                                        boolean zzd3 = zzhf.zzd(next);
                                        zzhf = zzhf;
                                        if (!zzd3) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzid.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    ?? zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza(t, zzd2, zza(i5))) {
                return false;
            }
            i3++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzhf */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzhf zzhf) {
        return zzhf.zzd(zzid.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zziq zziq) throws IOException {
        if (obj instanceof String) {
            zziq.zza(i, (String) obj);
        } else {
            zziq.zza(i, (zzdw) obj);
        }
    }

    private final void zza(Object obj, int i, zzhc zzhc) throws IOException {
        if (zzf(i)) {
            zzid.zza(obj, (long) (i & 1048575), zzhc.zzm());
        } else if (this.zzi) {
            zzid.zza(obj, (long) (i & 1048575), zzhc.zzl());
        } else {
            zzid.zza(obj, (long) (i & 1048575), zzhc.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzid.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzid.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzid.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzid.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzid.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza((Object) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzid.zze(t, j) != 0.0d;
                case 1:
                    return zzid.zzd(t, j) != 0.0f;
                case 2:
                    return zzid.zzb(t, j) != 0;
                case 3:
                    return zzid.zzb(t, j) != 0;
                case 4:
                    return zzid.zza(t, j) != 0;
                case 5:
                    return zzid.zzb(t, j) != 0;
                case 6:
                    return zzid.zza(t, j) != 0;
                case 7:
                    return zzid.zzc(t, j);
                case 8:
                    Object zzf2 = zzid.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdw) {
                        return !zzdw.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzid.zzf(t, j) != null;
                case 10:
                    return !zzdw.zza.equals(zzid.zzf(t, j));
                case 11:
                    return zzid.zza(t, j) != 0;
                case 12:
                    return zzid.zza(t, j) != 0;
                case 13:
                    return zzid.zza(t, j) != 0;
                case 14:
                    return zzid.zzb(t, j) != 0;
                case 15:
                    return zzid.zza(t, j) != 0;
                case 16:
                    return zzid.zzb(t, j) != 0;
                case 17:
                    return zzid.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzid.zza(t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzid.zza((Object) t, j, zzid.zza(t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzid.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzid.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
