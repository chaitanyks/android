package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@19.2.1 */
public class Tree<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ChildKey name;
    private TreeNode<T> node;
    private Tree<T> parent;

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface TreeFilter<T> {
        boolean filterTreeNode(Tree<T> tree);
    }

    /* compiled from: com.google.firebase:firebase-database@@19.2.1 */
    public interface TreeVisitor<T> {
        void visitTree(Tree<T> tree);
    }

    public Tree(ChildKey name2, Tree<T> parent2, TreeNode<T> node2) {
        this.name = name2;
        this.parent = parent2;
        this.node = node2;
    }

    public Tree() {
        this(null, null, new TreeNode());
    }

    public TreeNode<T> lastNodeOnPath(Path path) {
        TreeNode<T> current = this.node;
        ChildKey next = path.getFront();
        while (next != null) {
            TreeNode<T> childNode = current.children.containsKey(next) ? current.children.get(next) : null;
            if (childNode == null) {
                return current;
            }
            current = childNode;
            path = path.popFront();
            next = path.getFront();
        }
        return current;
    }

    public Tree<T> subTree(Path path) {
        Tree<T> child = this;
        ChildKey next = path.getFront();
        while (next != null) {
            child = new Tree<>(next, child, child.node.children.containsKey(next) ? child.node.children.get(next) : new TreeNode<>());
            path = path.popFront();
            next = path.getFront();
        }
        return child;
    }

    public T getValue() {
        return this.node.value;
    }

    public void setValue(T value) {
        this.node.value = value;
        updateParents();
    }

    public Tree<T> getParent() {
        return this.parent;
    }

    public ChildKey getName() {
        return this.name;
    }

    public Path getPath() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            return tree.getPath().child(this.name);
        }
        if (this.name == null) {
            return Path.getEmptyPath();
        }
        return new Path(this.name);
    }

    public boolean hasChildren() {
        return !this.node.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.node.value == null && this.node.children.isEmpty();
    }

    public void forEachDescendant(TreeVisitor<T> visitor) {
        forEachDescendant(visitor, false, false);
    }

    public void forEachDescendant(TreeVisitor<T> visitor, boolean includeSelf) {
        forEachDescendant(visitor, includeSelf, false);
    }

    public void forEachDescendant(final TreeVisitor<T> visitor, boolean includeSelf, final boolean childrenFirst) {
        if (includeSelf && !childrenFirst) {
            visitor.visitTree(this);
        }
        forEachChild(new TreeVisitor<T>() {
            /* class com.google.firebase.database.core.utilities.Tree.AnonymousClass1 */

            @Override // com.google.firebase.database.core.utilities.Tree.TreeVisitor
            public void visitTree(Tree<T> tree) {
                tree.forEachDescendant(visitor, true, childrenFirst);
            }
        });
        if (includeSelf && childrenFirst) {
            visitor.visitTree(this);
        }
    }

    public boolean forEachAncestor(TreeFilter<T> filter) {
        return forEachAncestor(filter, false);
    }

    public boolean forEachAncestor(TreeFilter<T> filter, boolean includeSelf) {
        for (Tree<T> tree = includeSelf ? this : this.parent; tree != null; tree = tree.parent) {
            if (filter.filterTreeNode(tree)) {
                return true;
            }
        }
        return false;
    }

    public void forEachChild(TreeVisitor<T> visitor) {
        Object[] entries;
        for (Object obj : this.node.children.entrySet().toArray()) {
            Map.Entry<ChildKey, TreeNode<T>> entry = (Map.Entry) obj;
            visitor.visitTree(new Tree<>(entry.getKey(), this, entry.getValue()));
        }
    }

    private void updateParents() {
        Tree<T> tree = this.parent;
        if (tree != null) {
            tree.updateChild(this.name, this);
        }
    }

    private void updateChild(ChildKey name2, Tree<T> child) {
        boolean childEmpty = child.isEmpty();
        boolean childExists = this.node.children.containsKey(name2);
        if (childEmpty && childExists) {
            this.node.children.remove(name2);
            updateParents();
        } else if (!childEmpty && !childExists) {
            this.node.children.put(name2, child.node);
            updateParents();
        }
    }

    public String toString() {
        return toString("");
    }

    /* access modifiers changed from: package-private */
    public String toString(String prefix) {
        ChildKey childKey = this.name;
        String nodeName = childKey == null ? "<anon>" : childKey.asString();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(nodeName);
        sb.append("\n");
        TreeNode<T> treeNode = this.node;
        sb.append(treeNode.toString(prefix + "\t"));
        return sb.toString();
    }
}
