package program.datastructure.stackmonotonic;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_503 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3,4,3
        };

        LeetCode_503 main = new LeetCode_503();
        int[] ints = main.nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));

    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = 2 * nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = n; i >= 0; i--) {
            int index = i % nums.length;
            int data = nums[index];
            while (!stack.isEmpty() && stack.peek() <= data) {
                stack.pop();
            }
            res[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(data);
        }
        return res;
    }
}
