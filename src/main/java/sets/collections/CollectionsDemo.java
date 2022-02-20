package sets.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class CollectionsDemo {
    public static void main(String[] args) {

        test4();
    }

    private static void test4() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                log.info("res : {}", list);
                //System.out.println(list); // String.valueOf(list)包装后不会出现异常

            }).start();
        }
    }

    private static void test3() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                log.info("res : {}", list);
                //System.out.println(list); // String.valueOf(list)包装后不会出现异常

            }).start();
        }
    }

    private static void test2() {
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                log.info("res : {}", list);
                //System.out.println(list); // String.valueOf(list)包装后不会出现异常

            }).start();
        }
    }

    // 测试list线程不安全
    private static void test1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                log.info("res : {}", list);
                //System.out.println(list); // String.valueOf(list)包装后不会出现异常

            }).start();
        }
    }
}
