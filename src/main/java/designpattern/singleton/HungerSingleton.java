package designpattern.singleton;

/**
 * 饿汉模式，初始化的时候创建单例
 * 使用类的时候才会初始化
 */
public class HungerSingleton {
    // 只会被实例化一次
    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {

    }

    public static HungerSingleton getInstance() {

        return instance;
    }
}
