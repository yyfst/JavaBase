package lambda;

public class Demo {
    public static void main(String[] args) {
        // lambda表达式是匿名函数
        new Thread(() -> System.out.println("new thread! " + Thread.currentThread().getName())).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread! " + Thread.currentThread().getName());
            }
        }).start();

        goShow(new DemoLambda() {
            @Override
            public void show() {
                System.out.println("show 1");
            }
        });

        goShow(() -> System.out.println("show 2"));

        String res = getName((name) -> {
            return name + " world";
        });

        System.out.println("res: " + res);


    }


    public static void goShow(DemoLambda demoLambda) {
        demoLambda.show();
    }

    public static String getName(DemoLambda2 demoLambda2) {
        return demoLambda2.getName("hello");
    }


}
