package com.google.firebase.database.core.utilities;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class OffsetClock implements Clock {
    private final Clock baseClock;
    private long offset = 0;

    public OffsetClock(Clock baseClock2, long offset2) {
        this.baseClock = baseClock2;
        this.offset = offset2;
    }

    public void setOffset(long offset2) {
        this.offset = offset2;
    }

    @Override // com.google.firebase.database.core.utilities.Clock
    public long millis() {
        return this.baseClock.millis() + this.offset;
    }
}
