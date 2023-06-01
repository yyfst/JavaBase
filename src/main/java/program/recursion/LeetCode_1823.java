package program.recursion;

public class LeetCode_1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        return 1 + findByRecursion(n, k);
    }

    public static int findByRecursion(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (findByRecursion(n - 1, k) + k) % n;
    }
}
