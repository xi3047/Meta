package tree;

import java.util.HashSet;
import java.util.Set;

public class L236_LCA {
    /**
     * It does a post-order traversal (left → right → node).
     * As it returns back up the recursion stack:
     * If both children return non-null, it means the current node is the LCA.
     * If only one child returns non-null, it bubbles up that result.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        else return right;
    }

    /**
     * LCA for BST
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root; // Split point, one is on the left, one on the right (or root is one of them)
            }
        }
        return null;
    }
}
