package string;

import java.util.Stack;

public class L20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty() || !isPair(stack.pop(), c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(Character a, Character b) {
        if (a == '(') return b == ')';
        if (a == '[') return b == ']';
        if (a == '{') return b == '}';
        return false;
    }
}
