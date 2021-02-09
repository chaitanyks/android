package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    Lazy(T instance2) {
        this.instance = instance2;
    }

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        Object result = (T) this.instance;
        if (result == UNINITIALIZED) {
            synchronized (this) {
                result = this.instance;
                if (result == UNINITIALIZED) {
                    result = (T) this.provider.get();
                    this.instance = result;
                    this.provider = null;
                }
            }
        }
        return (T) result;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }
}
