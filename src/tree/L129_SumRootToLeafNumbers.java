package tree;

import java.util.LinkedList;
import java.util.Queue;

public class L129_SumRootToLeafNumbers {
    /**
     * dfs
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    /**
     * BFS
     */
    class NodeNumPair {
        TreeNode node;
        int currentNum;

        NodeNumPair(TreeNode node, int currentNum) {
            this.node = node;
            this.currentNum = currentNum;
        }
    }
    public int sumNumbersBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int totalSum = 0;
        // Queue stores pairs of (node, current_number_from_root)
        Queue<NodeNumPair> queue = new LinkedList<>();
        queue.offer(new NodeNumPair(root, root.val));
        while (!queue.isEmpty()) {
            NodeNumPair pair = queue.poll();
            TreeNode node = pair.node;
            int currentNum = pair.currentNum;
            // If it's a leaf node, add the number to total sum
            if (node.left == null && node.right == null) {
                totalSum += currentNum;
            }
            // Add children to queue with updated numbers
            if (node.left != null) {
                int newNum = currentNum * 10 + node.left.val;
                queue.offer(new NodeNumPair(node.left, newNum));
            }
            if (node.right != null) {
                int newNum = currentNum * 10 + node.right.val;
                queue.offer(new NodeNumPair(node.right, newNum));
            }
        }
        return totalSum;
    }
}
