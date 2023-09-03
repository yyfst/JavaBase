package program.recursion.subsets;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Subset {
    private static int num = 0;

    public static void main(String[] args) {
        int n = 10;
        generateSubsets3(n);
        log.info("total num: {}", num);
    }

    // 增量构造法
    private static void generateSunsets(int[] data) {
        int[] result = new int[data.length];
        recursion(data, result, 0, 0);
    }

    private static void recursion(int[] data, int[] result, int cur, int start) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cur; i++) {
            list.add(result[i]);
        }
        log.info("cur: {}, subsets: {}", cur - 1, list);
        num++;

        for (int i = start; i < data.length; i++) {
            result[cur] = data[i];
            recursion(data, result, cur + 1, i + 1);
        }
    }

    private static void generateSunsets2(int n) {
        int[] res = new int[n];
        search2(n, res, 0, 1);
    }

    private static void search2(int n, int[] res, int cur, int start) {
        for (int i = 0; i < cur; i++) {
            System.out.printf("%d", res[i]);
        }
        System.out.println();
        num++;

        if (cur == n) {
            return;
        }

        for (int i = start; i <= n; i++) {
            res[cur] = i;
            search2(n, res, cur + 1, i + 1);
        }
    }


    // 位向量法
    private static void generateSubsets5(int n) {
        boolean[] bit = new boolean[n + 1];
        search5(n, bit, 1);
    }

    private static void search5(int n, boolean[] bit, int cur) {
        if (cur == n) {
            for (int i = 1; i < cur; i++) {
                if (bit[i]) {
                    System.out.printf("%d", i);
                }
            }
            num++;
            System.out.println();
            return;
        }

        bit[cur] = false;
        search5(n, bit, cur + 1);

        bit[cur] = true;
        search5(n, bit, cur + 1);
    }

    // 二进制法，无法传递数组
    private static void generateSubsets3(int n) {
        for (int i = 0; i < (1 << n); i++) {
            print(i, n);
        }
    }

    private static void print(int i, int n) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            if ((i & (1 << index)) != 0) {
                result.add(index + 1);
            }
        }

        num++;
        log.info("num: {}, subset: {}", num, result);
    }
}
