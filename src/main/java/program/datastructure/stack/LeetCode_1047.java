package program.datastructure.stack;

import java.util.Stack;

public class LeetCode_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) == stack.peek()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
