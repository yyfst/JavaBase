package program.recursion;

public class LeetCode_394 {
    public static void main(String[] args) {
        LeetCode_394 main = new LeetCode_394();
        String s = "3[a]2[b2[d]c]";
        String res = main.decodeString(s);
        System.out.println(res);
    }

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
                continue;
            }

            StringBuilder data = new StringBuilder();
            while (ch >= '0' && ch <= '9') {
                data.append(ch);
                ch = s.charAt(++i);
            }

            int k = 1;
            if (!data.toString().isEmpty()) {
                k = Integer.parseInt(data.toString());
            }
            StringBuilder subString = new StringBuilder();
            if (ch == '[') {
                int left = 1;
                while (left != 0) {
                    ch = s.charAt(++i);
                    if (ch == '[') {
                        left++;
                    }
                    if (ch == ']') {
                        left--;
                    }
                    subString.append(ch);
                }
            }
            sb.append(decodeString(subString.toString()).repeat(k));
        }
        return sb.toString();
    }
}