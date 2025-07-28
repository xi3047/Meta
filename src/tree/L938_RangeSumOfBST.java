package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L938_RangeSumOfBST {
    int sum = 0;
    /*
    Solution 1: DFS with O(n) time
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) sum += root.val;
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }

    /*
    Solution 2: Recursion with pre-order traversal
    O(logn) in case of balanced bst
     */
    public int rangeSum2(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            // Node value is too small, ignore left subtree
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            // Node value is too large, ignore right subtree
            return rangeSumBST(root.left, low, high);
        } else {
            // Node is in range, include it and check both subtrees
            return root.val
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }

    /*
    Solution 3: Iterative using stack
     */
    public int rangeSum3(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.val >= low && node.val <= high) sum += node.val;

            if (node.val > low) {
                stack.push(node.left);
            }
            if (node.val < high) {
                stack.push(node.right);
            }
        }
        return sum;
    }

    /**
     * 10^4 calls will be made rangeSumBST
     * Pre-compute the whole tree to get prefix sum
     * then use binary search to find lower and upper bound
     * range in values is [upper  -> lower - 1]
     * which translates to prefixSum of upper + 1 -> lower
     */
    List<Integer> vals;
    List<Integer> prefixSum;

    public int rangeSumBSTHard(TreeNode root, int low, int high) {
        vals = new ArrayList<>();
        prefixSum = new ArrayList<>();
        prefixSum.add(0);
        inorder(root);
        int lower = findLower(0, vals.size() - 1, low);
        int upper = findUpper(0, vals.size() - 1, high);
        return prefixSum.get(upper + 1) - prefixSum.get(lower);
    }

    private int findLower(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (vals.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findUpper(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (vals.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        vals.add(root.val);
        int size = prefixSum.size();
        prefixSum.add(prefixSum.get(size - 1) + root.val);
        inorder(root.right);
    }
}
