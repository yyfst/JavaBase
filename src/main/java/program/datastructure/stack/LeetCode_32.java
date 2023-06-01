package program.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_32 {
    public static void main(String[] args) {
        LeetCode_32 main = new LeetCode_32();
        int res = main.longestValidParentheses("(()");
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> stack.push(i);
                case ')' -> {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }

        return res;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> left++;
                case ')' -> right++;
            }
            if (left == right) {
                res = Math.max(res, left + right);
            }
            if (left < right) {
                right = 0;
                left = 0;
            }
        }

        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case '(' -> left++;
                case ')' -> right++;
            }
            if (left == right) {
                res = Math.max(res, left + right);
            }
            if (left > right) {
                right = 0;
                left = 0;
            }
        }
        return res;
    }

    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        StringBuilder sb1 = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> left++;
                case ')' -> right++;
            }
            if (left >= right) {
                sb1.append(s.charAt(i));
            } else {
                right = 0;
                left = 0;
                list.add(sb1.toString());
                sb1 = new StringBuilder();
            }
        }

        list.add(sb1.toString());
        String res = "";
        for (String string : list) {
            left = 0;
            right = 0;
            sb1 = new StringBuilder();
            for (int i = string.length() - 1; i >= 0; i--) {
                switch (string.charAt(i)) {
                    case ')' -> right++;
                    case '(' -> left++;
                }
                if (right >= left) {
                    sb1.insert(0, string.charAt(i));
                } else {
                    right = 0;
                    left = 0;
                    res = sb1.length() > res.length() ? sb1.toString() : res;
                    sb1 = new StringBuilder();
                }
            }
            res = sb1.length() > res.length() ? sb1.toString() : res;
        }
        return res.length();
    }
}
