package program.recursion.backtracking;

import lombok.extern.slf4j.Slf4j;

/**
 * 素数环
 */
@Slf4j
public class UVa_PrimeRing_524 {
    private static long num = 0;

    public static void main(String[] args) {
        int n = 50;
        for (int i = 1; i <= n; i++) {
            num = 0;
            long start = System.currentTimeMillis();
            searchPrimeRing(i);
            long end = System.currentTimeMillis();
            log.info("number:{}, solutions:{}, cost:{}", i, num, end - start);
        }
    }

    private static void searchPrimeRing(int n) {
        if (n > 20) {
            log.warn("number:{} is too large, ignored.", n);
            return;
        }
        // 根据规律发现,奇数情况下没有答案
        if (n % 2 == 1) {
            return;
        }
        boolean[] prime = new boolean[n * 2];
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = isPrime(i);
        }

        int[] array = new int[n];
        array[0] = 1;
        recursion(array, 1, used, prime);
    }

    private static void recursion(int[] array, int cur, boolean[] used, boolean[] isPrime) {
        if (cur == array.length && isPrime(array[0] + array[cur - 1])) {
            num++;
            return;
        }

        for (int i = 2; i <= array.length; i++) {
            if (used[i]) {
                continue;
            }

            if (isPrime[i + array[cur - 1]]) {
                array[cur] = i;
                used[i] = true;
                recursion(array, cur + 1, used, isPrime);
                used[i] = false;
            }
        }
    }

    private static boolean check(int[] array, boolean[] isPrime) {
        for (int i = 0; i < array.length - 1; i++) {
            int sum = array[i] + array[i + 1];
            if (!isPrime[sum]) {
                return false;
            }
        }
        return isPrime(array[0] + array[array.length - 1]);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
