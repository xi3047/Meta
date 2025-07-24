package string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
 * Summary:
 * Removes the minimum number of parentheses to make a string valid (i.e., balanced).
 *
 * Explanation:
 * - Use a stack to track unmatched opening parentheses indices.
 * - If a closing parenthesis can't be matched (stack is empty), mark its index for removal.
 * - After traversal, any indices left in the stack unmatched '(' are also marked for removal.
 * - Finally, construct the result string excluding all marked indices.
 *
 * Example:
 * Input:  "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Run:
 * String result = new Solution().minRemoveToMakeValid("a)b(c)d"); // returns "ab(c)d"
 */
public class L1249_MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indicesToRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    indicesToRemove.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            indicesToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indicesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
