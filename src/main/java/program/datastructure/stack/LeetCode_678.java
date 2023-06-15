package program.datastructure.stack;

import org.w3c.dom.css.CSSPrimitiveValue;

import java.util.Stack;

public class LeetCode_678 {
    public static void main(String[] args) {
        LeetCode_678 main = new LeetCode_678();
        String s = "(((((*(((((*********((*(";
        boolean b = main.checkValidString(s);
        System.out.println(b);
    }

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
//                case '(' -> stack.push(i);
//                case '*' -> starStack.push(i);
//                case ')' -> {
//                    if (!stack.isEmpty()) {
//                        stack.pop();
//                    } else {
//                        if (!starStack.isEmpty()) {
//                            starStack.pop();
//                        } else {
//                            return false;
//                        }
//                    }
//                }
            }
        }

        while (!stack.isEmpty() && !starStack.isEmpty()) {
            if (starStack.peek() <= stack.peek()) {
                return false;
            }
            stack.pop();
            starStack.pop();
        }

        return stack.isEmpty();
    }
}
