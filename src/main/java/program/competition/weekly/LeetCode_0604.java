package program.competition.weekly;

import java.util.*;

public class LeetCode_0604 {
    public static void main(String[] args) {
        LeetCode_0604 main = new LeetCode_0604();

        int[] nums = new int[]{1, 3, 4, 2, 5};
        int i = main.semiOrderedPermutation(nums);
        System.out.println(i);
    }


    public long matrixSumQueries2(int n, int[][] queries) {
        Map<Integer, Long> rowMap = new HashMap<>();
        Map<Integer, Long> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            rowMap.put(i, 0L);
            colMap.put(i, 0L);
        }

        long res = 0;
        for (int[] query : queries) {
            int type = query[0];
            int index = query[1];
            long val = query[2];

            if (type == 0) {
                long rowSum = val * n;
                res = res - rowMap.get(index) + rowSum;
                rowMap.put(index, rowSum);
                colMap.replaceAll((k, v) -> v + val - v / n);
            }

            if (type == 1) {
                long colSum = val * n;
                res = res - colMap.get(index) + colSum;
                colMap.put(index, colSum);
                rowMap.replaceAll((k, v) -> v + val - v / n);
            }
        }

        return res;
    }

    public long matrixSumQueries(int n, int[][] queries) {
        int[][] array = new int[n][n];
        long res = 0;
        for (int[] query : queries) {
            int type = query[0];
            int index = query[1];
            int val = query[2];

            if (type == 0) {
                for (int col = 0; col < n; col++) {
                    res = res - array[index][col] + val;
                    array[index][col] = val;
                }
            }
            if (type == 1) {
                for (int row = 0; row < n; row++) {
                    res = res - array[row][index] + val;
                    array[row][index] = val;
                }
            }
        }

        return res;
    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                min = i;
            }
            if (nums[i] == n) {
                max = i;
            }
        }

        int res = min + (n - 1 - max);
        return min < max ? res : res - 1;
    }

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }
}
