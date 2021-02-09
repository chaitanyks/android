package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class CancelEvent implements Event {
    private final DatabaseError error;
    private final EventRegistration eventRegistration;
    private final Path path;

    public CancelEvent(EventRegistration eventRegistration2, DatabaseError error2, Path path2) {
        this.eventRegistration = eventRegistration2;
        this.path = path2;
        this.error = error2;
    }

    @Override // com.google.firebase.database.core.view.Event
    public Path getPath() {
        return this.path;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void fire() {
        this.eventRegistration.fireCancelEvent(this.error);
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        return getPath() + ":CANCEL";
    }
}
