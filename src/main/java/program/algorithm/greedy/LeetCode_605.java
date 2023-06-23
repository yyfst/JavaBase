package program.algorithm.greedy;

public class LeetCode_605 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;

        LeetCode_605 main = new LeetCode_605();
        System.out.println(main.canPlaceFlowers(flowerbed, n));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int index = 0;
        while (index < flowerbed.length & n > 0) {
            if (flowerbed[index] == 1) {
                index += 2;
                continue;
            }

            if (index - 1 >= 0 && flowerbed[index - 1] == 1) {
                index += 1;
                continue;
            }

            if (index + 1 < flowerbed.length && flowerbed[index + 1] == 1) {
                index += 3;
                continue;
            }

            n--;
            index += 2;
            if (n == 0) {
                return true;
            }
        }
        return n <= 0;
    }
}
