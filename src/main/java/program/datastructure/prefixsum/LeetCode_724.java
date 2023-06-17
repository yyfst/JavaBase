package program.datastructure.prefixsum;

public class LeetCode_724 {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                int left = preSum[j - 1] - preSum[i];
                int right = (j == preSum.length - 2) ? preSum[preSum.length - 1] : (preSum[preSum.length - 1] - preSum[j + 2]);
                if (left == right) {
                    return j;
                }
            }
        }

        return -1;

    }
}
