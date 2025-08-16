package tree;

import java.util.Stack;

public class L536_ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-') {
                sign = -1;
            } else if (Character.isDigit(ch)) { //process number
                num = num * 10 + (ch - '0');
                // check if this is the end of a number and create a new node
                if (i + 1 == s.length() || !Character.isDigit(s.charAt(i + 1))) {
                    TreeNode node = new TreeNode(num * sign);
                    sign = 1;
                    num = 0;

                    // attach the new node to the tree
                    if (!stack.isEmpty())  {
                        TreeNode parent = stack.peek();
                        if (parent.left == null) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                    }
                    stack.push(node);
                }
            }
            else if (ch == ')')
            { // done processing a child
                stack.pop();
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
}
