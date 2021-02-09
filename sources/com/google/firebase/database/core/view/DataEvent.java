package com.google.firebase.database.core.view;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.view.Event;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class DataEvent implements Event {
    private final EventRegistration eventRegistration;
    private final Event.EventType eventType;
    private final String prevName;
    private final DataSnapshot snapshot;

    public DataEvent(Event.EventType eventType2, EventRegistration eventRegistration2, DataSnapshot snapshot2, String prevName2) {
        this.eventType = eventType2;
        this.eventRegistration = eventRegistration2;
        this.snapshot = snapshot2;
        this.prevName = prevName2;
    }

    @Override // com.google.firebase.database.core.view.Event
    public Path getPath() {
        Path path = this.snapshot.getRef().getPath();
        if (this.eventType == Event.EventType.VALUE) {
            return path;
        }
        return path.getParent();
    }

    public DataSnapshot getSnapshot() {
        return this.snapshot;
    }

    public String getPreviousName() {
        return this.prevName;
    }

    public Event.EventType getEventType() {
        return this.eventType;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void fire() {
        this.eventRegistration.fireEvent(this);
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        if (this.eventType == Event.EventType.VALUE) {
            return getPath() + ": " + this.eventType + ": " + this.snapshot.getValue(true);
        }
        return getPath() + ": " + this.eventType + ": { " + this.snapshot.getKey() + ": " + this.snapshot.getValue(true) + " }";
    }
}
