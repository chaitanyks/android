package com.google.firebase.database.core.view;

import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class EventGenerator {
    private final Index index;
    private final QuerySpec query;

    public EventGenerator(QuerySpec query2) {
        this.query = query2;
        this.index = query2.getIndex();
    }

    private void generateEventsForType(List<DataEvent> events, Event.EventType type, List<Change> changes, List<EventRegistration> eventRegistrations, IndexedNode eventCache) {
        List<Change> filteredChanges = new ArrayList<>();
        for (Change change : changes) {
            if (change.getEventType().equals(type)) {
                filteredChanges.add(change);
            }
        }
        Collections.sort(filteredChanges, changeComparator());
        for (Change change2 : filteredChanges) {
            for (EventRegistration registration : eventRegistrations) {
                if (registration.respondsTo(type)) {
                    events.add(generateEvent(change2, registration, eventCache));
                }
            }
        }
    }

    private DataEvent generateEvent(Change change, EventRegistration registration, IndexedNode eventCache) {
        Change newChange;
        if (change.getEventType().equals(Event.EventType.VALUE) || change.getEventType().equals(Event.EventType.CHILD_REMOVED)) {
            newChange = change;
        } else {
            newChange = change.changeWithPrevName(eventCache.getPredecessorChildName(change.getChildKey(), change.getIndexedNode().getNode(), this.index));
        }
        return registration.createEvent(newChange, this.query);
    }

    public List<DataEvent> generateEventsForChanges(List<Change> changes, IndexedNode eventCache, List<EventRegistration> eventRegistrations) {
        List<DataEvent> events = new ArrayList<>();
        List<Change> moves = new ArrayList<>();
        for (Change change : changes) {
            if (change.getEventType().equals(Event.EventType.CHILD_CHANGED) && this.index.indexedValueChanged(change.getOldIndexedNode().getNode(), change.getIndexedNode().getNode())) {
                moves.add(Change.childMovedChange(change.getChildKey(), change.getIndexedNode()));
            }
        }
        generateEventsForType(events, Event.EventType.CHILD_REMOVED, changes, eventRegistrations, eventCache);
        generateEventsForType(events, Event.EventType.CHILD_ADDED, changes, eventRegistrations, eventCache);
        generateEventsForType(events, Event.EventType.CHILD_MOVED, moves, eventRegistrations, eventCache);
        generateEventsForType(events, Event.EventType.CHILD_CHANGED, changes, eventRegistrations, eventCache);
        generateEventsForType(events, Event.EventType.VALUE, changes, eventRegistrations, eventCache);
        return events;
    }

    private Comparator<Change> changeComparator() {
        return new Comparator<Change>() {
            /* class com.google.firebase.database.core.view.EventGenerator.AnonymousClass1 */
            static final /* synthetic */ boolean $assertionsDisabled = false;

            public int compare(Change a, Change b) {
                return EventGenerator.this.index.compare(new NamedNode(a.getChildKey(), a.getIndexedNode().getNode()), new NamedNode(b.getChildKey(), b.getIndexedNode().getNode()));
            }
        };
    }
}
