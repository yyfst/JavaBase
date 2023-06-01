package program.datastructure.stackmonotonic;

import java.util.Stack;

public class LeetCode_962 {
    public static void main(String[] args) {
        LeetCode_962 main = new LeetCode_962();

        int[] nums = new int[]{9,8,1,0,1,9,4,0,4,1};
        int res = main.maxWidthRamp(nums);
        System.out.println(res);
    }

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }

    // 暴力
    public int maxWidthRamp1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
