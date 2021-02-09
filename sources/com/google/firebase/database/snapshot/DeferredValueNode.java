package com.google.firebase.database.snapshot;

import com.google.firebase.database.snapshot.LeafNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class DeferredValueNode extends LeafNode<DeferredValueNode> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<Object, Object> value;

    public DeferredValueNode(Map<Object, Object> value2, Node priority) {
        super(priority);
        this.value = value2;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(Node.HashVersion version) {
        return getPriorityHash(version) + "deferredValue:" + this.value;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public DeferredValueNode updatePriority(Node priority) {
        return new DeferredValueNode(this.value, priority);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.database.snapshot.LeafNode
    public LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.DeferredValue;
    }

    /* access modifiers changed from: protected */
    public int compareLeafValues(DeferredValueNode other) {
        return 0;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object other) {
        if (!(other instanceof DeferredValueNode)) {
            return false;
        }
        DeferredValueNode otherDeferredValueNode = (DeferredValueNode) other;
        if (!this.value.equals(otherDeferredValueNode.value) || !this.priority.equals(otherDeferredValueNode.priority)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return this.value.hashCode() + this.priority.hashCode();
    }
}
