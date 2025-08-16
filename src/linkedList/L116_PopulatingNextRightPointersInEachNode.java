package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class L116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            while (size-- > 0) {
                Node curr = queue.poll();
                if (prev != null) prev.next = curr;
                curr.next = null;
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                prev = curr;
            }
        }

        return root;
    }

    class Node {
        int val;
        Node next;
        Node left;
        Node right;

    }
}
