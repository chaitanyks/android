package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class Repo implements PersistentConnection.Delegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    private PersistentConnection connection;
    private final Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    private SnapshotHolder infoData;
    private SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    private SparseSnapshotTree onDisconnect;
    private final LogWrapper operationLogger;
    private final RepoInfo repoInfo;
    private final OffsetClock serverClock = new OffsetClock(new DefaultClock(), 0);
    private SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    private Tree<List<TransactionData>> transactionQueueTree;

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    Repo(RepoInfo repoInfo2, Context ctx2, FirebaseDatabase database2) {
        this.repoInfo = repoInfo2;
        this.ctx = ctx2;
        this.database = database2;
        this.operationLogger = ctx2.getLogger("RepoOperation");
        this.transactionLogger = this.ctx.getLogger("Transaction");
        this.dataLogger = this.ctx.getLogger("DataOperation");
        this.eventRaiser = new EventRaiser(this.ctx);
        scheduleNow(new Runnable() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass1 */

            public void run() {
                Repo.this.deferredInitialization();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deferredInitialization() {
        this.connection = this.ctx.newPersistentConnection(new HostInfo(this.repoInfo.host, this.repoInfo.namespace, this.repoInfo.secure), this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener(((DefaultRunLoop) this.ctx.getRunLoop()).getExecutorService(), new AuthTokenProvider.TokenChangeListener() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass2 */

            @Override // com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener
            public void onTokenChange() {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken();
            }

            @Override // com.google.firebase.database.core.AuthTokenProvider.TokenChangeListener
            public void onTokenChange(String token) {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken(token);
            }
        });
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(this.repoInfo.host);
        this.infoData = new SnapshotHolder();
        this.onDisconnect = new SparseSnapshotTree();
        this.transactionQueueTree = new Tree<>();
        this.infoSyncTree = new SyncTree(this.ctx, new NoopPersistenceManager(), new SyncTree.ListenProvider() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass3 */

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void startListening(final QuerySpec query, Tag tag, ListenHashProvider hash, final SyncTree.CompletionListener onComplete) {
                Repo.this.scheduleNow(new Runnable() {
                    /* class com.google.firebase.database.core.Repo.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        Node node = Repo.this.infoData.getNode(query.getPath());
                        if (!node.isEmpty()) {
                            Repo.this.postEvents(Repo.this.infoSyncTree.applyServerOverwrite(query.getPath(), node));
                            onComplete.onListenComplete(null);
                        }
                    }
                });
            }

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void stopListening(QuerySpec query, Tag tag) {
            }
        });
        this.serverSyncTree = new SyncTree(this.ctx, persistenceManager, new SyncTree.ListenProvider() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass4 */

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void startListening(QuerySpec query, Tag tag, ListenHashProvider hash, final SyncTree.CompletionListener onListenComplete) {
                Repo.this.connection.listen(query.getPath().asList(), query.getParams().getWireProtocolParams(), hash, tag != null ? Long.valueOf(tag.getTagNumber()) : null, new RequestResultCallback() {
                    /* class com.google.firebase.database.core.Repo.AnonymousClass4.AnonymousClass1 */

                    @Override // com.google.firebase.database.connection.RequestResultCallback
                    public void onRequestResult(String optErrorCode, String optErrorMessage) {
                        Repo.this.postEvents(onListenComplete.onListenComplete(Repo.fromErrorCode(optErrorCode, optErrorMessage)));
                    }
                });
            }

            @Override // com.google.firebase.database.core.SyncTree.ListenProvider
            public void stopListening(QuerySpec query, Tag tag) {
                Repo.this.connection.unlisten(query.getPath().asList(), query.getParams().getWireProtocolParams());
            }
        });
        restoreWrites(persistenceManager);
        updateInfo(Constants.DOT_INFO_AUTHENTICATED, false);
        updateInfo(Constants.DOT_INFO_CONNECTED, false);
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        List<UserWriteRecord> writes = persistenceManager.loadUserWrites();
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        long lastWriteId = Long.MIN_VALUE;
        for (final UserWriteRecord write : writes) {
            RequestResultCallback onComplete = new RequestResultCallback() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass5 */

                @Override // com.google.firebase.database.connection.RequestResultCallback
                public void onRequestResult(String optErrorCode, String optErrorMessage) {
                    DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                    Repo.this.warnIfWriteFailed("Persisted write", write.getPath(), error);
                    Repo.this.ackWriteAndRerunTransactions(write.getWriteId(), write.getPath(), error);
                }
            };
            if (lastWriteId < write.getWriteId()) {
                lastWriteId = write.getWriteId();
                this.nextWriteId = write.getWriteId() + 1;
                Node existing = this.serverSyncTree.calcCompleteEventCache(write.getPath(), new ArrayList());
                if (write.isOverwrite()) {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper = this.operationLogger;
                        logWrapper.debug("Restoring overwrite with id " + write.getWriteId(), new Object[0]);
                    }
                    this.connection.put(write.getPath().asList(), write.getOverwrite().getValue(true), onComplete);
                    this.serverSyncTree.applyUserOverwrite(write.getPath(), write.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), existing, serverValues), write.getWriteId(), true, false);
                } else {
                    if (this.operationLogger.logsDebug()) {
                        LogWrapper logWrapper2 = this.operationLogger;
                        logWrapper2.debug("Restoring merge with id " + write.getWriteId(), new Object[0]);
                    }
                    this.connection.merge(write.getPath().asList(), write.getMerge().getValue(true), onComplete);
                    this.serverSyncTree.applyUserMerge(write.getPath(), write.getMerge(), ServerValues.resolveDeferredValueMerge(write.getMerge(), existing, serverValues), write.getWriteId(), false);
                }
            } else {
                throw new IllegalStateException("Write ids were not in order.");
            }
        }
    }

    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    public String toString() {
        return this.repoInfo.toString();
    }

    public RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    public void scheduleNow(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(r);
    }

    public void postEvent(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(r);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void postEvents(List<? extends Event> events) {
        if (!events.isEmpty()) {
            this.eventRaiser.raiseEvents(events);
        }
    }

    public long getServerTime() {
        return this.serverClock.millis();
    }

    /* access modifiers changed from: package-private */
    public boolean hasListeners() {
        return !this.infoSyncTree.isEmpty() || !this.serverSyncTree.isEmpty();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onDataUpdate(List<String> pathSegments, Object message, boolean isMerge, Long optTag) {
        List<? extends Event> events;
        Path path = new Path(pathSegments);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path + " " + message, new Object[0]);
        }
        this.dataUpdateCount++;
        if (optTag != null) {
            try {
                Tag tag = new Tag(optTag.longValue());
                if (isMerge) {
                    Map<Path, Node> taggedChildren = new HashMap<>();
                    for (Map.Entry<String, Object> entry : ((Map) message).entrySet()) {
                        taggedChildren.put(new Path(entry.getKey()), NodeUtilities.NodeFromJSON(entry.getValue()));
                    }
                    events = this.serverSyncTree.applyTaggedQueryMerge(path, taggedChildren, tag);
                } else {
                    events = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(message), tag);
                }
            } catch (DatabaseException e) {
                this.operationLogger.error("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (isMerge) {
            Map<Path, Node> changedChildren = new HashMap<>();
            for (Map.Entry<String, Object> entry2 : ((Map) message).entrySet()) {
                changedChildren.put(new Path(entry2.getKey()), NodeUtilities.NodeFromJSON(entry2.getValue()));
            }
            events = this.serverSyncTree.applyServerMerge(path, changedChildren);
        } else {
            events = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(message));
        }
        if (events.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(events);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onRangeMergeUpdate(List<String> pathSegments, List<RangeMerge> merges, Long tagNumber) {
        List<? extends Event> events;
        Path path = new Path(pathSegments);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path + " " + merges, new Object[0]);
        }
        this.dataUpdateCount++;
        List<com.google.firebase.database.snapshot.RangeMerge> parsedMerges = new ArrayList<>(merges.size());
        for (RangeMerge merge : merges) {
            parsedMerges.add(new com.google.firebase.database.snapshot.RangeMerge(merge));
        }
        if (tagNumber != null) {
            events = this.serverSyncTree.applyTaggedRangeMerges(path, parsedMerges, new Tag(tagNumber.longValue()));
        } else {
            events = this.serverSyncTree.applyServerRangeMerges(path, parsedMerges);
        }
        if (events.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(events);
    }

    /* access modifiers changed from: package-private */
    public void callOnComplete(final DatabaseReference.CompletionListener onComplete, final DatabaseError error, Path path) {
        final DatabaseReference ref;
        if (onComplete != null) {
            ChildKey last = path.getBack();
            if (last == null || !last.isPriorityChildName()) {
                ref = InternalHelpers.createReference(this, path);
            } else {
                ref = InternalHelpers.createReference(this, path.getParent());
            }
            postEvent(new Runnable() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass6 */

                public void run() {
                    onComplete.onComplete(error, ref);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ackWriteAndRerunTransactions(long writeId, Path path, DatabaseError error) {
        if (error == null || error.getCode() != -25) {
            List<? extends Event> clearEvents = this.serverSyncTree.ackUserWrite(writeId, !(error == null), true, this.serverClock);
            if (clearEvents.size() > 0) {
                rerunTransactions(path);
            }
            postEvents(clearEvents);
        }
    }

    public void setValue(final Path path, Node newValueUnresolved, final DatabaseReference.CompletionListener onComplete) {
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("set: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("set: " + path + " " + newValueUnresolved, new Object[0]);
        }
        Node newValue = ServerValues.resolveDeferredValueSnapshot(newValueUnresolved, this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), ServerValues.generateServerValues(this.serverClock));
        final long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path, newValueUnresolved, newValue, writeId, true, true));
        this.connection.put(path.asList(), newValueUnresolved.getValue(true), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass7 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("setValue", path, error);
                Repo.this.ackWriteAndRerunTransactions(writeId, path, error);
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
        rerunTransactions(abortTransactions(path, -9));
    }

    public void updateChildren(final Path path, CompoundWrite updates, final DatabaseReference.CompletionListener onComplete, Map<String, Object> unParsedUpdates) {
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("update: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("update: " + path + " " + unParsedUpdates, new Object[0]);
        }
        if (updates.isEmpty()) {
            if (this.operationLogger.logsDebug()) {
                this.operationLogger.debug("update called with no changes. No-op", new Object[0]);
            }
            callOnComplete(onComplete, null, path);
            return;
        }
        CompoundWrite resolved = ServerValues.resolveDeferredValueMerge(updates, this.serverSyncTree.calcCompleteEventCache(path, new ArrayList()), ServerValues.generateServerValues(this.serverClock));
        final long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserMerge(path, updates, resolved, writeId, true));
        this.connection.merge(path.asList(), unParsedUpdates, new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass8 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("updateChildren", path, error);
                Repo.this.ackWriteAndRerunTransactions(writeId, path, error);
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
        Iterator<Map.Entry<Path, Node>> it = updates.iterator();
        while (it.hasNext()) {
            rerunTransactions(abortTransactions(path.child(it.next().getKey()), -9));
        }
    }

    public void purgeOutstandingWrites() {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    public void removeEventCallback(EventRegistration eventRegistration) {
        List<Event> events;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            events = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            events = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void onDisconnectSetValue(final Path path, final Node newValue, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectPut(path.asList(), newValue.getValue(true), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass9 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().setValue", path, error);
                if (error == null) {
                    Repo.this.onDisconnect.remember(path, newValue);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    public void onDisconnectUpdate(final Path path, final Map<Path, Node> newChildren, final DatabaseReference.CompletionListener listener, Map<String, Object> unParsedUpdates) {
        this.connection.onDisconnectMerge(path.asList(), unParsedUpdates, new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass10 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().updateChildren", path, error);
                if (error == null) {
                    for (Map.Entry<Path, Node> entry : newChildren.entrySet()) {
                        Repo.this.onDisconnect.remember(path.child(entry.getKey()), entry.getValue());
                    }
                }
                Repo.this.callOnComplete(listener, error, path);
            }
        });
    }

    public void onDisconnectCancel(final Path path, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectCancel(path.asList(), new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass11 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                if (error == null) {
                    Repo.this.onDisconnect.forget(path);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, true);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, false);
        runOnDisconnectEvents();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onAuthStatus(boolean authOk) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(authOk));
    }

    public void onServerInfoUpdate(ChildKey key, Object value) {
        updateInfo(key, value);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection.Delegate
    public void onServerInfoUpdate(Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            updateInfo(ChildKey.fromString(entry.getKey()), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void interrupt() {
        this.connection.interrupt(INTERRUPT_REASON);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        this.connection.resume(INTERRUPT_REASON);
    }

    public void addEventCallback(EventRegistration eventRegistration) {
        List<? extends Event> events;
        ChildKey front = eventRegistration.getQuerySpec().getPath().getFront();
        if (front == null || !front.equals(Constants.DOT_INFO)) {
            events = this.serverSyncTree.addEventRegistration(eventRegistration);
        } else {
            events = this.infoSyncTree.addEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void keepSynced(QuerySpec query, boolean keep) {
        this.serverSyncTree.keepSynced(query, keep);
    }

    /* access modifiers changed from: package-private */
    public PersistentConnection getConnection() {
        return this.connection;
    }

    private void updateInfo(ChildKey childKey, Object value) {
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset(((Long) value).longValue());
        }
        Path path = new Path(Constants.DOT_INFO, childKey);
        try {
            Node node = NodeUtilities.NodeFromJSON(value);
            this.infoData.update(path, node);
            postEvents(this.infoSyncTree.applyServerOverwrite(path, node));
        } catch (DatabaseException e) {
            this.operationLogger.error("Failed to parse info update", e);
        }
    }

    private long getNextWriteId() {
        long j = this.nextWriteId;
        this.nextWriteId = 1 + j;
        return j;
    }

    private void runOnDisconnectEvents() {
        final Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        final List<Event> events = new ArrayList<>();
        this.onDisconnect.forEachTree(Path.getEmptyPath(), new SparseSnapshotTree.SparseSnapshotTreeVisitor() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass12 */

            @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
            public void visitTree(Path prefixPath, Node node) {
                events.addAll(Repo.this.serverSyncTree.applyServerOverwrite(prefixPath, ServerValues.resolveDeferredValueSnapshot(node, Repo.this.serverSyncTree.calcCompleteEventCache(prefixPath, new ArrayList()), serverValues)));
                Repo.this.rerunTransactions(Repo.this.abortTransactions(prefixPath, -9));
            }
        });
        this.onDisconnect = new SparseSnapshotTree();
        postEvents(events);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void warnIfWriteFailed(String writeType, Path path, DatabaseError error) {
        if (error != null && error.getCode() != -1 && error.getCode() != -25) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.warn(writeType + " at " + path.toString() + " failed: " + error.toString());
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public static class TransactionData implements Comparable<TransactionData> {
        private DatabaseError abortReason;
        private boolean applyLocally;
        private Node currentInputSnapshot;
        private Node currentOutputSnapshotRaw;
        private Node currentOutputSnapshotResolved;
        private long currentWriteId;
        private Transaction.Handler handler;
        private long order;
        private ValueEventListener outstandingListener;
        private Path path;
        private int retryCount;
        private TransactionStatus status;

        static /* synthetic */ int access$2008(TransactionData x0) {
            int i = x0.retryCount;
            x0.retryCount = i + 1;
            return i;
        }

        private TransactionData(Path path2, Transaction.Handler handler2, ValueEventListener outstandingListener2, TransactionStatus status2, boolean applyLocally2, long order2) {
            this.path = path2;
            this.handler = handler2;
            this.outstandingListener = outstandingListener2;
            this.status = status2;
            this.retryCount = 0;
            this.applyLocally = applyLocally2;
            this.order = order2;
            this.abortReason = null;
            this.currentInputSnapshot = null;
            this.currentOutputSnapshotRaw = null;
            this.currentOutputSnapshotResolved = null;
        }

        public int compareTo(TransactionData o) {
            long j = this.order;
            long j2 = o.order;
            if (j < j2) {
                return -1;
            }
            if (j == j2) {
                return 0;
            }
            return 1;
        }
    }

    public void startTransaction(Path path, final Transaction.Handler handler, boolean applyLocally) {
        final DatabaseError error;
        Transaction.Result result;
        List<TransactionData> nodeQueue;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path, new Object[0]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            this.loggedTransactionPersistenceWarning = true;
            this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference watchRef = InternalHelpers.createReference(this, path);
        ValueEventListener listener = new ValueEventListener() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass13 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        };
        addEventCallback(new ValueEventRegistration(this, listener, watchRef.getSpec()));
        TransactionData transaction = new TransactionData(path, handler, listener, TransactionStatus.INITIALIZING, applyLocally, nextTransactionOrder());
        Node currentState = getLatestState(path);
        transaction.currentInputSnapshot = currentState;
        try {
            result = handler.doTransaction(InternalHelpers.createMutableData(currentState));
            if (result != null) {
                error = null;
                if (!result.isSuccess()) {
                    transaction.currentOutputSnapshotRaw = null;
                    transaction.currentOutputSnapshotResolved = null;
                    final DataSnapshot snap = InternalHelpers.createDataSnapshot(watchRef, IndexedNode.from(transaction.currentInputSnapshot));
                    postEvent(new Runnable() {
                        /* class com.google.firebase.database.core.Repo.AnonymousClass14 */

                        public void run() {
                            handler.onComplete(error, false, snap);
                        }
                    });
                    return;
                }
                transaction.status = TransactionStatus.RUN;
                Tree<List<TransactionData>> queueNode = this.transactionQueueTree.subTree(path);
                List<TransactionData> nodeQueue2 = queueNode.getValue();
                if (nodeQueue2 == null) {
                    nodeQueue = new ArrayList<>();
                } else {
                    nodeQueue = nodeQueue2;
                }
                nodeQueue.add(transaction);
                queueNode.setValue(nodeQueue);
                Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
                Node newNodeUnresolved = result.getNode();
                Node newNode = ServerValues.resolveDeferredValueSnapshot(newNodeUnresolved, transaction.currentInputSnapshot, serverValues);
                transaction.currentOutputSnapshotRaw = newNodeUnresolved;
                transaction.currentOutputSnapshotResolved = newNode;
                transaction.currentWriteId = getNextWriteId();
                postEvents(this.serverSyncTree.applyUserOverwrite(path, newNodeUnresolved, newNode, transaction.currentWriteId, applyLocally, false));
                sendAllReadyTransactions();
                return;
            }
            throw new NullPointerException("Transaction returned null as result");
        } catch (Throwable e) {
            this.operationLogger.error("Caught Throwable.", e);
            error = DatabaseError.fromException(e);
            result = Transaction.abort();
        }
    }

    private Node getLatestState(Path path) {
        return getLatestState(path, new ArrayList());
    }

    private Node getLatestState(Path path, List<Long> excudeSets) {
        Node state = this.serverSyncTree.calcCompleteEventCache(path, excudeSets);
        if (state == null) {
            return EmptyNode.Empty();
        }
        return state;
    }

    public void setHijackHash(boolean hijackHash2) {
        this.hijackHash = hijackHash2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendAllReadyTransactions() {
        Tree<List<TransactionData>> node = this.transactionQueueTree;
        pruneCompletedTransactions(node);
        sendReadyTransactions(node);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendReadyTransactions(Tree<List<TransactionData>> node) {
        if (node.getValue() != null) {
            List<TransactionData> queue = buildTransactionQueue(node);
            Boolean allRun = true;
            Iterator<TransactionData> it = queue.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().status != TransactionStatus.RUN) {
                        allRun = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (allRun.booleanValue()) {
                sendTransactionQueue(queue, node.getPath());
            }
        } else if (node.hasChildren()) {
            node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
                /* class com.google.firebase.database.core.Repo.AnonymousClass15 */

                @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
                public void visitTree(Tree<List<TransactionData>> tree) {
                    Repo.this.sendReadyTransactions(tree);
                }
            });
        }
    }

    private void sendTransactionQueue(final List<TransactionData> queue, final Path path) {
        List<Long> setsToIgnore = new ArrayList<>();
        for (TransactionData txn : queue) {
            setsToIgnore.add(Long.valueOf(txn.currentWriteId));
        }
        Node latestState = getLatestState(path, setsToIgnore);
        Node snapToSend = latestState;
        String latestHash = "badhash";
        if (!this.hijackHash) {
            latestHash = latestState.getHash();
        }
        for (TransactionData txn2 : queue) {
            txn2.status = TransactionStatus.SENT;
            TransactionData.access$2008(txn2);
            snapToSend = snapToSend.updateChild(Path.getRelative(path, txn2.path), txn2.currentOutputSnapshotRaw);
        }
        this.connection.compareAndPut(path.asList(), snapToSend.getValue(true), latestHash, new RequestResultCallback() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass16 */

            @Override // com.google.firebase.database.connection.RequestResultCallback
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("Transaction", path, error);
                List<Event> events = new ArrayList<>();
                if (error == null) {
                    List<Runnable> callbacks = new ArrayList<>();
                    for (final TransactionData txn : queue) {
                        txn.status = TransactionStatus.COMPLETED;
                        events.addAll(Repo.this.serverSyncTree.ackUserWrite(txn.currentWriteId, false, false, Repo.this.serverClock));
                        final DataSnapshot snap = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, txn.path), IndexedNode.from(txn.currentOutputSnapshotResolved));
                        callbacks.add(new Runnable() {
                            /* class com.google.firebase.database.core.Repo.AnonymousClass16.AnonymousClass1 */

                            public void run() {
                                txn.handler.onComplete(null, true, snap);
                            }
                        });
                        Repo.this.removeEventCallback(new ValueEventRegistration(Repo.this, txn.outstandingListener, QuerySpec.defaultQueryAtPath(txn.path)));
                    }
                    Repo repo = Repo.this;
                    repo.pruneCompletedTransactions(repo.transactionQueueTree.subTree(path));
                    Repo.this.sendAllReadyTransactions();
                    this.postEvents(events);
                    for (int i = 0; i < callbacks.size(); i++) {
                        Repo.this.postEvent(callbacks.get(i));
                    }
                    return;
                }
                if (error.getCode() == -1) {
                    for (TransactionData transaction : queue) {
                        if (transaction.status == TransactionStatus.SENT_NEEDS_ABORT) {
                            transaction.status = TransactionStatus.NEEDS_ABORT;
                        } else {
                            transaction.status = TransactionStatus.RUN;
                        }
                    }
                } else {
                    for (TransactionData transaction2 : queue) {
                        transaction2.status = TransactionStatus.NEEDS_ABORT;
                        transaction2.abortReason = error;
                    }
                }
                Repo.this.rerunTransactions(path);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pruneCompletedTransactions(Tree<List<TransactionData>> node) {
        List<TransactionData> queue = node.getValue();
        if (queue != null) {
            int i = 0;
            while (i < queue.size()) {
                if (queue.get(i).status == TransactionStatus.COMPLETED) {
                    queue.remove(i);
                } else {
                    i++;
                }
            }
            if (queue.size() > 0) {
                node.setValue(queue);
            } else {
                node.setValue(null);
            }
        }
        node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass17 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.pruneCompletedTransactions(tree);
            }
        });
    }

    private long nextTransactionOrder() {
        long j = this.transactionOrder;
        this.transactionOrder = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Path rerunTransactions(Path changedPath) {
        Tree<List<TransactionData>> rootMostTransactionNode = getAncestorTransactionNode(changedPath);
        Path path = rootMostTransactionNode.getPath();
        rerunTransactionQueue(buildTransactionQueue(rootMostTransactionNode), path);
        return path;
    }

    private void rerunTransactionQueue(List<TransactionData> queue, Path path) {
        Iterator<TransactionData> it;
        Transaction.Result result;
        if (!queue.isEmpty()) {
            List<Runnable> callbacks = new ArrayList<>();
            List<Long> setsToIgnore = new ArrayList<>();
            for (TransactionData transaction : queue) {
                setsToIgnore.add(Long.valueOf(transaction.currentWriteId));
            }
            Iterator<TransactionData> it2 = queue.iterator();
            while (it2.hasNext()) {
                final TransactionData transaction2 = it2.next();
                Path.getRelative(path, transaction2.path);
                boolean abortTransaction = false;
                final DatabaseError abortReason = null;
                List<Event> events = new ArrayList<>();
                if (transaction2.status == TransactionStatus.NEEDS_ABORT) {
                    abortTransaction = true;
                    abortReason = transaction2.abortReason;
                    if (abortReason.getCode() != -25) {
                        events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    }
                    it = it2;
                } else if (transaction2.status != TransactionStatus.RUN) {
                    it = it2;
                } else if (transaction2.retryCount >= 25) {
                    abortTransaction = true;
                    abortReason = DatabaseError.fromStatus(TRANSACTION_TOO_MANY_RETRIES);
                    events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    it = it2;
                } else {
                    Node currentNode = getLatestState(transaction2.path, setsToIgnore);
                    transaction2.currentInputSnapshot = currentNode;
                    DatabaseError error = null;
                    try {
                        result = transaction2.handler.doTransaction(InternalHelpers.createMutableData(currentNode));
                    } catch (Throwable e) {
                        this.operationLogger.error("Caught Throwable.", e);
                        error = DatabaseError.fromException(e);
                        result = Transaction.abort();
                    }
                    if (result.isSuccess()) {
                        Long oldWriteId = Long.valueOf(transaction2.currentWriteId);
                        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
                        it = it2;
                        Node newDataNode = result.getNode();
                        Node newNodeResolved = ServerValues.resolveDeferredValueSnapshot(newDataNode, currentNode, serverValues);
                        transaction2.currentOutputSnapshotRaw = newDataNode;
                        transaction2.currentOutputSnapshotResolved = newNodeResolved;
                        transaction2.currentWriteId = getNextWriteId();
                        setsToIgnore.remove(oldWriteId);
                        events.addAll(this.serverSyncTree.applyUserOverwrite(transaction2.path, newDataNode, newNodeResolved, transaction2.currentWriteId, transaction2.applyLocally, false));
                        events.addAll(this.serverSyncTree.ackUserWrite(oldWriteId.longValue(), true, false, this.serverClock));
                    } else {
                        it = it2;
                        abortTransaction = true;
                        abortReason = error;
                        events.addAll(this.serverSyncTree.ackUserWrite(transaction2.currentWriteId, true, false, this.serverClock));
                    }
                }
                postEvents(events);
                if (abortTransaction) {
                    transaction2.status = TransactionStatus.COMPLETED;
                    final DataSnapshot snapshot = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, transaction2.path), IndexedNode.from(transaction2.currentInputSnapshot));
                    scheduleNow(new Runnable() {
                        /* class com.google.firebase.database.core.Repo.AnonymousClass18 */

                        public void run() {
                            Repo.this.removeEventCallback(new ValueEventRegistration(Repo.this, transaction2.outstandingListener, QuerySpec.defaultQueryAtPath(transaction2.path)));
                        }
                    });
                    callbacks.add(new Runnable() {
                        /* class com.google.firebase.database.core.Repo.AnonymousClass19 */

                        public void run() {
                            transaction2.handler.onComplete(abortReason, false, snapshot);
                        }
                    });
                }
                it2 = it;
            }
            pruneCompletedTransactions(this.transactionQueueTree);
            for (int i = 0; i < callbacks.size(); i++) {
                postEvent(callbacks.get(i));
            }
            sendAllReadyTransactions();
        }
    }

    private Tree<List<TransactionData>> getAncestorTransactionNode(Path path) {
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree;
        while (!path.isEmpty() && transactionNode.getValue() == null) {
            transactionNode = transactionNode.subTree(new Path(path.getFront()));
            path = path.popFront();
        }
        return transactionNode;
    }

    private List<TransactionData> buildTransactionQueue(Tree<List<TransactionData>> transactionNode) {
        List<TransactionData> queue = new ArrayList<>();
        aggregateTransactionQueues(queue, transactionNode);
        Collections.sort(queue);
        return queue;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aggregateTransactionQueues(final List<TransactionData> queue, Tree<List<TransactionData>> node) {
        List<TransactionData> childQueue = node.getValue();
        if (childQueue != null) {
            queue.addAll(childQueue);
        }
        node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass20 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.aggregateTransactionQueues(queue, tree);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Path abortTransactions(Path path, final int reason) {
        Path affectedPath = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("Aborting transactions for path: " + path + ". Affected: " + affectedPath, new Object[0]);
        }
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree.subTree(path);
        transactionNode.forEachAncestor(new Tree.TreeFilter<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass21 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeFilter
            public boolean filterTreeNode(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
                return false;
            }
        });
        abortTransactionsAtNode(transactionNode, reason);
        transactionNode.forEachDescendant(new Tree.TreeVisitor<List<TransactionData>>() {
            /* class com.google.firebase.database.core.Repo.AnonymousClass22 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
            }
        });
        return affectedPath;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void abortTransactionsAtNode(Tree<List<TransactionData>> node, int reason) {
        final DatabaseError abortError;
        List<TransactionData> queue = node.getValue();
        List<Event> events = new ArrayList<>();
        if (queue != null) {
            List<Runnable> callbacks = new ArrayList<>();
            if (reason == -9) {
                abortError = DatabaseError.fromStatus(TRANSACTION_OVERRIDE_BY_SET);
            } else {
                boolean z = reason == -25;
                Utilities.hardAssert(z, "Unknown transaction abort reason: " + reason);
                abortError = DatabaseError.fromCode(-25);
            }
            int lastSent = -1;
            for (int i = 0; i < queue.size(); i++) {
                final TransactionData transaction = queue.get(i);
                if (transaction.status != TransactionStatus.SENT_NEEDS_ABORT) {
                    if (transaction.status == TransactionStatus.SENT) {
                        transaction.status = TransactionStatus.SENT_NEEDS_ABORT;
                        transaction.abortReason = abortError;
                        lastSent = i;
                    } else {
                        removeEventCallback(new ValueEventRegistration(this, transaction.outstandingListener, QuerySpec.defaultQueryAtPath(transaction.path)));
                        if (reason == -9) {
                            events.addAll(this.serverSyncTree.ackUserWrite(transaction.currentWriteId, true, false, this.serverClock));
                        } else {
                            boolean z2 = reason == -25;
                            Utilities.hardAssert(z2, "Unknown transaction abort reason: " + reason);
                        }
                        callbacks.add(new Runnable() {
                            /* class com.google.firebase.database.core.Repo.AnonymousClass23 */

                            public void run() {
                                transaction.handler.onComplete(abortError, false, null);
                            }
                        });
                    }
                }
            }
            if (lastSent == -1) {
                node.setValue(null);
            } else {
                node.setValue(queue.subList(0, lastSent + 1));
            }
            postEvents(events);
            for (Runnable r : callbacks) {
                postEvent(r);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    /* access modifiers changed from: package-private */
    public SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    /* access modifiers changed from: private */
    public static DatabaseError fromErrorCode(String optErrorCode, String optErrorReason) {
        if (optErrorCode != null) {
            return DatabaseError.fromStatus(optErrorCode, optErrorReason);
        }
        return null;
    }
}
