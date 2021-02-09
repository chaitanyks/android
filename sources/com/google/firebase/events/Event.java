package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
public class Event<T> {
    private final T payload;
    private final Class<T> type;

    public Event(Class<T> type2, T payload2) {
        this.type = (Class) Preconditions.checkNotNull(type2);
        this.payload = (T) Preconditions.checkNotNull(payload2);
    }

    public Class<T> getType() {
        return this.type;
    }

    public T getPayload() {
        return this.payload;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.type, this.payload);
    }
}
