package program.datastructure.stackmonotonic;

import java.util.Stack;

public class LeetCode_581 {
    public static void main(String[] args) {
        LeetCode_581 main = new LeetCode_581();

        int[] nums = new int[]{2,6,4,8,10,9,15};
        int res = main.findUnsortedSubarray(nums);
        System.out.println(res);
    }

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int peek = stack.pop();
                left = Math.min(left, peek);
            }
            stack.push(i);
        }

        stack.clear();
        int right = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int peek = stack.pop();
                right = Math.max(right, peek);
            }
            stack.push(i);
        }
        return right > left ? right - left + 1 : 0;
    }
}
