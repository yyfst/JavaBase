package program.algorithm.dp;

import lombok.extern.slf4j.Slf4j;
import program.algorithm.ProgramSolution;

@Slf4j
public class Knapsack extends ProgramSolution {
    @Override
    protected void solution() {
        // 输出30
        int[] volume = {2, 5, 4, 2, 3};
        int[] worth = {6, 3, 5, 4, 6};
        int capacity = 10;
        int maxWorth = process(volume, worth, capacity);
        log.info("max worth is: {}", maxWorth);
    }

    // 完全背包
    private int process(int[] volume, int[] worth, int capacity) {
        int n = volume.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = volume[i - 1]; j <= capacity; j++) {
                int tmp = dp[j - volume[i - 1]] + worth[i - 1];
                dp[j] = Math.max(dp[j], tmp);
            }
        }
        return dp[capacity];
    }

    // 多重背包
    private int process3(int[] volume, int[] worth, int[] number, int capacity) {
        int n = volume.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j > 0; j--) {
                for (int k = 1; k <= number[i - 1] && k * volume[i - 1] <= j; k++) {
                    int tmp = dp[j - k * volume[i - 1]] + k * worth[i - 1];
                    dp[j] = Math.max(dp[j], tmp);
                }
            }
        }
        return dp[capacity];
    }

    private int process2(int[][] volume, int[][] worth, int capacity) {
        int n = volume.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j > 0; j--) {
                // 最后一层循环遍历所有第i个物品,重复给dp[j]赋值
                for (int k = 1; k <= volume[i - 1].length; k++) {
                    if (j >= volume[i - 1][k - 1]) {
                        int tmp = dp[j - volume[i - 1][k - 1]] + worth[i - 1][k - 1];
                        dp[j] = Math.max(dp[j], tmp);
                    }
                }
            }
        }
        return dp[capacity];
    }

    // 01背包
    // 从代码规范上来讲,要对数组元素判断是否为正数
    private int process1(int[] volume, int[] worth, int capacity) {
        int n = volume.length;
        int[] dp = new int[capacity + 1];
//        Arrays.fill(dp, 0);
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= volume[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - volume[i - 1]] + worth[i - 1]);
            }
        }
        return dp[capacity];
    }
}
