package init;

public class InitClass {
    static {
        sum = 999L;
    }

    public static long sum;


    {
        sum = 100L;
    }

    static {
        sum = 2999L;
    }
}
