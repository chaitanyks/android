package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class LimitedFilter implements NodeFilter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Index index;
    private final int limit;
    private final RangedFilter rangedFilter;
    private final boolean reverse;

    public LimitedFilter(QueryParams params) {
        this.rangedFilter = new RangedFilter(params);
        this.index = params.getIndex();
        this.limit = params.getLimit();
        this.reverse = !params.isViewFromLeft();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateChild(IndexedNode snap, ChildKey key, Node newChild, Path affectedPath, NodeFilter.CompleteChildSource source, ChildChangeAccumulator optChangeAccumulator) {
        if (!this.rangedFilter.matches(new NamedNode(key, newChild))) {
            newChild = EmptyNode.Empty();
        }
        if (snap.getNode().getImmediateChild(key).equals(newChild)) {
            return snap;
        }
        if (snap.getNode().getChildCount() < this.limit) {
            return this.rangedFilter.getIndexedFilter().updateChild(snap, key, newChild, affectedPath, source, optChangeAccumulator);
        }
        return fullLimitUpdateChild(snap, key, newChild, source, optChangeAccumulator);
    }

    private IndexedNode fullLimitUpdateChild(IndexedNode oldIndexed, ChildKey childKey, Node childSnap, NodeFilter.CompleteChildSource source, ChildChangeAccumulator optChangeAccumulator) {
        NamedNode newChildNamedNode = new NamedNode(childKey, childSnap);
        NamedNode windowBoundary = this.reverse ? oldIndexed.getFirstChild() : oldIndexed.getLastChild();
        boolean inRange = this.rangedFilter.matches(newChildNamedNode);
        if (oldIndexed.getNode().hasChild(childKey)) {
            Node oldChildSnap = oldIndexed.getNode().getImmediateChild(childKey);
            NamedNode nextChild = source.getChildAfterChild(this.index, windowBoundary, this.reverse);
            while (nextChild != null && (nextChild.getName().equals(childKey) || oldIndexed.getNode().hasChild(nextChild.getName()))) {
                nextChild = source.getChildAfterChild(this.index, nextChild, this.reverse);
            }
            if (inRange && !childSnap.isEmpty() && (nextChild == null ? 1 : this.index.compare(nextChild, newChildNamedNode, this.reverse)) >= 0) {
                if (optChangeAccumulator != null) {
                    optChangeAccumulator.trackChildChange(Change.childChangedChange(childKey, childSnap, oldChildSnap));
                }
                return oldIndexed.updateChild(childKey, childSnap);
            }
            if (optChangeAccumulator != null) {
                optChangeAccumulator.trackChildChange(Change.childRemovedChange(childKey, oldChildSnap));
            }
            IndexedNode newIndexed = oldIndexed.updateChild(childKey, EmptyNode.Empty());
            if (!(nextChild != null && this.rangedFilter.matches(nextChild))) {
                return newIndexed;
            }
            if (optChangeAccumulator != null) {
                optChangeAccumulator.trackChildChange(Change.childAddedChange(nextChild.getName(), nextChild.getNode()));
            }
            return newIndexed.updateChild(nextChild.getName(), nextChild.getNode());
        } else if (childSnap.isEmpty() || !inRange || this.index.compare(windowBoundary, newChildNamedNode, this.reverse) < 0) {
            return oldIndexed;
        } else {
            if (optChangeAccumulator != null) {
                optChangeAccumulator.trackChildChange(Change.childRemovedChange(windowBoundary.getName(), windowBoundary.getNode()));
                optChangeAccumulator.trackChildChange(Change.childAddedChange(childKey, childSnap));
            }
            return oldIndexed.updateChild(childKey, childSnap).updateChild(windowBoundary.getName(), EmptyNode.Empty());
        }
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updateFullNode(IndexedNode oldSnap, IndexedNode newSnap, ChildChangeAccumulator optChangeAccumulator) {
        IndexedNode filtered;
        int sign;
        NamedNode endPost;
        NamedNode startPost;
        Iterator<NamedNode> iterator;
        if (newSnap.getNode().isLeafNode() || newSnap.getNode().isEmpty()) {
            filtered = IndexedNode.from(EmptyNode.Empty(), this.index);
        } else {
            filtered = newSnap.updatePriority(PriorityUtilities.NullPriority());
            if (this.reverse) {
                iterator = newSnap.reverseIterator();
                startPost = this.rangedFilter.getEndPost();
                endPost = this.rangedFilter.getStartPost();
                sign = -1;
            } else {
                iterator = newSnap.iterator();
                startPost = this.rangedFilter.getStartPost();
                endPost = this.rangedFilter.getEndPost();
                sign = 1;
            }
            int count = 0;
            boolean foundStartPost = false;
            while (iterator.hasNext()) {
                NamedNode next = iterator.next();
                if (!foundStartPost && this.index.compare(startPost, next) * sign <= 0) {
                    foundStartPost = true;
                }
                if (foundStartPost && count < this.limit && this.index.compare(next, endPost) * sign <= 0) {
                    count++;
                } else {
                    filtered = filtered.updateChild(next.getName(), EmptyNode.Empty());
                }
            }
        }
        return this.rangedFilter.getIndexedFilter().updateFullNode(oldSnap, filtered, optChangeAccumulator);
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public IndexedNode updatePriority(IndexedNode oldSnap, Node newPriority) {
        return oldSnap;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public NodeFilter getIndexedFilter() {
        return this.rangedFilter.getIndexedFilter();
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public Index getIndex() {
        return this.index;
    }

    @Override // com.google.firebase.database.core.view.filter.NodeFilter
    public boolean filtersNodes() {
        return true;
    }
}
