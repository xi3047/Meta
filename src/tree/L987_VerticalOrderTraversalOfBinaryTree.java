package tree;

import java.util.*;

public class L987_VerticalOrderTraversalOfBinaryTree {
    /**
     * * Need to sort the node if same row and same col * *
     * Use a pair to track cur row and col of the tree node
     * use 2 treemap, outer tree map is to sort the columns
     * inner treemap is to sort the rows, and a minHeap to sort node with same row and same col
     * BFS the tree
     * Time Complexity: O(n log C) where c is number of unique columns, worst case O(n log n) of degenerate tree
     * Space Complexity: O (N)
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode curNode = node.treeNode;
            int row = node.row, col = node.col;
            map.computeIfAbsent(col, x -> new TreeMap<>())
                    .computeIfAbsent(row, x -> new PriorityQueue<>())
                    .offer(curNode.val);

            if (curNode.left != null) {
                queue.offer(new Node(curNode.left, row + 1, col - 1));
            }
            if (curNode.right != null) {
                queue.offer(new Node(curNode.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> colMap : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : colMap.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            res.add(colList);
        }
        return res;
    }

    class Node {
        TreeNode treeNode;
        int row, col;

        Node(TreeNode node, int r, int c) {
            treeNode = node;
            row = r;
            col = c;
        }
    }

}
