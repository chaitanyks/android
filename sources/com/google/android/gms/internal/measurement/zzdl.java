package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.2 */
public abstract class zzdl<MessageType extends zzdm<MessageType, BuilderType>, BuilderType extends zzdl<MessageType, BuilderType>> implements zzgp {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzei zzei, zzer zzer) throws IOException;

    /* renamed from: zzp */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzfm {
        try {
            zzei zza = zzei.zza(bArr, 0, i2, false);
            zza(zza, zzer.zza());
            zza.zza(0);
            return this;
        } catch (zzfm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzer zzer) throws zzfm {
        try {
            zzei zza = zzei.zza(bArr, 0, i2, false);
            zza(zza, zzer);
            zza.zza(0);
            return this;
        } catch (zzfm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzdl<MessageType extends com.google.android.gms.internal.measurement.zzdm<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.zzdl<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzgp
    public final /* synthetic */ zzgp zza(zzgm zzgm) {
        if (h_().getClass().isInstance(zzgm)) {
            return zza((zzdm) zzgm);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final /* synthetic */ zzgp zza(byte[] bArr, zzer zzer) throws zzfm {
        return zza(bArr, 0, bArr.length, zzer);
    }

    @Override // com.google.android.gms.internal.measurement.zzgp
    public final /* synthetic */ zzgp zza(byte[] bArr) throws zzfm {
        return zza(bArr, 0, bArr.length);
    }
}
