package program.algorithm.greedy;

import program.datastructure.prefixsum.LeetCode_862;

import java.util.Arrays;

public class LeetCode_455 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {3};

        LeetCode_455 main = new LeetCode_455();
        System.out.println(main.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int index = 0;
        for (int i = 0; i < g.length; i++) {
            while (index < s.length) {
                if (s[index++] >= g[i]) {
                    res++;
                    break;
                }
            }
            if (index == s.length) {
                break;
            }
        }
        return res;
    }
}
