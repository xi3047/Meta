package tree;

import java.util.HashSet;
import java.util.Set;

public class L1650_LCA_III_parent {
    /**
     * with parent pointers, use a set
     */
    public Node lowestCommonAncestorParent(Node p, Node q) {
        Set<Node> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (ancestors.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }
    /**
     * Use two pointers
     */
    public Node lowestCommonAncestor2(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b){
            if (a.parent != null) {
                a = a.parent;
            } else {
                a = q;
            }
            if (b.parent != null) {
                b = b.parent;
            } else {
                b = p;
            }
        }
        return b;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
