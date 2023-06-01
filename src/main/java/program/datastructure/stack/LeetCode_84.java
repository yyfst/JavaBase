package program.datastructure.stack;

public class LeetCode_84 {
    public static void main(String[] args) {
        int[] heights = new int[]{
                2, 1, 5, 0, 6, 2, 3
        };

        LeetCode_84 main = new LeetCode_84();
        int res = main.largestRectangleArea(heights);
        System.out.println(res);

    }

    public int largestRectangleArea(int[] heights) {
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
