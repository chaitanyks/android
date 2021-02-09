package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzgd<V> extends FutureTask<V> implements Comparable<zzgd<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzgc zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgd(zzgc zzgc, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzd = zzgc;
        Preconditions.checkNotNull(str);
        long andIncrement = zzgc.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgc.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgd(zzgc zzgc, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzd = zzgc;
        Preconditions.checkNotNull(str);
        long andIncrement = zzgc.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzgc.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        if (th instanceof zzgb) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzgd zzgd = (zzgd) obj;
        boolean z = this.zza;
        if (z != zzgd.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzgd.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
