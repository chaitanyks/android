package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public abstract class AbstractComponentContainer implements ComponentContainer {
    AbstractComponentContainer() {
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> anInterface) {
        Provider<T> provider = getProvider(anInterface);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Set<T> setOf(Class<T> anInterface) {
        return setOfProvider(anInterface).get();
    }
}
