package classes;

@FunctionalInterface
public interface FuncInterface {
    int testMethod(int a, int b);

    default int method0() {

        return 1;
    }

    default int method1() {

        return 1;
    }

    static int method2() {
        return 2;
    }

    static int method3() {
        return 2;
    }
}
