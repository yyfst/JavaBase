package program.datastructure.stackmonotonic;

import java.util.Stack;

public class LeetCode_1475 {
    public static void main(String[] args) {
        LeetCode_1475 main = new LeetCode_1475();


    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }

        return res;
    }
}
