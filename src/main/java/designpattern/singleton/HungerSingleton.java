package designpattern.singleton;

/**
 * 饿汉模式，初始化的时候创建单例
 */
public class HungerSingleton {
    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {

    }

    public static HungerSingleton getInstance() {

        return instance;
    }
}
