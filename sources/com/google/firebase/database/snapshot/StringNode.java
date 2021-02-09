package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class StringNode extends LeafNode<StringNode> {
    private final String value;

    public StringNode(String value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    /* renamed from: com.google.firebase.database.snapshot.StringNode$1  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion;

        static {
            int[] iArr = new int[Node.HashVersion.values().length];
            $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion = iArr;
            try {
                iArr[Node.HashVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion[Node.HashVersion.V2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion version) {
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion[version.ordinal()];
        if (i == 1) {
            return getPriorityHash(version) + "string:" + this.value;
        } else if (i == 2) {
            return getPriorityHash(version) + "string:" + Utilities.stringHashV2Representation(this.value);
        } else {
            throw new IllegalArgumentException("Invalid hash version for string node: " + version);
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public StringNode updatePriority(Node priority) {
        return new StringNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.String;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(StringNode other) {
        return this.value.compareTo(other.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object other) {
        if (!(other instanceof StringNode)) {
            return false;
        }
        StringNode otherStringNode = (StringNode) other;
        if (!this.value.equals(otherStringNode.value) || !this.priority.equals(otherStringNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}
