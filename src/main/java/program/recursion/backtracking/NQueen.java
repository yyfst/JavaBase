package program.recursion.backtracking;

import lombok.extern.slf4j.Slf4j;

/**
 * n皇后问题
 */
@Slf4j
public class NQueen {
    private static int num = 0;

    public static void main(String[] args) {
        search();
    }

    private static void search() {
        for (int i = 1; i <= 20; i++) {

            int[] row1 = new int[i + 1];
            int[][] state = new int[3][2 * i + 1];
            num = 0;
            long start = System.currentTimeMillis();
            search1(1, i, row1);
            long end = System.currentTimeMillis();
            long time1 = end - start;
            int a = num;
            num = 0;
            int[] row2 = new int[i + 1];
            start = System.currentTimeMillis();
            search2(1, i, row2, state);
            end = System.currentTimeMillis();
            long time2 = end - start;
            int b = num;

            log.info("queens: {}, num1: {}, num2: {}, time: {}, time2: {}", i, a, b, time1, time2);
        }
    }

    private static void search1(int cur, int n, int[] row) {
        if (cur == n + 1) {
            num++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            boolean ok = true;
            for (int i = 1; i < cur; i++) {
                // (i, row[i])与(cur, j)是否在同列、同行、对角线
                if (row[i] == j || j - cur == row[i] - i || j + cur == row[i] + i) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                row[cur] = j;
                search1(cur + 1, n, row);
            }
        }
    }

    private static void search2(int cur, int n, int[] row, int[][] state) {
        if (cur == n + 1) {
            num++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (state[0][j] == 1 || state[1][j - cur + n] == 1 || state[2][j + cur] == 1) {
                continue;
            }

            state[0][j] = 1;
            state[1][j - cur + n] = 1;
            state[2][j + cur] = 1;
            search2(cur + 1, n, row, state);
            state[0][j] = 0;
            state[1][j - cur + n] = 0;
            state[2][j + cur] = 0;
        }
    }
}
