package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public class zzeg extends zzed {
    protected final byte[] zzb;

    zzeg(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdw
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final zzdw zza(int i, int i2) {
        int zzb2 = zzb(0, i2, zza());
        if (zzb2 == 0) {
            return zzdw.zza;
        }
        return new zzdz(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzdw
    public final void zza(zzdt zzdt) throws IOException {
        zzdt.zza(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzdw
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final boolean zzc() {
        int zze = zze();
        return zzif.zza(this.zzb, zze, zza() + zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzdw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdw) || zza() != ((zzdw) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzeg)) {
            return obj.equals(this);
        }
        zzeg zzeg = (zzeg) obj;
        int zzd = zzd();
        int zzd2 = zzeg.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzeg, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzed
    public final boolean zza(zzdw zzdw, int i, int i2) {
        if (i2 > zzdw.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdw.zza()) {
            int zza2 = zzdw.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdw instanceof zzeg)) {
            return zzdw.zza(0, i2).equals(zza(0, i2));
        } else {
            zzeg zzeg = (zzeg) zzdw;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzeg.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzeg.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzdw
    public final int zza(int i, int i2, int i3) {
        return zzfh.zza(i, this.zzb, zze(), i3);
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }
}
