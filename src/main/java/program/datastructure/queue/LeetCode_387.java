package program.datastructure.queue;

import java.util.HashMap;
import java.util.Map;

// 队列不是最好的解决方法
public class LeetCode_387 {
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = map.get(c);
            if (value == 1) {
                return i;
            }
        }
        return -1;
    }
}
