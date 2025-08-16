package tree;

import java.util.Stack;

public class L173_BinarySearchTreeIterator {
    /**
     * Use a stack to simulate recursion
     * always push left children to stack
     * when next() pop top of stack, if it has right child, push all its left children to stack
     * on hasNext() just check if stack is empty
     */
    class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode top = stack.pop();
            TreeNode cur = top.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return top.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
