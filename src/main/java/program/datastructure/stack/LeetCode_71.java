package program.datastructure.stack;

import java.util.Objects;
import java.util.Stack;

public class LeetCode_71 {
    public static void main(String[] args) {
        LeetCode_71 main = new LeetCode_71();
        String path = "/..";
        System.out.println(main.simplifyPath(path));


    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String cur = "";
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c != '/') {
                cur += c;
                continue;
            }

            if (cur.equals(".")) {
                ;
            } else if (cur.equals("..")) {
                if (stack.size() > 1) {
                    stack.pop();
                }
                stack.pop();
            } else if (!cur.equals("")) {
                stack.push(cur);
            }

            if (stack.isEmpty() || !Objects.equals(stack.peek(), "/")) {
                stack.push(String.valueOf(c));
            }
            cur = "";
        }

        if (cur.equals("..")) {
            if (stack.size() > 1) {
                stack.pop();
                stack.pop();
            }
            cur = "";
        }

        if (!cur.equals("") && !cur.equals(".")) {
            stack.push(cur);
        }

        if (stack.size() > 1 && Objects.equals(stack.peek(), "/")) {
            stack.pop();
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();

    }
}
