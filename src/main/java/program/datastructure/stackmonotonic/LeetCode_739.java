package program.datastructure.stackmonotonic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class LeetCode_739 {
    public static void main(String[] args) {
        LeetCode_739 main = new LeetCode_739();
        int[] temperatures = new int[]{
                30,40,50,60
        };

        int[] ints = main.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
