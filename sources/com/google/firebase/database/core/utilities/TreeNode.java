package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    /* access modifiers changed from: package-private */
    public String toString(String prefix) {
        String result = prefix + "<value>: " + ((Object) this.value) + "\n";
        if (this.children.isEmpty()) {
            return result + prefix + "<empty>";
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(result);
            sb.append(prefix);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(entry.getValue().toString(prefix + "\t"));
            sb.append("\n");
            result = sb.toString();
        }
        return result;
    }
}
