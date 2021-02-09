package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
final class zzhz extends zzhx<zzhw, zzhw> {
    zzhz() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final boolean zza(zzhc zzhc) {
        return false;
    }

    private static void zza(Object obj, zzhw zzhw) {
        ((zzfe) obj).zzb = zzhw;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final void zzd(Object obj) {
        ((zzfe) obj).zzb.zzc();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ int zzf(zzhw zzhw) {
        return zzhw.zze();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ int zze(zzhw zzhw) {
        return zzhw.zzd();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ zzhw zzc(zzhw zzhw, zzhw zzhw2) {
        zzhw zzhw3 = zzhw;
        zzhw zzhw4 = zzhw2;
        if (zzhw4.equals(zzhw.zza())) {
            return zzhw3;
        }
        return zzhw.zza(zzhw3, zzhw4);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.measurement.zziq] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zzb(zzhw zzhw, zziq zziq) throws IOException {
        zzhw.zza(zziq);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.measurement.zziq] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zza(zzhw zzhw, zziq zziq) throws IOException {
        zzhw.zzb(zziq);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zzb(Object obj, zzhw zzhw) {
        zza(obj, zzhw);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ zzhw zzc(Object obj) {
        zzhw zzhw = ((zzfe) obj).zzb;
        if (zzhw != zzhw.zza()) {
            return zzhw;
        }
        zzhw zzb = zzhw.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ zzhw zzb(Object obj) {
        return ((zzfe) obj).zzb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* bridge */ /* synthetic */ void zza(Object obj, zzhw zzhw) {
        zza(obj, zzhw);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ zzhw zza(zzhw zzhw) {
        zzhw zzhw2 = zzhw;
        zzhw2.zzc();
        return zzhw2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ zzhw zza() {
        return zzhw.zzb();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zza(zzhw zzhw, int i, zzhw zzhw2) {
        zzhw.zza((i << 3) | 3, zzhw2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, com.google.android.gms.internal.measurement.zzdw] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zza(zzhw zzhw, int i, zzdw zzdw) {
        zzhw.zza((i << 3) | 2, zzdw);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zzb(zzhw zzhw, int i, long j) {
        zzhw.zza((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zza(zzhw zzhw, int i, int i2) {
        zzhw.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhx
    public final /* synthetic */ void zza(zzhw zzhw, int i, long j) {
        zzhw.zza(i << 3, Long.valueOf(j));
    }
}
