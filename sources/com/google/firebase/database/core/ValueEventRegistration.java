package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class ValueEventRegistration extends EventRegistration {
    private final ValueEventListener eventListener;
    private final Repo repo;
    private final QuerySpec spec;

    public ValueEventRegistration(Repo repo2, ValueEventListener eventListener2, QuerySpec spec2) {
        this.repo = repo2;
        this.eventListener = eventListener2;
        this.spec = spec2;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean respondsTo(Event.EventType eventType) {
        return eventType == Event.EventType.VALUE;
    }

    public boolean equals(Object other) {
        return (other instanceof ValueEventRegistration) && ((ValueEventRegistration) other).eventListener.equals(this.eventListener) && ((ValueEventRegistration) other).repo.equals(this.repo) && ((ValueEventRegistration) other).spec.equals(this.spec);
    }

    public int hashCode() {
        return (((this.eventListener.hashCode() * 31) + this.repo.hashCode()) * 31) + this.spec.hashCode();
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent createEvent(Change change, QuerySpec query) {
        return new DataEvent(Event.EventType.VALUE, this, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, query.getPath()), change.getIndexedNode()), null);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireEvent(DataEvent eventData) {
        if (!isZombied()) {
            this.eventListener.onDataChange(eventData.getSnapshot());
        }
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireCancelEvent(DatabaseError error) {
        this.eventListener.onCancelled(error);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public EventRegistration clone(QuerySpec newQuery) {
        return new ValueEventRegistration(this.repo, this.eventListener, newQuery);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean isSameListener(EventRegistration other) {
        return (other instanceof ValueEventRegistration) && ((ValueEventRegistration) other).eventListener.equals(this.eventListener);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public QuerySpec getQuerySpec() {
        return this.spec;
    }

    public String toString() {
        return "ValueEventRegistration";
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.firebase.database.core.EventRegistration
    public Repo getRepo() {
        return this.repo;
    }
}
