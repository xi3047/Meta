package array;

import java.util.Stack;

public class L735_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // 如果栈为空，或者当前小行星向右移动，或者栈顶小行星向左移动，
            // 则不会发生碰撞，直接将当前小行星压入栈
            if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0) {
                stack.push(asteroid);
                continue; // 处理下一个小行星
            }

            // 此时，我们确定 stack.peek() > 0 并且 asteroid < 0，碰撞开始
            // 使用一个while循环来处理连续碰撞，直到当前小行星被摧毁或幸存
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                // 栈顶小行星较小，它爆炸。继续用当前小行星检查新的栈顶
                stack.pop();
            }

            // 碰撞循环结束后，有三种可能：
            // 1. 栈已空 或 栈顶小行星向左：说明当前小行星摧毁了所有前面的小行星，它幸存
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
            // 2. 栈顶小行星大小和当前小行星相等：两者都爆炸
            else if (stack.peek() == Math.abs(asteroid)) {
                stack.pop();
            }
            // 3. 栈顶小行星更大：当前小行星被摧毁，什么也不做
            // (此处无需else，因为当前小行星已被摧毁，无需任何操作)
        }

        // 将栈中的结果转换为数组，并保证顺序正确
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
