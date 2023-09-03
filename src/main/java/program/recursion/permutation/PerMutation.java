package program.recursion.permutation;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class PerMutation {
    private static long num = 0;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int n = 4;
        int[] srcData = new int[n];
        for (int i = 0; i < n; i++) {
            srcData[i] = random.nextInt(50);
        }

        log.info("src data: {}", Arrays.toString(srcData));
        long total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        perMutation(srcData);
        log.info("total num: {}, actual num: {}", total, num);
    }

    private static void perMutation(int[] srcData) {
        int[] res = new int[srcData.length];
        Set<Integer> used = new HashSet<>();
        search(srcData, res, 0, used);
    }

    private static void search(int[] data, int[] res, int cur, Set<Integer> used) {
        if (cur == data.length) {
            System.out.println(Arrays.toString(res));
            num++;
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if (used.contains(i)) {
                continue;
            }

            res[cur] = data[i];
            used.add(i);
            search(data, res, cur + 1, used);
            used.remove(i);
        }
    }
}
