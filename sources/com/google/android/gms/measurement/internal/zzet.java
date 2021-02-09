package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public interface zzet extends IInterface {
    List<zzkq> zza(zzm zzm, boolean z) throws RemoteException;

    List<zzv> zza(String str, String str2, zzm zzm) throws RemoteException;

    List<zzv> zza(String str, String str2, String str3) throws RemoteException;

    List<zzkq> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzkq> zza(String str, String str2, boolean z, zzm zzm) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(zzan zzan, zzm zzm) throws RemoteException;

    void zza(zzan zzan, String str, String str2) throws RemoteException;

    void zza(zzkq zzkq, zzm zzm) throws RemoteException;

    void zza(zzm zzm) throws RemoteException;

    void zza(zzv zzv) throws RemoteException;

    void zza(zzv zzv, zzm zzm) throws RemoteException;

    byte[] zza(zzan zzan, String str) throws RemoteException;

    void zzb(zzm zzm) throws RemoteException;

    String zzc(zzm zzm) throws RemoteException;

    void zzd(zzm zzm) throws RemoteException;
}
