package classloader;

public class    classloader {
    public static void main(String[] args) {
        ClassLoader classLoader = classloader.class.getClassLoader();
        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent());

        ClassLoader classLoader1 = classLoader.getClass().getClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = classLoader1.getClass().getClassLoader();
        System.out.println(classLoader2.getClass());

    }
}
