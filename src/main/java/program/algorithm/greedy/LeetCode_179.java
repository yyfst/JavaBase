package program.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_179 {
    public static void main(String[] args) {
        LeetCode_179 main = new LeetCode_179();
        int[] nums = {10, 2, 0, 1};
        System.out.println(main.largestNumber(nums));

    }

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String res = String.join("", s);
        return res.charAt(0) == '0' ? "0" : res;
    }
}
