package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class MutableData {
    private final SnapshotHolder holder;
    private final Path prefixPath;

    MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    private MutableData(SnapshotHolder holder2, Path path) {
        this.holder = holder2;
        this.prefixPath = path;
        ValidationPath.validateWithObject(path, getValue());
    }

    /* access modifiers changed from: package-private */
    public Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    public boolean hasChildren() {
        Node node = getNode();
        return !node.isLeafNode() && !node.isEmpty();
    }

    public boolean hasChild(String path) {
        return !getNode().getChild(new Path(path)).isEmpty();
    }

    public MutableData child(String path) {
        Validation.validatePathString(path);
        return new MutableData(this.holder, this.prefixPath.child(new Path(path)));
    }

    public long getChildrenCount() {
        return (long) getNode().getChildCount();
    }

    public Iterable<MutableData> getChildren() {
        Node node = getNode();
        if (node.isEmpty() || node.isLeafNode()) {
            return new Iterable<MutableData>() {
                /* class com.google.firebase.database.MutableData.AnonymousClass1 */

                @Override // java.lang.Iterable
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>() {
                        /* class com.google.firebase.database.MutableData.AnonymousClass1.AnonymousClass1 */

                        public boolean hasNext() {
                            return false;
                        }

                        @Override // java.util.Iterator
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }
                    };
                }
            };
        }
        final Iterator<NamedNode> iter = IndexedNode.from(node).iterator();
        return new Iterable<MutableData>() {
            /* class com.google.firebase.database.MutableData.AnonymousClass2 */

            @Override // java.lang.Iterable
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() {
                    /* class com.google.firebase.database.MutableData.AnonymousClass2.AnonymousClass1 */

                    public boolean hasNext() {
                        return iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public MutableData next() {
                        return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) iter.next()).getName()));
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }
                };
            }
        };
    }

    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    public Object getValue() {
        return getNode().getValue();
    }

    public <T> T getValue(Class<T> valueType) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), valueType);
    }

    public <T> T getValue(GenericTypeIndicator<T> t) {
        return (T) CustomClassMapper.convertToCustomClass(getNode().getValue(), t);
    }

    public void setValue(Object value) throws DatabaseException {
        ValidationPath.validateWithObject(this.prefixPath, value);
        Object bouncedValue = CustomClassMapper.convertToPlainJavaTypes(value);
        Validation.validateWritableObject(bouncedValue);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(bouncedValue));
    }

    public void setPriority(Object priority) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, priority)));
    }

    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public boolean equals(Object o) {
        return (o instanceof MutableData) && this.holder.equals(((MutableData) o).holder) && this.prefixPath.equals(((MutableData) o).prefixPath);
    }

    public String toString() {
        ChildKey front = this.prefixPath.getFront();
        StringBuilder sb = new StringBuilder();
        sb.append("MutableData { key = ");
        sb.append(front != null ? front.asString() : "<none>");
        sb.append(", value = ");
        sb.append(this.holder.getRootNode().getValue(true));
        sb.append(" }");
        return sb.toString();
    }
}
