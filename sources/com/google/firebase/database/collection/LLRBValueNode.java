package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {
    private final K key;
    private LLRBNode<K, V> left;
    private final LLRBNode<K, V> right;
    private final V value;

    /* access modifiers changed from: protected */
    public abstract LLRBValueNode<K, V> copy(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    /* access modifiers changed from: protected */
    public abstract LLRBNode.Color getColor();

    private static LLRBNode.Color oppositeColor(LLRBNode node) {
        return node.isRed() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
    }

    LLRBValueNode(K key2, V value2, LLRBNode<K, V> left2, LLRBNode<K, V> right2) {
        this.key = key2;
        this.value = value2;
        this.left = left2 == null ? LLRBEmptyNode.getInstance() : left2;
        this.right = right2 == null ? LLRBEmptyNode.getInstance() : right2;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getLeft() {
        return this.left;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getRight() {
        return this.right;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public K getKey() {
        return this.key;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public V getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBValueNode<K, V> copy(K key2, V value2, LLRBNode.Color color, LLRBNode<K, V> left2, LLRBNode<K, V> right2) {
        K newKey = key2 == null ? this.key : key2;
        V newValue = value2 == null ? this.value : value2;
        LLRBNode<K, V> newLeft = left2 == null ? this.left : left2;
        LLRBNode<K, V> newRight = right2 == null ? this.right : right2;
        if (color == LLRBNode.Color.RED) {
            return new LLRBRedValueNode(newKey, newValue, newLeft, newRight);
        }
        return new LLRBBlackValueNode(newKey, newValue, newLeft, newRight);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> insert(K key2, V value2, Comparator<K> comparator) {
        LLRBValueNode<K, V> n;
        int cmp = comparator.compare(key2, this.key);
        if (cmp < 0) {
            n = copy(null, null, this.left.insert(key2, value2, comparator), null);
        } else if (cmp == 0) {
            n = copy(key2, value2, null, null);
        } else {
            n = copy(null, null, null, this.right.insert(key2, value2, comparator));
        }
        return n.fixUp();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> remove(K key2, Comparator<K> comparator) {
        LLRBValueNode<K, V> n;
        LLRBValueNode<K, V> n2 = this;
        if (comparator.compare(key2, n2.key) < 0) {
            if (!n2.left.isEmpty() && !n2.left.isRed() && !((LLRBValueNode) n2.left).left.isRed()) {
                n2 = n2.moveRedLeft();
            }
            n = n2.copy(null, null, n2.left.remove(key2, comparator), null);
        } else {
            if (n2.left.isRed()) {
                n2 = n2.rotateRight();
            }
            if (!n2.right.isEmpty() && !n2.right.isRed() && !((LLRBValueNode) n2.right).left.isRed()) {
                n2 = n2.moveRedRight();
            }
            if (comparator.compare(key2, n2.key) == 0) {
                if (n2.right.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                LLRBNode<K, V> smallest = n2.right.getMin();
                n2 = n2.copy(smallest.getKey(), smallest.getValue(), null, ((LLRBValueNode) n2.right).removeMin());
            }
            n = n2.copy(null, null, null, n2.right.remove(key2, comparator));
        }
        return n.fixUp();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMin() {
        if (this.left.isEmpty()) {
            return this;
        }
        return this.left.getMin();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public LLRBNode<K, V> getMax() {
        if (this.right.isEmpty()) {
            return this;
        }
        return this.right.getMax();
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> visitor) {
        this.left.inOrderTraversal(visitor);
        visitor.visitEntry(this.key, this.value);
        this.right.inOrderTraversal(visitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> visitor) {
        if (!this.left.shortCircuitingInOrderTraversal(visitor) || !visitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.right.shortCircuitingInOrderTraversal(visitor);
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> visitor) {
        if (!this.right.shortCircuitingReverseOrderTraversal(visitor) || !visitor.shouldContinue(this.key, this.value)) {
            return false;
        }
        return this.left.shortCircuitingReverseOrderTraversal(visitor);
    }

    /* access modifiers changed from: package-private */
    public void setLeft(LLRBNode<K, V> left2) {
        this.left = left2;
    }

    private LLRBNode<K, V> removeMin() {
        if (this.left.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        LLRBValueNode<K, V> n = this;
        if (!n.getLeft().isRed() && !n.getLeft().getLeft().isRed()) {
            n = n.moveRedLeft();
        }
        return n.copy(null, null, ((LLRBValueNode) n.left).removeMin(), null).fixUp();
    }

    private LLRBValueNode<K, V> moveRedLeft() {
        LLRBValueNode<K, V> n = colorFlip();
        if (n.getRight().getLeft().isRed()) {
            return n.copy(null, null, null, ((LLRBValueNode) n.getRight()).rotateRight()).rotateLeft().colorFlip();
        }
        return n;
    }

    private LLRBValueNode<K, V> moveRedRight() {
        LLRBValueNode<K, V> n = colorFlip();
        if (n.getLeft().getLeft().isRed()) {
            return n.rotateRight().colorFlip();
        }
        return n;
    }

    private LLRBValueNode<K, V> fixUp() {
        LLRBValueNode<K, V> n = this;
        if (n.right.isRed() && !n.left.isRed()) {
            n = n.rotateLeft();
        }
        if (n.left.isRed() && ((LLRBValueNode) n.left).left.isRed()) {
            n = n.rotateRight();
        }
        if (!n.left.isRed() || !n.right.isRed()) {
            return n;
        }
        return n.colorFlip();
    }

    private LLRBValueNode<K, V> rotateLeft() {
        return (LLRBValueNode) this.right.copy(null, null, getColor(), copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) null, (LLRBNode) ((LLRBValueNode) this.right).left), null);
    }

    private LLRBValueNode<K, V> rotateRight() {
        return (LLRBValueNode) this.left.copy(null, null, getColor(), null, copy((Object) null, (Object) null, LLRBNode.Color.RED, (LLRBNode) ((LLRBValueNode) this.left).right, (LLRBNode) null));
    }

    private LLRBValueNode<K, V> colorFlip() {
        LLRBNode<K, V> lLRBNode = this.left;
        LLRBNode<K, V> newLeft = lLRBNode.copy(null, null, oppositeColor(lLRBNode), null, null);
        LLRBNode<K, V> lLRBNode2 = this.right;
        return copy((Object) null, (Object) null, oppositeColor(this), (LLRBNode) newLeft, (LLRBNode) lLRBNode2.copy(null, null, oppositeColor(lLRBNode2), null, null));
    }
}
