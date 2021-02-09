package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
public final class zzbs {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zza extends zzfe<zza, C0003zza> implements zzgo {
        private static final zza zzh;
        private static volatile zzgz<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbs$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class C0003zza extends zzfe.zza<zza, C0003zza> implements zzgo {
            private C0003zza() {
                super(zza.zzh);
            }

            public final C0003zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zza) i);
                return this;
            }

            public final C0003zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zza) ((zzi) ((zzfe) zza.zzv())));
                return this;
            }

            public final boolean zza() {
                return ((zza) this.zza).zzd();
            }

            public final zzi zzb() {
                return ((zza) this.zza).zze();
            }

            public final C0003zza zza(zzi zzi) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzi);
                return this;
            }

            public final C0003zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zza) z);
                return this;
            }

            /* synthetic */ C0003zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        public static C0003zza zzh() {
            return (C0003zza) zzh.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0003zza(null);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgz<zza> zzgz = zzi;
                    if (zzgz == null) {
                        synchronized (zza.class) {
                            zzgz = zzi;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzh);
                                zzi = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzfe.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzb extends zzfe<zzb, zza> implements zzgo {
        private static final zzb zzf;
        private static volatile zzgz<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzb, zza> implements zzgo {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza((zzb) i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza((zzb) j);
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgz<zzb> zzgz = zzg;
                    if (zzgz == null) {
                        synchronized (zzb.class) {
                            zzgz = zzg;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzf);
                                zzg = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzf = zzb;
            zzfe.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzc extends zzfe<zzc, zza> implements zzgo {
        private static final zzc zzi;
        private static volatile zzgz<zzc> zzj;
        private int zzc;
        private zzfn<zze> zzd = zzbp();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzc, zza> implements zzgo {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) i, (int) zze);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) i, (int) ((zze) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) ((zze) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) iterable);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb((zzc) i);
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) str);
                return this;
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zzc) j);
                return this;
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb((zzc) j);
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final zze zza(int i) {
            return this.zzd.get(i);
        }

        private final void zzl() {
            if (!this.zzd.zza()) {
                this.zzd = zzfe.zza(this.zzd);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i, zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzdm.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm() {
            this.zzd = zzbp();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        public static zza zzj() {
            return (zza) zzi.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgz<zzc> zzgz = zzj;
                    if (zzgz == null) {
                        synchronized (zzc.class) {
                            zzgz = zzj;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzi);
                                zzj = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzfe.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzd extends zzfe<zzd, zza> implements zzgo {
        private static final zzd zzf;
        private static volatile zzgz<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzd, zza> implements zzgo {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzd) str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzd) j);
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgz<zzd> zzgz = zzg;
                    if (zzgz == null) {
                        synchronized (zzd.class) {
                            zzgz = zzg;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzf);
                                zzg = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzfe.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zze extends zzfe<zze, zza> implements zzgo {
        private static final zze zzj;
        private static volatile zzgz<zze> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;
        private zzfn<zze> zzi = zzbp();

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zze, zza> implements zzgo {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza((zze) str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb((zze) str);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzm();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza((zze) j);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzn();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zza((zze) d);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzn() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        public final boolean zzg() {
            return (this.zzc & 16) != 0;
        }

        public final double zzh() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        public final List<zze> zzi() {
            return this.zzi;
        }

        public final int zzj() {
            return this.zzi.size();
        }

        public static zza zzk() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zze.class});
                case 4:
                    return zzj;
                case 5:
                    zzgz<zze> zzgz = zzk;
                    if (zzgz == null) {
                        synchronized (zze.class) {
                            zzgz = zzk;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzj);
                                zzk = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzfe.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzf extends zzfe<zzf, zza> implements zzgo {
        private static final zzf zzd;
        private static volatile zzgz<zzf> zze;
        private zzfn<zzg> zzc = zzbp();

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzf, zza> implements zzgo {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzf) ((zzg) ((zzfe) zza.zzv())));
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return this.zzc.get(0);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzg zzg) {
            zzg.getClass();
            if (!this.zzc.zza()) {
                this.zzc = zzfe.zza(this.zzc);
            }
            this.zzc.add(zzg);
        }

        public static zza zzb() {
            return (zza) zzd.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzgz<zzf> zzgz = zze;
                    if (zzgz == null) {
                        synchronized (zzf.class) {
                            zzgz = zze;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzd);
                                zze = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzf zzf = new zzf();
            zzd = zzf;
            zzfe.zza(zzf.class, zzf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzg extends zzfe<zzg, zza> implements zzgo {
        private static final zzg zzav;
        private static volatile zzgz<zzg> zzaw;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzfn<zza> zzae = zzbp();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzfl zzar = zzbn();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private int zzc;
        private int zzd;
        private int zze;
        private zzfn<zzc> zzf = zzbp();
        private zzfn<zzk> zzg = zzbp();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzg, zza> implements zzgo {
            private zza() {
                super(zzg.zzav);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd((zzg) 1);
                return this;
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) i, (int) ((zzc) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) ((zzc) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) iterable);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbt();
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze((zzg) i);
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) i, (int) zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) ((zzk) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb((zzg) iterable);
                return this;
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf((zzg) i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) j);
                return this;
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb((zzg) j);
                return this;
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc((zzg) j);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd((zzg) j);
                return this;
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbv();
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze((zzg) j);
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbw();
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb((zzg) str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc((zzg) str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd((zzg) str);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg((zzg) i);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze((zzg) str);
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf((zzg) str);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg((zzg) str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf((zzg) j);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg((zzg) j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh((zzg) str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) z);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi((zzg) str);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh((zzg) j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh((zzg) i);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj((zzg) str);
                return this;
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final String zzl() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk((zzg) str);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb((zzg) z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc((zzg) iterable);
                return this;
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzby();
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl((zzg) str);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi((zzg) i);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi((zzg) j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj((zzg) j);
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn(null);
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj((zzg) i);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zza(zzh.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzg) ((zzh) ((zzfe) zza.zzv())));
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd((zzg) iterable);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk((zzg) j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl((zzg) j);
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzbe();
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(int i) {
            this.zzc |= 1;
            this.zze = i;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        private final void zzbs() {
            if (!this.zzf.zza()) {
                this.zzf = zzfe.zza(this.zzf);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzbs();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzc zzc2) {
            zzc2.getClass();
            zzbs();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends zzc> iterable) {
            zzbs();
            zzdm.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbt() {
            this.zzf = zzbp();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(int i) {
            zzbs();
            this.zzf.remove(i);
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final zzk zzb(int i) {
            return this.zzg.get(i);
        }

        private final void zzbu() {
            if (!this.zzg.zza()) {
                this.zzg = zzfe.zza(this.zzg);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(int i, zzk zzk2) {
            zzk2.getClass();
            zzbu();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzk zzk2) {
            zzk2.getClass();
            zzbu();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(Iterable<? extends zzk> iterable) {
            zzbu();
            zzdm.zza(iterable, this.zzg);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(int i) {
            zzbu();
            this.zzg.remove(i);
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbv() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbw() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        public final String zzq() {
            return this.zzm;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        public final String zzr() {
            return this.zzn;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        public final String zzs() {
            return this.zzo;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        public final String zzt() {
            return this.zzp;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        public final String zzw() {
            return this.zzr;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        public final String zzx() {
            return this.zzs;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        public final String zzy() {
            return this.zzt;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        public final String zzad() {
            return this.zzw;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        public final String zzag() {
            return this.zzy;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        public final String zzal() {
            return this.zzab;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbx() {
            this.zzc &= -2097153;
            this.zzab = zzav.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzk(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(Iterable<? extends zza> iterable) {
            if (!this.zzae.zza()) {
                this.zzae = zzfe.zza(this.zzae);
            }
            zzdm.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzby() {
            this.zzae = zzbp();
        }

        public final String zzaq() {
            return this.zzaf;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzi(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        public final String zzat() {
            return this.zzaj;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm(String str) {
            str.getClass();
            this.zzc |= 268435456;
            this.zzaj = str;
        }

        public final boolean zzau() {
            return (this.zzc & 536870912) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzi(long j) {
            this.zzc |= 536870912;
            this.zzak = j;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzj(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        public final String zzay() {
            return this.zzam;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzbz() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzav.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzba() {
            return this.zzao;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        public final String zzbb() {
            return this.zzap;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(Iterable<? extends Integer> iterable) {
            if (!this.zzar.zza()) {
                zzfl zzfl = this.zzar;
                int size = zzfl.size();
                this.zzar = zzfl.zzb(size == 0 ? 10 : size << 1);
            }
            zzdm.zza(iterable, this.zzar);
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        public final String zzbe() {
            return this.zzau;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        public static zza zzbf() {
            return (zza) zzav.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%2\b&", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    zzgz<zzg> zzgz = zzaw;
                    if (zzgz == null) {
                        synchronized (zzg.class) {
                            zzgz = zzaw;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzav);
                                zzaw = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzav = zzg2;
            zzfe.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzh extends zzfe<zzh, zza> implements zzgo {
        private static final zzh zzf;
        private static volatile zzgz<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzfn<zzd> zze = zzbp();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public enum zzb implements zzfg {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzfj<zzb> zzc = new zzbt();
            private final int zzd;

            @Override // com.google.android.gms.internal.measurement.zzfg
            public final int zza() {
                return this.zzd;
            }

            public static zzb zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzfi zzb() {
                return zzbu.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            private zzb(int i) {
                this.zzd = i;
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzh, zza> implements zzgo {
            private zza() {
                super(zzh.zzf);
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzh) ((zzd) ((zzfe) zza.zzv())));
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zzd zzd2) {
            zzd2.getClass();
            if (!this.zze.zza()) {
                this.zze = zzfe.zza(this.zze);
            }
            this.zze.add(zzd2);
        }

        public static zza zza() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzgz<zzh> zzgz = zzg;
                    if (zzgz == null) {
                        synchronized (zzh.class) {
                            zzgz = zzg;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzf);
                                zzg = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzfe.zza(zzh.class, zzh);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzi extends zzfe<zzi, zza> implements zzgo {
        private static final zzi zzg;
        private static volatile zzgz<zzi> zzh;
        private zzfk zzc = zzbo();
        private zzfk zzd = zzbo();
        private zzfn<zzb> zze = zzbp();
        private zzfn<zzj> zzf = zzbp();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzi, zza> implements zzgo {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza((zzi) iterable);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb((zzi) iterable);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc((zzi) iterable);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd((zzi) i);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd((zzi) iterable);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends Long> iterable) {
            if (!this.zzc.zza()) {
                this.zzc = zzfe.zza(this.zzc);
            }
            zzdm.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzl() {
            this.zzc = zzbo();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(Iterable<? extends Long> iterable) {
            if (!this.zzd.zza()) {
                this.zzd = zzfe.zza(this.zzd);
            }
            zzdm.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm() {
            this.zzd = zzbo();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final zzb zza(int i) {
            return this.zze.get(i);
        }

        private final void zzn() {
            if (!this.zze.zza()) {
                this.zze = zzfe.zza(this.zze);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzdm.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        public final zzj zzb(int i) {
            return this.zzf.get(i);
        }

        private final void zzo() {
            if (!this.zzf.zza()) {
                this.zzf = zzfe.zza(this.zzf);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzdm.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        public static zza zzi() {
            return (zza) zzg.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzgz<zzi> zzgz = zzh;
                    if (zzgz == null) {
                        synchronized (zzi.class) {
                            zzgz = zzh;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzg);
                                zzh = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzi zzj() {
            return zzg;
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzfe.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzj extends zzfe<zzj, zza> implements zzgo {
        private static final zzj zzf;
        private static volatile zzgz<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzfk zze = zzbo();

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzj, zza> implements zzgo {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza((zzj) j);
                return this;
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza((zzj) iterable);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzh();
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        private final void zzg() {
            if (!this.zze.zza()) {
                this.zze = zzfe.zza(this.zze);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            zzg();
            this.zze.zza(j);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(Iterable<? extends Long> iterable) {
            zzg();
            zzdm.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzh() {
            this.zze = zzbo();
        }

        public static zza zze() {
            return (zza) zzf.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgz<zzj> zzgz = zzg;
                    if (zzgz == null) {
                        synchronized (zzj.class) {
                            zzgz = zzg;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzf);
                                zzg = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzj zzj = new zzj();
            zzf = zzj;
            zzfe.zza(zzj.class, zzj);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
    public static final class zzk extends zzfe<zzk, zza> implements zzgo {
        private static final zzk zzj;
        private static volatile zzgz<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.2.2 */
        public static final class zza extends zzfe.zza<zzk, zza> implements zzgo {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb((zzk) str);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb((zzk) j);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzk) d);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }

            /* synthetic */ zza(zzbr zzbr) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzn() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        public static zza zzj() {
            return (zza) zzj.zzbk();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfe
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbr.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgz<zzk> zzgz = zzk;
                    if (zzgz == null) {
                        synchronized (zzk.class) {
                            zzgz = zzk;
                            if (zzgz == null) {
                                zzgz = new zzfe.zzc<>(zzj);
                                zzk = zzgz;
                            }
                        }
                    }
                    return zzgz;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzfe.zza(zzk.class, zzk2);
        }
    }
}
