package com.google.firebase.iid;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
final class zzae extends zzah<Void> {
    zzae(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final boolean zza() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzah
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza((Object) null);
        } else {
            zza(new zzag(4, "Invalid response to one way request"));
        }
    }
}