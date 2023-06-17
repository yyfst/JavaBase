package program.datastructure.prefixsum;

public class LeetCode_1413 {
    public static void main(String[] args) {

    }

    public int minStartValue(int[] nums) {
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if (min < 0) {
            return 1 - min;
        }
        return 1;
    }
}
