package program.recursion;

public class LeetCode_Offer64 {
    public static void main(String[] args) {
        System.out.println(sumNums(100));
    }

    public static int sumNums(int n) {
        if (n == 0) {
            return 0;
        }
        return sumNums(n - 1) + n;
    }
}
