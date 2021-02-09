package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class Overwrite extends Operation {
    private final Node snapshot;

    public Overwrite(OperationSource source, Path path, Node snapshot2) {
        super(Operation.OperationType.Overwrite, source, path);
        this.snapshot = snapshot2;
    }

    public Node getSnapshot() {
        return this.snapshot;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Operation operationForChild(ChildKey childKey) {
        if (this.path.isEmpty()) {
            return new Overwrite(this.source, Path.getEmptyPath(), this.snapshot.getImmediateChild(childKey));
        }
        return new Overwrite(this.source, this.path.popFront(), this.snapshot);
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", getPath(), getSource(), this.snapshot);
    }
}
