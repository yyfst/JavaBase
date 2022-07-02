package designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式，需要的时候初始化，无法避免反射破坏单例
 */
@Slf4j
public class LazySingleton {
    // volatile防止重排序
    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    /**
     * 懒汉模式
     * synchronized：有性能损耗
     *
     * @return 单例
     */
    public static LazySingleton getInstance1() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    /*
                    字节码层面：
                        1.分配空间
                        2.初始化
                        3.引用赋值
                        JIT, CPU指令重排序，2/3步可以置换位置,单线程无影响
                     */
                    instance = new LazySingleton();
                    log.info("instance: {}", instance);
                }
            }
        }

        return instance;
    }

    /**
     * 该方法存在线程安全问题
     *
     * @return 单例
     */
    public static LazySingleton getInstance2() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 每个线程访问的时候都会加锁
     *
     * @return 单例
     */
    public synchronized static LazySingleton getInstance3() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 存在线程安全问题
     **
     * @return 单例
     */
    public static LazySingleton getInstance4() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    /**
     * 存在指令重排序问题
     **
     * @return 单例
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
