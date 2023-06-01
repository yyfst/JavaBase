package program.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LeetCode_241 {
    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("2*3-4*5");
        System.out.println(list);
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0) {
            return Collections.emptyList();
        }
        if (isDigit(expression)) {
            return Collections.singletonList(Integer.valueOf(expression));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!isOperation(expression.charAt(i))) {
                continue;
            }

            List<Integer> subRes1 = diffWaysToCompute(expression.substring(0, i));
            List<Integer> subRes2 = diffWaysToCompute(expression.substring(i + 1));
            for (Integer data1 : subRes1) {
                for (Integer data2 : subRes2) {
                    Optional<Integer> value = calculate(expression.charAt(i), data1, data2);
                    value.ifPresent(result::add);
                }
            }
        }
        return result;
    }

    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isOperation(char op) {
        return op == '*' || op == '-' || op == '+';
    }

    private static Optional<Integer> calculate(char op, int x, int y) {
        return switch (op) {
            case '*' -> Optional.of(x * y);
            case '-' -> Optional.of(x - y);
            case '+' -> Optional.of(x + y);
            default -> Optional.empty();
        };
    }
}