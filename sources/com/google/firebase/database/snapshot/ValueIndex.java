package com.google.firebase.database.snapshot;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class ValueIndex extends Index {
    private static final ValueIndex INSTANCE = new ValueIndex();

    private ValueIndex() {
    }

    public static ValueIndex getInstance() {
        return INSTANCE;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean isDefinedOn(Node a) {
        return true;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode makePost(ChildKey name, Node value) {
        return new NamedNode(name, value);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public NamedNode maxPost() {
        return new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String getQueryDefinition() {
        return ".value";
    }

    public int compare(NamedNode one, NamedNode two) {
        int indexCmp = one.getNode().compareTo(two.getNode());
        if (indexCmp == 0) {
            return one.getName().compareTo(two.getName());
        }
        return indexCmp;
    }

    public int hashCode() {
        return 4;
    }

    public boolean equals(Object o) {
        return o instanceof ValueIndex;
    }

    public String toString() {
        return "ValueIndex";
    }
}
