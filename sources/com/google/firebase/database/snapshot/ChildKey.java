package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class ChildKey implements Comparable<ChildKey> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ChildKey INFO_CHILD_KEY = new ChildKey(".info");
    private static final ChildKey MAX_KEY = new ChildKey("[MAX_KEY]");
    private static final ChildKey MIN_KEY = new ChildKey("[MIN_KEY]");
    private static final ChildKey PRIORITY_CHILD_KEY = new ChildKey(".priority");
    private final String key;

    public static ChildKey getMinName() {
        return MIN_KEY;
    }

    public static ChildKey getMaxName() {
        return MAX_KEY;
    }

    public static ChildKey getPriorityKey() {
        return PRIORITY_CHILD_KEY;
    }

    public static ChildKey getInfoKey() {
        return INFO_CHILD_KEY;
    }

    private ChildKey(String key2) {
        this.key = key2;
    }

    public String asString() {
        return this.key;
    }

    public boolean isPriorityChildName() {
        return equals(PRIORITY_CHILD_KEY);
    }

    /* access modifiers changed from: protected */
    public boolean isInt() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int intValue() {
        return 0;
    }

    public int compareTo(ChildKey other) {
        ChildKey childKey;
        if (this == other) {
            return 0;
        }
        ChildKey childKey2 = MIN_KEY;
        if (this == childKey2 || other == (childKey = MAX_KEY)) {
            return -1;
        }
        if (other == childKey2 || this == childKey) {
            return 1;
        }
        if (isInt()) {
            if (!other.isInt()) {
                return -1;
            }
            int cmp = Utilities.compareInts(intValue(), other.intValue());
            return cmp == 0 ? Utilities.compareInts(this.key.length(), other.key.length()) : cmp;
        } else if (other.isInt()) {
            return 1;
        } else {
            return this.key.compareTo(other.key);
        }
    }

    public String toString() {
        return "ChildKey(\"" + this.key + "\")";
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChildKey)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.key.equals(((ChildKey) obj).key);
    }

    public static ChildKey fromString(String key2) {
        Integer intValue = Utilities.tryParseInt(key2);
        if (intValue != null) {
            return new IntegerChildKey(key2, intValue.intValue());
        }
        if (key2.equals(".priority")) {
            return PRIORITY_CHILD_KEY;
        }
        return new ChildKey(key2);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class IntegerChildKey extends ChildKey {
        private final int intValue;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.firebase.database.snapshot.ChildKey, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ChildKey childKey) {
            return ChildKey.super.compareTo(childKey);
        }

        IntegerChildKey(String name, int intValue2) {
            super(name);
            this.intValue = intValue2;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.firebase.database.snapshot.ChildKey
        public boolean isInt() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.firebase.database.snapshot.ChildKey
        public int intValue() {
            return this.intValue;
        }

        @Override // com.google.firebase.database.snapshot.ChildKey
        public String toString() {
            return "IntegerChildName(\"" + ((ChildKey) this).key + "\")";
        }
    }
}
