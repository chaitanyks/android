package com.google.firebase.database.core;

import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class ServerValues {
    public static final String NAME_OP_INCREMENT = "increment";
    public static final String NAME_OP_TIMESTAMP = "timestamp";
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";

    public static Map<String, Object> generateServerValues(Clock clock) {
        Map<String, Object> values = new HashMap<>();
        values.put("timestamp", Long.valueOf(clock.millis()));
        return values;
    }

    public static Object resolveDeferredValue(Object value, Node existing, Map<String, Object> serverValues) {
        if (!(value instanceof Map)) {
            return value;
        }
        Map mapValue = (Map) value;
        if (!mapValue.containsKey(NAME_SUBKEY_SERVERVALUE)) {
            return value;
        }
        Object op = mapValue.get(NAME_SUBKEY_SERVERVALUE);
        Object res = null;
        if (op instanceof String) {
            res = resolveScalarDeferredValue((String) op, existing, serverValues);
        } else if (op instanceof Map) {
            res = resolveComplexDeferredValue((Map) op, existing, serverValues);
        }
        if (res == null) {
            return value;
        }
        return res;
    }

    static Object resolveScalarDeferredValue(String op, Node existing, Map<String, Object> serverValues) {
        if (!"timestamp".equals(op) || !serverValues.containsKey(op)) {
            return null;
        }
        return serverValues.get(op);
    }

    static Object resolveComplexDeferredValue(Map<String, Object> op, Node existing, Map<String, Object> map) {
        if (!op.containsKey(NAME_OP_INCREMENT)) {
            return null;
        }
        Object incrObject = op.get(NAME_OP_INCREMENT);
        if (!(incrObject instanceof Number)) {
            return null;
        }
        Number increment = (Number) incrObject;
        if (!existing.isLeafNode() || !(existing.getValue() instanceof Number)) {
            return increment;
        }
        Number existingVal = (Number) existing.getValue();
        if (canBeRepresentedAsLong(increment) && canBeRepresentedAsLong(existingVal)) {
            long x = increment.longValue();
            long y = existingVal.longValue();
            long r = x + y;
            if (((x ^ r) & (y ^ r)) >= 0) {
                return Long.valueOf(r);
            }
        }
        return Double.valueOf(increment.doubleValue() + existingVal.doubleValue());
    }

    public static SparseSnapshotTree resolveDeferredValueTree(SparseSnapshotTree tree, final Node existing, final Map<String, Object> serverValues) {
        final SparseSnapshotTree resolvedTree = new SparseSnapshotTree();
        tree.forEachTree(new Path(""), new SparseSnapshotTree.SparseSnapshotTreeVisitor() {
            /* class com.google.firebase.database.core.ServerValues.AnonymousClass1 */

            @Override // com.google.firebase.database.core.SparseSnapshotTree.SparseSnapshotTreeVisitor
            public void visitTree(Path prefixPath, Node tree) {
                SparseSnapshotTree.this.remember(prefixPath, ServerValues.resolveDeferredValueSnapshot(tree, existing.getChild(prefixPath), serverValues));
            }
        });
        return resolvedTree;
    }

    public static Node resolveDeferredValueSnapshot(Node data, final Node existing, final Map<String, Object> serverValues) {
        Node priority = PriorityUtilities.parsePriority(resolveDeferredValue(data.getPriority().getValue(), existing.getPriority(), serverValues));
        if (data.isLeafNode()) {
            Object value = resolveDeferredValue(data.getValue(), existing, serverValues);
            if (!value.equals(data.getValue()) || !priority.equals(data.getPriority())) {
                return NodeUtilities.NodeFromJSON(value, priority);
            }
            return data;
        } else if (data.isEmpty()) {
            return data;
        } else {
            ChildrenNode childNode = (ChildrenNode) data;
            final SnapshotHolder holder = new SnapshotHolder(childNode);
            childNode.forEachChild(new ChildrenNode.ChildVisitor() {
                /* class com.google.firebase.database.core.ServerValues.AnonymousClass2 */

                @Override // com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor
                public void visitChild(ChildKey name, Node child) {
                    Node newChildNode = ServerValues.resolveDeferredValueSnapshot(child, Node.this.getImmediateChild(name), serverValues);
                    if (newChildNode != child) {
                        holder.update(new Path(name.asString()), newChildNode);
                    }
                }
            });
            if (!holder.getRootNode().getPriority().equals(priority)) {
                return holder.getRootNode().updatePriority(priority);
            }
            return holder.getRootNode();
        }
    }

    public static CompoundWrite resolveDeferredValueMerge(CompoundWrite merge, Node existing, Map<String, Object> serverValues) {
        CompoundWrite write = CompoundWrite.emptyWrite();
        Iterator<Map.Entry<Path, Node>> it = merge.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> entry = it.next();
            write = write.addWrite(entry.getKey(), resolveDeferredValueSnapshot(entry.getValue(), existing.getChild(entry.getKey()), serverValues));
        }
        return write;
    }

    private static boolean canBeRepresentedAsLong(Number x) {
        return !(x instanceof Double) && !(x instanceof Float);
    }
}
