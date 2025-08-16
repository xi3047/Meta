package tree;

import java.util.ArrayList;
import java.util.List;

public class L545_BinaryTreeBoundary {
    List<Integer> res = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        dfsLeft(root.left);
        addLeaves(root);
        dfsRight(root.right);
        return res;
    }

    private void addLeaves(TreeNode node) {
        if (node == null) return;
        if (isLeaf(node)) res.add(node.val);
        addLeaves(node.left);
        addLeaves(node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void dfsLeft(TreeNode node) {
        if (node == null || isLeaf(node)) return;
        res.add(node.val);

        if (node.left != null) {
            dfsLeft(node.left);
        } else {
            dfsLeft(node.right);
        }
    }

    private void dfsRight(TreeNode node) {
        if (node == null || isLeaf(node)) return;

        if (node.right != null) {
            dfsRight(node.right);
        } else {
            dfsRight(node.left);
        }
        res.add(node.val);
    }
}
