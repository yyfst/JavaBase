package program.recursion;

public class LeetCode_Offer62 {
    public static void main(String[] args) {
        int remaining = lastRemaining(10, 17);
        System.out.println(remaining);
    }

    public static int lastRemaining(int n, int m) {
      if (n == 1) {
          return 0;
      }
      return (lastRemaining(n-1, m) + m) % n;
    }
}
