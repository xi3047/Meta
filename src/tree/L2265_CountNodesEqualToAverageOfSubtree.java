package tree;

public class L2265_CountNodesEqualToAverageOfSubtree {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
    private SubtreeInfo dfs(TreeNode node) {
        if (node == null) return new SubtreeInfo(0, 0);

        SubtreeInfo left = dfs(node.left);
        SubtreeInfo right = dfs(node.right);

        int sum = left.sum + right.sum + node.val;
        int count = left.count + right.count + 1;

        if (node.val == sum / count) {
            result++;
        }
        return new SubtreeInfo(sum, count);
    }
    class SubtreeInfo {
        int sum;
        int count;
        SubtreeInfo (int s, int c) {
            sum = s;
            count = c;
        }
    }
    /**
     * Variant: Return a boolean indicating if in every subtree,
     *          root is equal to average of all nodes in that subtree
     */
    public boolean isSubtreeAverage(TreeNode root) {
        SubtreeInfo info = checkDFS(root);
        return info.sum != -1;
    }

    private SubtreeInfo checkDFS(TreeNode node) {
        if (node == null) return new SubtreeInfo(0, 0);

        SubtreeInfo left = dfs(node.left);
        SubtreeInfo right = dfs(node.right);

        if (left.sum == -1 || right.sum == -1) {
            return new SubtreeInfo(-1 , -1);
        }

        int sum = left.sum + right.sum + node.val;
        int count = left.count + right.count + 1;

        if (node.val != sum / count) {
            return new SubtreeInfo(-1, -1);
        }
        return new SubtreeInfo(sum, count);
    }
}
