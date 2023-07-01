package program.algorithm.greedy;

import java.util.*;

public class LeetCode_316 {
    public static void main(String[] args) {
        LeetCode_316 main = new LeetCode_316();
        String s = "bbcaac";
        System.out.println(main.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() > c) {
                char peek = stack.peekLast();
                if (map.get(peek) == 1) {
                    break;
                }
                stack.removeLast();
                map.put(peek, map.get(peek) - 1);
                set.remove(peek);
            }
            stack.addLast(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
