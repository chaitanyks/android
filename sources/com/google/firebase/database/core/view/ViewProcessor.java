package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class ViewProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE = new NodeFilter.CompleteChildSource() {
        /* class com.google.firebase.database.core.view.ViewProcessor.AnonymousClass1 */

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            return null;
        }
    };
    private final NodeFilter filter;

    public ViewProcessor(NodeFilter filter2) {
        this.filter = filter2;
    }

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache2, List<Change> changes2) {
            this.viewCache = viewCache2;
            this.changes = changes2;
        }
    }

    public ProcessorResult applyOperation(ViewCache oldViewCache, Operation operation, WriteTreeRef writesCache, Node optCompleteCache) {
        ViewCache newViewCache;
        ChildChangeAccumulator accumulator = new ChildChangeAccumulator();
        int i = AnonymousClass2.$SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[operation.getType().ordinal()];
        if (i == 1) {
            Overwrite overwrite = (Overwrite) operation;
            if (overwrite.getSource().isFromUser()) {
                newViewCache = applyUserOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = applyServerOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, overwrite.getSource().isTagged() || (oldViewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty()), accumulator);
            }
        } else if (i == 2) {
            Merge merge = (Merge) operation;
            if (merge.getSource().isFromUser()) {
                newViewCache = applyUserMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = applyServerMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, merge.getSource().isTagged() || oldViewCache.getServerCache().isFiltered(), accumulator);
            }
        } else if (i == 3) {
            AckUserWrite ackUserWrite = (AckUserWrite) operation;
            if (!ackUserWrite.isRevert()) {
                newViewCache = ackUserWrite(oldViewCache, ackUserWrite.getPath(), ackUserWrite.getAffectedTree(), writesCache, optCompleteCache, accumulator);
            } else {
                newViewCache = revertUserWrite(oldViewCache, ackUserWrite.getPath(), writesCache, optCompleteCache, accumulator);
            }
        } else if (i == 4) {
            newViewCache = listenComplete(oldViewCache, operation.getPath(), writesCache, optCompleteCache, accumulator);
        } else {
            throw new AssertionError("Unknown operation: " + operation.getType());
        }
        List<Change> changes = new ArrayList<>(accumulator.getChanges());
        maybeAddValueEvent(oldViewCache, newViewCache, changes);
        return new ProcessorResult(newViewCache, changes);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.core.view.ViewProcessor$2  reason: invalid class name */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType;

        static {
            int[] iArr = new int[Operation.OperationType.values().length];
            $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType = iArr;
            try {
                iArr[Operation.OperationType.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[Operation.OperationType.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private void maybeAddValueEvent(ViewCache oldViewCache, ViewCache newViewCache, List<Change> accumulator) {
        CacheNode eventSnap = newViewCache.getEventCache();
        if (eventSnap.isFullyInitialized()) {
            boolean isLeafOrEmpty = eventSnap.getNode().isLeafNode() || eventSnap.getNode().isEmpty();
            if (!accumulator.isEmpty() || !oldViewCache.getEventCache().isFullyInitialized() || ((isLeafOrEmpty && !eventSnap.getNode().equals(oldViewCache.getCompleteEventSnap())) || !eventSnap.getNode().getPriority().equals(oldViewCache.getCompleteEventSnap().getPriority()))) {
                accumulator.add(Change.valueChange(eventSnap.getIndexedNode()));
            }
        }
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path changePath, WriteTreeRef writesCache, NodeFilter.CompleteChildSource source, ChildChangeAccumulator accumulator) {
        IndexedNode newEventCache;
        Node serverNode;
        Node newEventChild;
        IndexedNode newEventCache2;
        Node serverCache;
        CacheNode oldEventSnap = viewCache.getEventCache();
        if (writesCache.shadowingWrite(changePath) != null) {
            return viewCache;
        }
        if (changePath.isEmpty()) {
            if (viewCache.getServerCache().isFiltered()) {
                Node serverCache2 = viewCache.getCompleteServerSnap();
                serverCache = writesCache.calcCompleteEventChildren(serverCache2 instanceof ChildrenNode ? serverCache2 : EmptyNode.Empty());
            } else {
                serverCache = writesCache.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            newEventCache = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(serverCache, this.filter.getIndex()), accumulator);
        } else {
            ChildKey childKey = changePath.getFront();
            if (childKey.isPriorityChildName()) {
                Node updatedPriority = writesCache.calcEventCacheAfterServerOverwrite(changePath, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                if (updatedPriority != null) {
                    newEventCache2 = this.filter.updatePriority(oldEventSnap.getIndexedNode(), updatedPriority);
                } else {
                    newEventCache2 = oldEventSnap.getIndexedNode();
                }
                newEventCache = newEventCache2;
            } else {
                Path childChangePath = changePath.popFront();
                if (oldEventSnap.isCompleteForChild(childKey)) {
                    Node eventChildUpdate = writesCache.calcEventCacheAfterServerOverwrite(changePath, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                    if (eventChildUpdate != null) {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, eventChildUpdate);
                    } else {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey);
                    }
                    serverNode = newEventChild;
                } else {
                    serverNode = writesCache.calcCompleteChild(childKey, viewCache.getServerCache());
                }
                if (serverNode != null) {
                    newEventCache = this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, serverNode, childChangePath, source, accumulator);
                } else {
                    newEventCache = oldEventSnap.getIndexedNode();
                }
            }
        }
        return viewCache.updateEventSnap(newEventCache, oldEventSnap.isFullyInitialized() || changePath.isEmpty(), this.filter.filtersNodes());
    }

    /* JADX INFO: Multiple debug info for r0v12 com.google.firebase.database.snapshot.IndexedNode: [D('childKey' com.google.firebase.database.snapshot.ChildKey), D('newServerCache' com.google.firebase.database.snapshot.IndexedNode)] */
    private ViewCache applyServerOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        IndexedNode newServerCache;
        CacheNode oldServerSnap = oldViewCache.getServerCache();
        NodeFilter serverFilter = this.filter;
        if (!filterServerNode) {
            serverFilter = serverFilter.getIndexedFilter();
        }
        boolean z = true;
        if (changePath.isEmpty()) {
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), IndexedNode.from(changedSnap, serverFilter.getIndex()), null);
        } else if (!serverFilter.filtersNodes() || oldServerSnap.isFiltered()) {
            ChildKey childKey = changePath.getFront();
            if (!oldServerSnap.isCompleteForPath(changePath) && changePath.size() > 1) {
                return oldViewCache;
            }
            Path childChangePath = changePath.popFront();
            Node newChildNode = oldServerSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, changedSnap);
            if (childKey.isPriorityChildName()) {
                newServerCache = serverFilter.updatePriority(oldServerSnap.getIndexedNode(), newChildNode);
            } else {
                newServerCache = serverFilter.updateChild(oldServerSnap.getIndexedNode(), childKey, newChildNode, childChangePath, NO_COMPLETE_SOURCE, null);
            }
        } else {
            ChildKey childKey2 = changePath.getFront();
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), oldServerSnap.getIndexedNode().updateChild(childKey2, oldServerSnap.getNode().getImmediateChild(childKey2).updateChild(changePath.popFront(), changedSnap)), null);
        }
        if (!oldServerSnap.isFullyInitialized() && !changePath.isEmpty()) {
            z = false;
        }
        ViewCache newViewCache = oldViewCache.updateServerSnap(newServerCache, z, serverFilter.filtersNodes());
        return generateEventCacheAfterServerEvent(newViewCache, changePath, writesCache, new WriteTreeCompleteChildSource(writesCache, newViewCache, optCompleteCache), accumulator);
    }

    /* JADX INFO: Multiple debug info for r7v8 com.google.firebase.database.core.view.ViewCache: [D('newEventSnap' com.google.firebase.database.snapshot.IndexedNode), D('newViewCache' com.google.firebase.database.core.view.ViewCache)] */
    /* JADX INFO: Multiple debug info for r7v13 com.google.firebase.database.core.view.ViewCache: [D('newEventCache' com.google.firebase.database.snapshot.IndexedNode), D('newViewCache' com.google.firebase.database.core.view.ViewCache)] */
    /* JADX INFO: Multiple debug info for r7v17 com.google.firebase.database.core.view.ViewCache: [D('newIndexed' com.google.firebase.database.snapshot.IndexedNode), D('newViewCache' com.google.firebase.database.core.view.ViewCache)] */
    private ViewCache applyUserOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        Node newChild;
        CacheNode oldEventSnap = oldViewCache.getEventCache();
        NodeFilter.CompleteChildSource source = new WriteTreeCompleteChildSource(writesCache, oldViewCache, optCompleteCache);
        if (changePath.isEmpty()) {
            return oldViewCache.updateEventSnap(this.filter.updateFullNode(oldViewCache.getEventCache().getIndexedNode(), IndexedNode.from(changedSnap, this.filter.getIndex()), accumulator), true, this.filter.filtersNodes());
        }
        ChildKey childKey = changePath.getFront();
        if (childKey.isPriorityChildName()) {
            return oldViewCache.updateEventSnap(this.filter.updatePriority(oldViewCache.getEventCache().getIndexedNode(), changedSnap), oldEventSnap.isFullyInitialized(), oldEventSnap.isFiltered());
        }
        Path childChangePath = changePath.popFront();
        Node oldChild = oldEventSnap.getNode().getImmediateChild(childKey);
        if (childChangePath.isEmpty()) {
            newChild = changedSnap;
        } else {
            Node childNode = source.getCompleteChild(childKey);
            if (childNode == null) {
                newChild = EmptyNode.Empty();
            } else if (!childChangePath.getBack().isPriorityChildName() || !childNode.getChild(childChangePath.getParent()).isEmpty()) {
                newChild = childNode.updateChild(childChangePath, changedSnap);
            } else {
                newChild = childNode;
            }
        }
        if (!oldChild.equals(newChild)) {
            return oldViewCache.updateEventSnap(this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, newChild, childChangePath, source, accumulator), oldEventSnap.isFullyInitialized(), this.filter.filtersNodes());
        }
        return oldViewCache;
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        ViewCache currentViewCache = viewCache;
        Iterator<Map.Entry<Path, Node>> it = changedChildren.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> entry = it.next();
            Path writePath = path.child(entry.getKey());
            if (cacheHasChild(viewCache, writePath.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath, entry.getValue(), writesCache, serverCache, accumulator);
            }
        }
        Iterator<Map.Entry<Path, Node>> it2 = changedChildren.iterator();
        while (it2.hasNext()) {
            Map.Entry<Path, Node> entry2 = it2.next();
            Path writePath2 = path.child(entry2.getKey());
            if (!cacheHasChild(viewCache, writePath2.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath2, entry2.getValue(), writesCache, serverCache, accumulator);
            }
        }
        return currentViewCache;
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        CompoundWrite actualMerge;
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        ViewCache curViewCache = viewCache;
        if (path.isEmpty()) {
            actualMerge = changedChildren;
        } else {
            actualMerge = CompoundWrite.emptyWrite().addWrites(path, changedChildren);
        }
        Node serverNode = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> childCompoundWrites = actualMerge.childCompoundWrites();
        for (Map.Entry<ChildKey, CompoundWrite> childMerge : childCompoundWrites.entrySet()) {
            ChildKey childKey = childMerge.getKey();
            if (serverNode.hasChild(childKey)) {
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey), childMerge.getValue().apply(serverNode.getImmediateChild(childKey)), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        for (Map.Entry<ChildKey, CompoundWrite> childMerge2 : childCompoundWrites.entrySet()) {
            ChildKey childKey2 = childMerge2.getKey();
            boolean isUnknownDeepMerge = !viewCache.getServerCache().isCompleteForChild(childKey2) && childMerge2.getValue().rootWrite() == null;
            if (!serverNode.hasChild(childKey2) && !isUnknownDeepMerge) {
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey2), childMerge2.getValue().apply(serverNode.getImmediateChild(childKey2)), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        return curViewCache;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path ackPath, ImmutableTree<Boolean> affectedTree, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        if (writesCache.shadowingWrite(ackPath) != null) {
            return viewCache;
        }
        boolean filterServerNode = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (affectedTree.getValue() == null) {
            CompoundWrite changedChildren = CompoundWrite.emptyWrite();
            Iterator<Map.Entry<Path, Boolean>> it = affectedTree.iterator();
            CompoundWrite changedChildren2 = changedChildren;
            while (it.hasNext()) {
                Path mergePath = it.next().getKey();
                Path serverCachePath = ackPath.child(mergePath);
                if (serverCache.isCompleteForPath(serverCachePath)) {
                    changedChildren2 = changedChildren2.addWrite(mergePath, serverCache.getNode().getChild(serverCachePath));
                }
            }
            return applyServerMerge(viewCache, ackPath, changedChildren2, writesCache, optCompleteCache, filterServerNode, accumulator);
        } else if ((ackPath.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(ackPath)) {
            return applyServerOverwrite(viewCache, ackPath, serverCache.getNode().getChild(ackPath), writesCache, optCompleteCache, filterServerNode, accumulator);
        } else {
            if (!ackPath.isEmpty()) {
                return viewCache;
            }
            CompoundWrite changedChildren3 = CompoundWrite.emptyWrite();
            CompoundWrite changedChildren4 = changedChildren3;
            for (NamedNode child : serverCache.getNode()) {
                changedChildren4 = changedChildren4.addWrite(child.getName(), child.getNode());
            }
            return applyServerMerge(viewCache, ackPath, changedChildren4, writesCache, optCompleteCache, filterServerNode, accumulator);
        }
    }

    public ViewCache revertUserWrite(ViewCache viewCache, Path path, WriteTreeRef writesCache, Node optCompleteServerCache, ChildChangeAccumulator accumulator) {
        IndexedNode newEventCache;
        IndexedNode oldEventCache;
        ChildChangeAccumulator childChangeAccumulator;
        Node newNode;
        Node newChild;
        ChildChangeAccumulator childChangeAccumulator2;
        if (writesCache.shadowingWrite(path) != null) {
            return viewCache;
        }
        NodeFilter.CompleteChildSource source = new WriteTreeCompleteChildSource(writesCache, viewCache, optCompleteServerCache);
        IndexedNode oldEventCache2 = viewCache.getEventCache().getIndexedNode();
        if (path.isEmpty()) {
            oldEventCache = oldEventCache2;
            childChangeAccumulator = accumulator;
        } else if (path.getFront().isPriorityChildName()) {
            oldEventCache = oldEventCache2;
            childChangeAccumulator = accumulator;
        } else {
            ChildKey childKey = path.getFront();
            Node newChild2 = writesCache.calcCompleteChild(childKey, viewCache.getServerCache());
            if (newChild2 != null || !viewCache.getServerCache().isCompleteForChild(childKey)) {
                newChild = newChild2;
            } else {
                newChild = oldEventCache2.getNode().getImmediateChild(childKey);
            }
            if (newChild != null) {
                newEventCache = this.filter.updateChild(oldEventCache2, childKey, newChild, path.popFront(), source, accumulator);
                childChangeAccumulator2 = accumulator;
            } else if (newChild != null || !viewCache.getEventCache().getNode().hasChild(childKey)) {
                childChangeAccumulator2 = accumulator;
                newEventCache = oldEventCache2;
            } else {
                childChangeAccumulator2 = accumulator;
                newEventCache = this.filter.updateChild(oldEventCache2, childKey, EmptyNode.Empty(), path.popFront(), source, accumulator);
            }
            if (newEventCache.getNode().isEmpty() && viewCache.getServerCache().isFullyInitialized()) {
                Node complete = writesCache.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                if (complete.isLeafNode()) {
                    newEventCache = this.filter.updateFullNode(newEventCache, IndexedNode.from(complete, this.filter.getIndex()), childChangeAccumulator2);
                }
            }
            return viewCache.updateEventSnap(newEventCache, !viewCache.getServerCache().isFullyInitialized() || writesCache.shadowingWrite(Path.getEmptyPath()) != null, this.filter.filtersNodes());
        }
        if (viewCache.getServerCache().isFullyInitialized()) {
            newNode = writesCache.calcCompleteEventCache(viewCache.getCompleteServerSnap());
        } else {
            newNode = writesCache.calcCompleteEventChildren(viewCache.getServerCache().getNode());
        }
        newEventCache = this.filter.updateFullNode(oldEventCache, IndexedNode.from(newNode, this.filter.getIndex()), childChangeAccumulator);
        return viewCache.updateEventSnap(newEventCache, !viewCache.getServerCache().isFullyInitialized() || writesCache.shadowingWrite(Path.getEmptyPath()) != null, this.filter.filtersNodes());
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        CacheNode oldServerNode = viewCache.getServerCache();
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(oldServerNode.getIndexedNode(), oldServerNode.isFullyInitialized() || path.isEmpty(), oldServerNode.isFiltered()), path, writesCache, NO_COMPLETE_SOURCE, accumulator);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class WriteTreeCompleteChildSource implements NodeFilter.CompleteChildSource {
        private final Node optCompleteServerCache;
        private final ViewCache viewCache;
        private final WriteTreeRef writes;

        public WriteTreeCompleteChildSource(WriteTreeRef writes2, ViewCache viewCache2, Node optCompleteServerCache2) {
            this.writes = writes2;
            this.viewCache = viewCache2;
            this.optCompleteServerCache = optCompleteServerCache2;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            CacheNode serverNode;
            CacheNode node = this.viewCache.getEventCache();
            if (node.isCompleteForChild(childKey)) {
                return node.getNode().getImmediateChild(childKey);
            }
            if (this.optCompleteServerCache != null) {
                serverNode = new CacheNode(IndexedNode.from(this.optCompleteServerCache, KeyIndex.getInstance()), true, false);
            } else {
                serverNode = this.viewCache.getServerCache();
            }
            return this.writes.calcCompleteChild(childKey, serverNode);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            Node completeServerData = this.optCompleteServerCache;
            if (completeServerData == null) {
                completeServerData = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(completeServerData, child, reverse, index);
        }
    }
}
