package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public final class zzhb {
    private static final zzhb zza = new zzhb();
    private final zzhe zzb = new zzgd();
    private final ConcurrentMap<Class<?>, zzhf<?>> zzc = new ConcurrentHashMap();

    public static zzhb zza() {
        return zza;
    }

    public final <T> zzhf<T> zza(Class<T> cls) {
        zzfh.zza((Object) cls, "messageType");
        zzhf<T> zzhf = (zzhf<T>) this.zzc.get(cls);
        if (zzhf != null) {
            return zzhf;
        }
        zzhf<T> zza2 = this.zzb.zza(cls);
        zzfh.zza((Object) cls, "messageType");
        zzfh.zza((Object) zza2, "schema");
        zzhf<T> zzhf2 = (zzhf<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzhf2 != null ? zzhf2 : zza2;
    }

    public final <T> zzhf<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzhb() {
    }
}
