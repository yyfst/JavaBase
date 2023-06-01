package program.datastructure.stackmonotonic;

import java.util.Stack;

public class LeetCode_1124 {
    public static void main(String[] args) {
        LeetCode_1124 main = new LeetCode_1124();
        int[] hours = new int[]{9};

        int res = main.longestWPI(hours);
        System.out.println(res);

    }

    public int longestWPI(int[] hours) {
        int res = 0;
        int left = hours[0] > 8 ? 1 : 0;
        int right = 0;

        for (int i = 1; i < hours.length; i++) {
            if (right < left) {
                res = Math.max(res, right + left);
            }

            if (hours[i] > 8 && hours[i - 1] <= 8) {
                left = 1;
                right = 0;
            }

            if (hours[i] > 8 && hours[i - 1] > 8) {
                left++;
            }

            if (hours[i] <= 8) {
                right++;
            }
        }

        if (right < left) {
            res = Math.max(res, right + left);
        }

        return res;
    }
}
