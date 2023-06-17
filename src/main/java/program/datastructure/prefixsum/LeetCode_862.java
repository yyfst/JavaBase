package program.datastructure.prefixsum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.LongToIntFunction;

public class LeetCode_862 {
    public static void main(String[] args) {
        LeetCode_862 main = new LeetCode_862();
        int[] nums = {-1};
        int k = 1;
        System.out.println(main.shortestSubarray(nums, k));

    }

    public int shortestSubarray(int[] nums, int k) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int res = preSum.length + 1;
        for (int i = 0; i < preSum.length; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= k) {
                res = Math.min(res, i - deque.removeFirst());
            }
            while (!deque.isEmpty() && preSum[i] < preSum[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return res == preSum.length + 1 ? -1 : res;
    }
}
