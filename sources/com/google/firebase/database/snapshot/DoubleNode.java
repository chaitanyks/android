package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class DoubleNode extends LeafNode<DoubleNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Double value;

    public DoubleNode(Double value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion version) {
        return (getPriorityHash(version) + "number:") + Utilities.doubleToHashString(this.value.doubleValue());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DoubleNode updatePriority(Node priority) {
        return new DoubleNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.Number;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(DoubleNode other) {
        return this.value.compareTo(other.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object other) {
        if (!(other instanceof DoubleNode)) {
            return false;
        }
        DoubleNode otherDoubleNode = (DoubleNode) other;
        if (!this.value.equals(otherDoubleNode.value) || !this.priority.equals(otherDoubleNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}
