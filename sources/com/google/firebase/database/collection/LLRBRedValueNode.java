package com.google.firebase.database.collection;

import com.google.firebase.database.collection.LLRBNode;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
public class LLRBRedValueNode<K, V> extends LLRBValueNode<K, V> {
    LLRBRedValueNode(K key, V value) {
        super(key, value, LLRBEmptyNode.getInstance(), LLRBEmptyNode.getInstance());
    }

    LLRBRedValueNode(K key, V value, LLRBNode<K, V> left, LLRBNode<K, V> right) {
        super(key, value, left, right);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBNode.Color getColor() {
        return LLRBNode.Color.RED;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public boolean isRed() {
        return true;
    }

    @Override // com.google.firebase.database.collection.LLRBNode
    public int size() {
        return getLeft().size() + 1 + getRight().size();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.database.collection.LLRBValueNode
    public LLRBValueNode<K, V> copy(K key, V value, LLRBNode<K, V> left, LLRBNode<K, V> right) {
        return new LLRBRedValueNode(key == null ? getKey() : key, value == null ? getValue() : value, left == null ? getLeft() : left, right == null ? getRight() : right);
    }
}
