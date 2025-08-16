package tree;

public class L270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            int cur = root.val;
            if (Math.abs(cur - target) < Math.abs(closest - target)
                    || Math.abs(cur - target) == Math.abs(closest - target) && cur < closest) {
                closest = cur;
            }
            root = target < cur ? root.left : root.right;
        }
        return closest;
    }
}
