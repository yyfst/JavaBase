package program.competition.weekly;

public class LeetCode_0611 {
    public static void main(String[] args) {
        char c = 'b';
        System.out.println((char) (c - 1));

        LeetCode_0611 main = new LeetCode_0611();
        String s = "z";
        String string = main.smallestString(s);
        System.out.println(string);
    }

    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }
        return -1;
    }

    public String smallestString(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                cnt++;
            }
        }

        if (cnt == s.length()) {
            return s.substring(0, s.length() - 1) + 'z';
        }
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 'a') {
                begin = i;
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' && i > begin) {
                break;
            }
            end = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i < begin || i > end) {
                sb.append(c);
            }

            if (i >= begin && i <= end) {
                sb.append((char) (c - 1));
            }
        }
        return sb.toString();
    }

    public long minCost(int[] nums, int x) {

        return 0;
    }
}
