package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    int mActiveCount = 0;
    private volatile Object mData = NOT_SET;
    final Object mDataLock = new Object();
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap<>();
    volatile Object mPendingData = NOT_SET;
    private final Runnable mPostValueRunnable = new Runnable() {
        /* class androidx.lifecycle.LiveData.AnonymousClass1 */

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.LiveData */
        /* JADX WARN: Multi-variable type inference failed */
        public void run() {
            Throwable th;
            synchronized (LiveData.this.mDataLock) {
                try {
                    Object newValue = LiveData.this.mPendingData;
                    try {
                        LiveData.this.mPendingData = LiveData.NOT_SET;
                        LiveData.this.setValue(newValue);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        }
    };
    private int mVersion = -1;

    private void considerNotify(LiveData<T>.ObserverWrapper observer) {
        if (observer.mActive) {
            if (!observer.shouldBeActive()) {
                observer.activeStateChanged(false);
                return;
            }
            int i = observer.mLastVersion;
            int i2 = this.mVersion;
            if (i < i2) {
                observer.mLastVersion = i2;
                observer.mObserver.onChanged((Object) this.mData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchingValue(LiveData<T>.ObserverWrapper initiator) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (initiator == null) {
                Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> iterator = this.mObservers.iteratorWithAdditions();
                while (iterator.hasNext()) {
                    considerNotify(iterator.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(initiator);
                initiator = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void observe(LifecycleOwner owner, Observer<? super T> observer) {
        assertMainThread("observe");
        if (owner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            LiveData<T>.LifecycleBoundObserver wrapper = new LifecycleBoundObserver(owner, observer);
            LiveData<T>.ObserverWrapper existing = this.mObservers.putIfAbsent(observer, wrapper);
            if (existing != null && !existing.isAttachedTo(owner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (existing == null) {
                owner.getLifecycle().addObserver(wrapper);
            }
        }
    }

    public void observeForever(Observer<? super T> observer) {
        assertMainThread("observeForever");
        LiveData<T>.AlwaysActiveObserver wrapper = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper existing = this.mObservers.putIfAbsent(observer, wrapper);
        if (existing != null && (existing instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (existing == null) {
            wrapper.activeStateChanged(true);
        }
    }

    public void removeObserver(Observer<? super T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper removed = this.mObservers.remove(observer);
        if (removed != null) {
            removed.detachObserver();
            removed.activeStateChanged(false);
        }
    }

    public void removeObservers(LifecycleOwner owner) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> entry = it.next();
            if (entry.getValue().isAttachedTo(owner)) {
                removeObserver(entry.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        if (r1 != false) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
        androidx.arch.core.executor.ArchTaskExecutor.getInstance().postToMainThread(r4.mPostValueRunnable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return;
     */
    public void postValue(T value) {
        Throwable th;
        synchronized (this.mDataLock) {
            boolean postTask = false;
            try {
                if (this.mPendingData == NOT_SET) {
                    postTask = true;
                }
                try {
                    this.mPendingData = value;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setValue(T value) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = value;
        dispatchingValue(null);
    }

    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getVersion() {
        return this.mVersion;
    }

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {
        final LifecycleOwner mOwner;

        LifecycleBoundObserver(LifecycleOwner owner, Observer<? super T> observer) {
            super(observer);
            this.mOwner = owner;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.mObserver);
            } else {
                activeStateChanged(shouldBeActive());
            }
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(LifecycleOwner owner) {
            return this.mOwner == owner;
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }
    }

    /* access modifiers changed from: private */
    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion = -1;
        final Observer<? super T> mObserver;

        /* access modifiers changed from: package-private */
        public abstract boolean shouldBeActive();

        ObserverWrapper(Observer<? super T> observer) {
            this.mObserver = observer;
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedTo(LifecycleOwner owner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void detachObserver() {
        }

        /* access modifiers changed from: package-private */
        public void activeStateChanged(boolean newActive) {
            if (newActive != this.mActive) {
                this.mActive = newActive;
                int i = 1;
                boolean wasInactive = LiveData.this.mActiveCount == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.mActiveCount;
                if (!this.mActive) {
                    i = -1;
                }
                liveData.mActiveCount = i2 + i;
                if (wasInactive && this.mActive) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.mActiveCount == 0 && !this.mActive) {
                    LiveData.this.onInactive();
                }
                if (this.mActive) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }
    }

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return true;
        }
    }

    private static void assertMainThread(String methodName) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + methodName + " on a background" + " thread");
        }
    }
}
