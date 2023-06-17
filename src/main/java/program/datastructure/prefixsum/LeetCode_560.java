package program.datastructure.prefixsum;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_560 {
    public static void main(String[] args) {
        LeetCode_560 main = new LeetCode_560();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(main.subarraySum(nums, k));

    }


    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int res = 0;
        for (int i = 0; i < pre.length; i++) {
            for (int j = i + 1; j < pre.length; j++) {
                if (pre[j] - pre[i] == k) {
                    res++;
                }
            }
        }
        return res;

    }
}
