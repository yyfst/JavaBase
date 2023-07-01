package program.datastructure.stackmonotonic;

import java.util.Stack;

public class LeetCode_84 {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};

        LeetCode_84 main = new LeetCode_84();
        int res = main.largestRectangleArea(heights);
        System.out.println(res);

    }

    // 寻找当前高度能支持的最大宽度——单调栈优化
    public int largestRectangleArea(int[] heights) {
        int res = heights[0];
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i]));
        }
        return res;
    }

    // 寻找当前高度能支持的最大宽度——超时
    public int largestRectangleArea2(int[] heights) {
        int res = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            int begin = 0;
            int end = heights.length - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < cur) {
                    begin = j + 1;
                    break;
                }
            }

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < cur) {
                    end = j - 1;
                    break;
                }
            }
            res = Math.max(res, cur * (end - begin + 1));
        }
        return res;
    }

    // 暴力求解
    public int largestRectangleArea1(int[] heights) {
        int res = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                res = Math.max(res, min * (j - i + 1));
            }
        }
        return res;
    }
}
