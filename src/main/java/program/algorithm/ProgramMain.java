package program.algorithm;

import program.algorithm.dp.Knapsack;

public class ProgramMain {
    public static void main(String[] args) {
        test(new Knapsack());
    }

    private static void test(ProgramSolution solution) {
        solution.test();
    }
}
