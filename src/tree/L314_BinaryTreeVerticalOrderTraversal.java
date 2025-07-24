package tree;

import java.util.*;

/**
 * Problem: vertical order of Binary Tree
 * Need a node-column relationship pair
 * need a map of Columns to all the treeNode with that column
 * BFS the tree, either keep a minColumn or store in a TreeMap
 */
public class L314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        //column to list of treeNode map
        Map<Integer, List<Integer>> map = new HashMap<>();
        //queue for traversal
        Queue<Node> queue = new LinkedList<>();
        // column map
        queue.offer(new Node(root, 0));
        int min = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode cur = node.treeNode;
            int curColumn = node.col;
            map.putIfAbsent(curColumn, new ArrayList<>());
            map.get(curColumn).add(cur.val);
            if (cur.left != null) {
                queue.offer(new Node(cur.left, curColumn - 1));
                min = Math.min(min, curColumn - 1);
            }
            if (cur.right != null) {
                queue.offer(new Node(cur.right, curColumn + 1));
            }
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }

    class Node {
        TreeNode treeNode;
        int col;

        Node(TreeNode treeNode, int col) {
            this.treeNode = treeNode;
            this.col = col;
        }
    }
}
