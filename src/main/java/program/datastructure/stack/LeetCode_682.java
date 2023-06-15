package program.datastructure.stack;

import java.util.Stack;

public class LeetCode_682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String operation : operations) {
            switch (operation) {
//                case "+" -> {
//                    int tmp = stack.pop();
//                    int sum = tmp + stack.peek();
//                    stack.push(tmp);
//                    stack.push(sum);
//                    res += stack.peek();
//                }
//                case "D" -> {
//                    stack.push(2 * stack.peek());
//                    res += stack.peek();
//                }
//                case "C" -> {
//                    res -= stack.pop();
//                }
//                default -> {
//                    stack.push(Integer.valueOf(operation));
//                    res += stack.peek();
//                }
            }
        }
        return res;
    }
}