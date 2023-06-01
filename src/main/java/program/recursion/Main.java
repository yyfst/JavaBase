package program.recursion;

public class Main {
    public static void main(String[] args) {
        String s = "-10ahnu89784jkf";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                System.out.println(s.charAt(i));
            }
        }
    }
}
