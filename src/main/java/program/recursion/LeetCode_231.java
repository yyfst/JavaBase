package program.recursion;

public class LeetCode_231 {
    public static void main(String[] args) {
        for (int i = -500; i <= 500; i++) {
            boolean powerOfTwo = isPowerOfTwo(i);
            if (powerOfTwo) {
                System.out.println(i + "\t" + powerOfTwo);
            }
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || n % 2 == 1) {
            return false;
        }

        return isPowerOfTwo(n / 2);
    }
}
