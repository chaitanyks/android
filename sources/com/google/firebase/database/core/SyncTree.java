package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class SyncTree {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long SIZE_THRESHOLD_FOR_COMPOUND_HASH = 1024;
    private final Set<QuerySpec> keepSyncedQueries = new HashSet();
    private final ListenProvider listenProvider;
    private final LogWrapper logger;
    private long nextQueryTag = 1;
    private final WriteTree pendingWriteTree = new WriteTree();
    private final PersistenceManager persistenceManager;
    private final Map<QuerySpec, Tag> queryToTagMap = new HashMap();
    private ImmutableTree<SyncPoint> syncPointTree = ImmutableTree.emptyInstance();
    private final Map<Tag, QuerySpec> tagToQueryMap = new HashMap();

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface CompletionListener {
        List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface ListenProvider {
        void startListening(QuerySpec querySpec, Tag tag, ListenHashProvider listenHashProvider, CompletionListener completionListener);

        void stopListening(QuerySpec querySpec, Tag tag);
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public class ListenContainer implements ListenHashProvider, CompletionListener {
        private final Tag tag;
        private final View view;

        public ListenContainer(View view2) {
            this.view = view2;
            this.tag = SyncTree.this.tagForQuery(view2.getQuery());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public CompoundHash getCompoundHash() {
            com.google.firebase.database.snapshot.CompoundHash hash = com.google.firebase.database.snapshot.CompoundHash.fromNode(this.view.getServerCache());
            List<Path> pathPosts = hash.getPosts();
            List<List<String>> posts = new ArrayList<>(pathPosts.size());
            for (Path path : pathPosts) {
                posts.add(path.asList());
            }
            return new CompoundHash(posts, hash.getHashes());
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public String getSimpleHash() {
            return this.view.getServerCache().getHash();
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean shouldIncludeCompoundHash() {
            return NodeSizeEstimator.estimateSerializedNodeSize(this.view.getServerCache()) > SyncTree.SIZE_THRESHOLD_FOR_COMPOUND_HASH;
        }

        @Override // com.google.firebase.database.core.SyncTree.CompletionListener
        public List<? extends Event> onListenComplete(DatabaseError error) {
            if (error == null) {
                QuerySpec query = this.view.getQuery();
                Tag tag2 = this.tag;
                if (tag2 != null) {
                    return SyncTree.this.applyTaggedListenComplete(tag2);
                }
                return SyncTree.this.applyListenComplete(query.getPath());
            }
            LogWrapper logWrapper = SyncTree.this.logger;
            logWrapper.warn("Listen at " + this.view.getQuery().getPath() + " failed: " + error.toString());
            return SyncTree.this.removeAllEventRegistrations(this.view.getQuery(), error);
        }
    }

    public SyncTree(Context context, PersistenceManager persistenceManager2, ListenProvider listenProvider2) {
        this.listenProvider = listenProvider2;
        this.persistenceManager = persistenceManager2;
        this.logger = context.getLogger("SyncTree");
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public List<? extends Event> applyUserOverwrite(final Path path, final Node newDataUnresolved, final Node newData, final long writeId, final boolean visible, final boolean persist) {
        Utilities.hardAssert(visible || !persist, "We shouldn't be persisting non-visible writes.");
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (persist) {
                    SyncTree.this.persistenceManager.saveUserOverwrite(path, newDataUnresolved, writeId);
                }
                SyncTree.this.pendingWriteTree.addOverwrite(path, newData, Long.valueOf(writeId), visible);
                if (!visible) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.USER, path, newData));
            }
        });
    }

    public List<? extends Event> applyUserMerge(final Path path, final CompoundWrite unresolvedChildren, final CompoundWrite children, final long writeId, final boolean persist) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() throws Exception {
                if (persist) {
                    SyncTree.this.persistenceManager.saveUserMerge(path, unresolvedChildren, writeId);
                }
                SyncTree.this.pendingWriteTree.addMerge(path, children, Long.valueOf(writeId));
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.USER, path, children));
            }
        });
    }

    public List<? extends Event> ackUserWrite(final long writeId, final boolean revert, final boolean persist, final Clock serverClock) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                if (persist) {
                    SyncTree.this.persistenceManager.removeUserWrite(writeId);
                }
                UserWriteRecord write = SyncTree.this.pendingWriteTree.getWrite(writeId);
                boolean needToReevaluate = SyncTree.this.pendingWriteTree.removeWrite(writeId);
                if (write.isVisible() && !revert) {
                    ArrayList<Long> excludeThis = new ArrayList<>();
                    excludeThis.add(Long.valueOf(write.getWriteId()));
                    Node existing = SyncTree.this.calcCompleteEventCache(write.getPath(), excludeThis);
                    Map<String, Object> serverValues = ServerValues.generateServerValues(serverClock);
                    if (write.isOverwrite()) {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), existing, serverValues));
                    } else {
                        SyncTree.this.persistenceManager.applyUserWriteToServerCache(write.getPath(), ServerValues.resolveDeferredValueMerge(write.getMerge(), existing, serverValues));
                    }
                }
                if (!needToReevaluate) {
                    return Collections.emptyList();
                }
                ImmutableTree<Boolean> affectedTree = ImmutableTree.emptyInstance();
                if (write.isOverwrite()) {
                    affectedTree = affectedTree.set(Path.getEmptyPath(), true);
                } else {
                    Iterator<Map.Entry<Path, Node>> it = write.getMerge().iterator();
                    while (it.hasNext()) {
                        affectedTree = affectedTree.set(it.next().getKey(), true);
                    }
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(write.getPath(), affectedTree, revert));
            }
        });
    }

    public List<? extends Event> removeAllWrites() {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() throws Exception {
                SyncTree.this.persistenceManager.removeAllUserWrites();
                if (SyncTree.this.pendingWriteTree.purgeAllWrites().isEmpty()) {
                    return Collections.emptyList();
                }
                return SyncTree.this.applyOperationToSyncPoints(new AckUserWrite(Path.getEmptyPath(), new ImmutableTree<>(true), true));
            }
        });
    }

    public List<? extends Event> applyServerOverwrite(final Path path, final Node newData) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.updateServerCache(QuerySpec.defaultQueryAtPath(path), newData);
                return SyncTree.this.applyOperationToSyncPoints(new Overwrite(OperationSource.SERVER, path, newData));
            }
        });
    }

    public List<? extends Event> applyServerMerge(final Path path, final Map<Path, Node> changedChildren) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CompoundWrite merge = CompoundWrite.fromPathMerge(changedChildren);
                SyncTree.this.persistenceManager.updateServerCache(path, merge);
                return SyncTree.this.applyOperationToSyncPoints(new Merge(OperationSource.SERVER, path, merge));
            }
        });
    }

    public List<? extends Event> applyServerRangeMerges(Path path, List<RangeMerge> rangeMerges) {
        SyncPoint syncPoint = this.syncPointTree.get(path);
        if (syncPoint == null) {
            return Collections.emptyList();
        }
        View view = syncPoint.getCompleteView();
        if (view == null) {
            return Collections.emptyList();
        }
        Node serverNode = view.getServerCache();
        for (RangeMerge merge : rangeMerges) {
            serverNode = merge.applyTo(serverNode);
        }
        return applyServerOverwrite(path, serverNode);
    }

    public List<? extends Event> applyTaggedRangeMerges(Path path, List<RangeMerge> rangeMerges, Tag tag) {
        QuerySpec query = queryForTag(tag);
        if (query == null) {
            return Collections.emptyList();
        }
        Node serverNode = this.syncPointTree.get(query.getPath()).viewForQuery(query).getServerCache();
        for (RangeMerge merge : rangeMerges) {
            serverNode = merge.applyTo(serverNode);
        }
        return applyTaggedQueryOverwrite(path, serverNode, tag);
    }

    public List<? extends Event> applyListenComplete(final Path path) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                SyncTree.this.persistenceManager.setQueryComplete(QuerySpec.defaultQueryAtPath(path));
                return SyncTree.this.applyOperationToSyncPoints(new ListenComplete(OperationSource.SERVER, path));
            }
        });
    }

    public List<? extends Event> applyTaggedListenComplete(final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                SyncTree.this.persistenceManager.setQueryComplete(query);
                return SyncTree.this.applyTaggedOperation(query, new ListenComplete(OperationSource.forServerTaggedQuery(query.getParams()), Path.getEmptyPath()));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<? extends Event> applyTaggedOperation(QuerySpec query, Operation operation) {
        Path queryPath = query.getPath();
        return this.syncPointTree.get(queryPath).applyOperation(operation, this.pendingWriteTree.childWrites(queryPath), null);
    }

    public List<? extends Event> applyTaggedQueryOverwrite(final Path path, final Node snap, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass9 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                Path relativePath = Path.getRelative(query.getPath(), path);
                SyncTree.this.persistenceManager.updateServerCache(relativePath.isEmpty() ? query : QuerySpec.defaultQueryAtPath(path), snap);
                return SyncTree.this.applyTaggedOperation(query, new Overwrite(OperationSource.forServerTaggedQuery(query.getParams()), relativePath, snap));
            }
        });
    }

    public List<? extends Event> applyTaggedQueryMerge(final Path path, final Map<Path, Node> changedChildren, final Tag tag) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass10 */

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                QuerySpec query = SyncTree.this.queryForTag(tag);
                if (query == null) {
                    return Collections.emptyList();
                }
                Path relativePath = Path.getRelative(query.getPath(), path);
                CompoundWrite merge = CompoundWrite.fromPathMerge(changedChildren);
                SyncTree.this.persistenceManager.updateServerCache(path, merge);
                return SyncTree.this.applyTaggedOperation(query, new Merge(OperationSource.forServerTaggedQuery(query.getParams()), relativePath, merge));
            }
        });
    }

    public List<? extends Event> addEventRegistration(final EventRegistration eventRegistration) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<? extends Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass11 */
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // java.util.concurrent.Callable
            public List<? extends Event> call() {
                CacheNode persistentServerCache;
                Node completeCache;
                Node node;
                Node node2;
                QuerySpec query = eventRegistration.getQuerySpec();
                Path path = query.getPath();
                Node serverCacheNode = null;
                boolean foundAncestorDefaultView = false;
                ImmutableTree<SyncPoint> tree = SyncTree.this.syncPointTree;
                Path currentPath = path;
                while (true) {
                    boolean z = true;
                    if (tree.isEmpty()) {
                        break;
                    }
                    SyncPoint currentSyncPoint = tree.getValue();
                    if (currentSyncPoint != null) {
                        if (serverCacheNode != null) {
                            node2 = serverCacheNode;
                        } else {
                            node2 = currentSyncPoint.getCompleteServerCache(currentPath);
                        }
                        serverCacheNode = node2;
                        if (!foundAncestorDefaultView && !currentSyncPoint.hasCompleteView()) {
                            z = false;
                        }
                        foundAncestorDefaultView = z;
                    }
                    tree = tree.getChild(currentPath.isEmpty() ? ChildKey.fromString("") : currentPath.getFront());
                    currentPath = currentPath.popFront();
                }
                SyncPoint syncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                if (syncPoint == null) {
                    syncPoint = new SyncPoint(SyncTree.this.persistenceManager);
                    SyncTree syncTree = SyncTree.this;
                    syncTree.syncPointTree = syncTree.syncPointTree.set(path, syncPoint);
                } else {
                    foundAncestorDefaultView = foundAncestorDefaultView || syncPoint.hasCompleteView();
                    if (serverCacheNode != null) {
                        node = serverCacheNode;
                    } else {
                        node = syncPoint.getCompleteServerCache(Path.getEmptyPath());
                    }
                    serverCacheNode = node;
                }
                SyncTree.this.persistenceManager.setQueryActive(query);
                if (serverCacheNode != null) {
                    persistentServerCache = new CacheNode(IndexedNode.from(serverCacheNode, query.getIndex()), true, false);
                } else {
                    persistentServerCache = SyncTree.this.persistenceManager.serverCache(query);
                    if (!persistentServerCache.isFullyInitialized()) {
                        Node serverCacheNode2 = EmptyNode.Empty();
                        Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> it = SyncTree.this.syncPointTree.subtree(path).getChildren().iterator();
                        while (it.hasNext()) {
                            Map.Entry<ChildKey, ImmutableTree<SyncPoint>> child = it.next();
                            SyncPoint childSyncPoint = child.getValue().getValue();
                            if (!(childSyncPoint == null || (completeCache = childSyncPoint.getCompleteServerCache(Path.getEmptyPath())) == null)) {
                                serverCacheNode2 = serverCacheNode2.updateImmediateChild(child.getKey(), completeCache);
                            }
                        }
                        for (NamedNode child2 : persistentServerCache.getNode()) {
                            if (!serverCacheNode2.hasChild(child2.getName())) {
                                serverCacheNode2 = serverCacheNode2.updateImmediateChild(child2.getName(), child2.getNode());
                            }
                        }
                        persistentServerCache = new CacheNode(IndexedNode.from(serverCacheNode2, query.getIndex()), false, false);
                    }
                }
                boolean viewAlreadyExists = syncPoint.viewExistsForQuery(query);
                if (!viewAlreadyExists && !query.loadsAllData()) {
                    Tag tag = SyncTree.this.getNextQueryTag();
                    SyncTree.this.queryToTagMap.put(query, tag);
                    SyncTree.this.tagToQueryMap.put(tag, query);
                }
                List<? extends Event> events = syncPoint.addEventRegistration(eventRegistration, SyncTree.this.pendingWriteTree.childWrites(path), persistentServerCache);
                if (!viewAlreadyExists && !foundAncestorDefaultView) {
                    SyncTree.this.setupListener(query, syncPoint.viewForQuery(query));
                }
                return events;
            }
        });
    }

    public List<Event> removeEventRegistration(EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, null);
    }

    public List<Event> removeAllEventRegistrations(QuerySpec query, DatabaseError error) {
        return removeEventRegistration(query, null, error);
    }

    private List<Event> removeEventRegistration(final QuerySpec query, final EventRegistration eventRegistration, final DatabaseError cancelError) {
        return (List) this.persistenceManager.runInTransaction(new Callable<List<Event>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass12 */
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // java.util.concurrent.Callable
            public List<Event> call() {
                Path path = query.getPath();
                SyncPoint maybeSyncPoint = (SyncPoint) SyncTree.this.syncPointTree.get(path);
                List<Event> cancelEvents = new ArrayList<>();
                if (maybeSyncPoint != null) {
                    if (query.isDefault() || maybeSyncPoint.viewExistsForQuery(query)) {
                        Pair<List<QuerySpec>, List<Event>> removedAndEvents = maybeSyncPoint.removeEventRegistration(query, eventRegistration, cancelError);
                        if (maybeSyncPoint.isEmpty()) {
                            SyncTree syncTree = SyncTree.this;
                            syncTree.syncPointTree = syncTree.syncPointTree.remove(path);
                        }
                        List<QuerySpec> removed = removedAndEvents.getFirst();
                        cancelEvents = removedAndEvents.getSecond();
                        boolean removingDefault = false;
                        Iterator<QuerySpec> it = removed.iterator();
                        while (true) {
                            boolean z = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            QuerySpec queryRemoved = it.next();
                            SyncTree.this.persistenceManager.setQueryInactive(query);
                            if (!removingDefault && !queryRemoved.loadsAllData()) {
                                z = false;
                            }
                            removingDefault = z;
                        }
                        ImmutableTree<SyncPoint> currentTree = SyncTree.this.syncPointTree;
                        boolean covered = currentTree.getValue() != null && currentTree.getValue().hasCompleteView();
                        Iterator<ChildKey> it2 = path.iterator();
                        while (it2.hasNext()) {
                            currentTree = currentTree.getChild(it2.next());
                            covered = covered || (currentTree.getValue() != null && currentTree.getValue().hasCompleteView());
                            if (!covered) {
                                if (currentTree.isEmpty()) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (removingDefault && !covered) {
                            ImmutableTree<SyncPoint> subtree = SyncTree.this.syncPointTree.subtree(path);
                            if (!subtree.isEmpty()) {
                                for (View view : SyncTree.this.collectDistinctViewsForSubTree(subtree)) {
                                    ListenContainer container = new ListenContainer(view);
                                    SyncTree.this.listenProvider.startListening(SyncTree.this.queryForListening(view.getQuery()), container.tag, container, container);
                                    path = path;
                                    maybeSyncPoint = maybeSyncPoint;
                                }
                            }
                        }
                        if (!covered && !removed.isEmpty() && cancelError == null) {
                            if (removingDefault) {
                                SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), null);
                            } else {
                                for (QuerySpec queryToRemove : removed) {
                                    SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(queryToRemove), SyncTree.this.tagForQuery(queryToRemove));
                                }
                            }
                        }
                        SyncTree.this.removeTags(removed);
                    }
                }
                return cancelEvents;
            }
        });
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class KeepSyncedEventRegistration extends EventRegistration {
        private QuerySpec spec;

        public KeepSyncedEventRegistration(QuerySpec spec2) {
            this.spec = spec2;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean respondsTo(Event.EventType eventType) {
            return false;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public DataEvent createEvent(Change change, QuerySpec query) {
            return null;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireEvent(DataEvent dataEvent) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireCancelEvent(DatabaseError error) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public EventRegistration clone(QuerySpec newQuery) {
            return new KeepSyncedEventRegistration(newQuery);
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean isSameListener(EventRegistration other) {
            return other instanceof KeepSyncedEventRegistration;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public QuerySpec getQuerySpec() {
            return this.spec;
        }

        public boolean equals(Object other) {
            return (other instanceof KeepSyncedEventRegistration) && ((KeepSyncedEventRegistration) other).spec.equals(this.spec);
        }

        public int hashCode() {
            return this.spec.hashCode();
        }
    }

    public void keepSynced(QuerySpec query, boolean keep) {
        if (keep && !this.keepSyncedQueries.contains(query)) {
            addEventRegistration(new KeepSyncedEventRegistration(query));
            this.keepSyncedQueries.add(query);
        } else if (!keep && this.keepSyncedQueries.contains(query)) {
            removeEventRegistration(new KeepSyncedEventRegistration(query));
            this.keepSyncedQueries.remove(query);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<View> collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> subtree) {
        ArrayList<View> accumulator = new ArrayList<>();
        collectDistinctViewsForSubTree(subtree, accumulator);
        return accumulator;
    }

    private void collectDistinctViewsForSubTree(ImmutableTree<SyncPoint> subtree, List<View> accumulator) {
        SyncPoint maybeSyncPoint = subtree.getValue();
        if (maybeSyncPoint == null || !maybeSyncPoint.hasCompleteView()) {
            if (maybeSyncPoint != null) {
                accumulator.addAll(maybeSyncPoint.getQueryViews());
            }
            Iterator<Map.Entry<ChildKey, ImmutableTree<SyncPoint>>> it = subtree.getChildren().iterator();
            while (it.hasNext()) {
                collectDistinctViewsForSubTree(it.next().getValue(), accumulator);
            }
            return;
        }
        accumulator.add(maybeSyncPoint.getCompleteView());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeTags(List<QuerySpec> queries) {
        for (QuerySpec removedQuery : queries) {
            if (!removedQuery.loadsAllData()) {
                Tag tag = tagForQuery(removedQuery);
                this.queryToTagMap.remove(removedQuery);
                this.tagToQueryMap.remove(tag);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private QuerySpec queryForListening(QuerySpec query) {
        if (!query.loadsAllData() || query.isDefault()) {
            return query;
        }
        return QuerySpec.defaultQueryAtPath(query.getPath());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupListener(QuerySpec query, View view) {
        Path path = query.getPath();
        Tag tag = tagForQuery(query);
        ListenContainer container = new ListenContainer(view);
        this.listenProvider.startListening(queryForListening(query), tag, container, container);
        ImmutableTree<SyncPoint> subtree = this.syncPointTree.subtree(path);
        if (tag == null) {
            subtree.foreach(new ImmutableTree.TreeVisitor<SyncPoint, Void>() {
                /* class com.google.firebase.database.core.SyncTree.AnonymousClass13 */

                public Void onNodeValue(Path relativePath, SyncPoint maybeChildSyncPoint, Void accum) {
                    if (relativePath.isEmpty() || !maybeChildSyncPoint.hasCompleteView()) {
                        for (View syncPointView : maybeChildSyncPoint.getQueryViews()) {
                            QuerySpec childQuery = syncPointView.getQuery();
                            SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(childQuery), SyncTree.this.tagForQuery(childQuery));
                        }
                        return null;
                    }
                    QuerySpec query = maybeChildSyncPoint.getCompleteView().getQuery();
                    SyncTree.this.listenProvider.stopListening(SyncTree.this.queryForListening(query), SyncTree.this.tagForQuery(query));
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private QuerySpec queryForTag(Tag tag) {
        return this.tagToQueryMap.get(tag);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Tag tagForQuery(QuerySpec query) {
        return this.queryToTagMap.get(query);
    }

    public Node calcCompleteEventCache(Path path, List<Long> writeIdsToExclude) {
        ImmutableTree<SyncPoint> tree = this.syncPointTree;
        tree.getValue();
        Node serverCache = null;
        Path pathToFollow = path;
        Path pathSoFar = Path.getEmptyPath();
        do {
            ChildKey front = pathToFollow.getFront();
            pathToFollow = pathToFollow.popFront();
            pathSoFar = pathSoFar.child(front);
            Path relativePath = Path.getRelative(pathSoFar, path);
            tree = front != null ? tree.getChild(front) : ImmutableTree.emptyInstance();
            SyncPoint currentSyncPoint = tree.getValue();
            if (currentSyncPoint != null) {
                serverCache = currentSyncPoint.getCompleteServerCache(relativePath);
            }
            if (pathToFollow.isEmpty()) {
                break;
            }
        } while (serverCache == null);
        return this.pendingWriteTree.calcCompleteEventCache(path, serverCache, writeIdsToExclude, true);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Tag getNextQueryTag() {
        long j = this.nextQueryTag;
        this.nextQueryTag = 1 + j;
        return new Tag(j);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<Event> applyOperationToSyncPoints(Operation operation) {
        return applyOperationHelper(operation, this.syncPointTree, null, this.pendingWriteTree.childWrites(Path.getEmptyPath()));
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<SyncPoint> syncPointTree2, Node serverCache, WriteTreeRef writesCache) {
        if (operation.getPath().isEmpty()) {
            return applyOperationDescendantsHelper(operation, syncPointTree2, serverCache, writesCache);
        }
        SyncPoint syncPoint = syncPointTree2.getValue();
        if (serverCache == null && syncPoint != null) {
            serverCache = syncPoint.getCompleteServerCache(Path.getEmptyPath());
        }
        List<Event> events = new ArrayList<>();
        ChildKey childKey = operation.getPath().getFront();
        Operation childOperation = operation.operationForChild(childKey);
        ImmutableTree<SyncPoint> childTree = syncPointTree2.getChildren().get(childKey);
        if (!(childTree == null || childOperation == null)) {
            events.addAll(applyOperationHelper(childOperation, childTree, serverCache != null ? serverCache.getImmediateChild(childKey) : null, writesCache.child(childKey)));
        }
        if (syncPoint != null) {
            events.addAll(syncPoint.applyOperation(operation, writesCache, serverCache));
        }
        return events;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<Event> applyOperationDescendantsHelper(final Operation operation, ImmutableTree<SyncPoint> syncPointTree2, Node serverCache, final WriteTreeRef writesCache) {
        final Node resolvedServerCache;
        SyncPoint syncPoint = syncPointTree2.getValue();
        if (serverCache != null || syncPoint == null) {
            resolvedServerCache = serverCache;
        } else {
            resolvedServerCache = syncPoint.getCompleteServerCache(Path.getEmptyPath());
        }
        final List<Event> events = new ArrayList<>();
        syncPointTree2.getChildren().inOrderTraversal(new LLRBNode.NodeVisitor<ChildKey, ImmutableTree<SyncPoint>>() {
            /* class com.google.firebase.database.core.SyncTree.AnonymousClass14 */

            public void visitEntry(ChildKey key, ImmutableTree<SyncPoint> childTree) {
                Node childServerCache = null;
                Node node = resolvedServerCache;
                if (node != null) {
                    childServerCache = node.getImmediateChild(key);
                }
                WriteTreeRef childWritesCache = writesCache.child(key);
                Operation childOperation = operation.operationForChild(key);
                if (childOperation != null) {
                    events.addAll(SyncTree.this.applyOperationDescendantsHelper(childOperation, childTree, childServerCache, childWritesCache));
                }
            }
        });
        if (syncPoint != null) {
            events.addAll(syncPoint.applyOperation(operation, writesCache, resolvedServerCache));
        }
        return events;
    }

    /* access modifiers changed from: package-private */
    public ImmutableTree<SyncPoint> getSyncPointTree() {
        return this.syncPointTree;
    }
}
