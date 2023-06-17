package program.datastructure.prefixsum;

public class LeetCode_209 {
    public static void main(String[] args) {
        LeetCode_209 main = new LeetCode_209();
        int[] nums = {1, 2, 3, 4, 5};
        int i = main.minSubArrayLen(11, nums);
        System.out.println(i);

    }

    public int minSubArrayLen(int target, int[] nums) {
        int[] pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        int res = nums.length + 1;
        for (int i = 0; i < pre.length; i++) {
            for (int j = i + 1; j < pre.length; j++) {
                if (pre[j] - pre[i] >= target) {
                    res = Math.min(res, j - i);
                }
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }
}
