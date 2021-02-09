package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public interface Predicate<T> {
    public static final Predicate<Object> TRUE = new Predicate<Object>() {
        /* class com.google.firebase.database.core.utilities.Predicate.AnonymousClass1 */

        @Override // com.google.firebase.database.core.utilities.Predicate
        public boolean evaluate(Object object) {
            return true;
        }
    };

    boolean evaluate(T t);
}
