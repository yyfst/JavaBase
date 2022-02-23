package sets.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class CollectionsDemo {
    static boolean flag = false;
    static int a = 1;
    static char b = 'a';
    public static void main(String[] args) {

        test5();
//        test4();
    }

    // 精准通知
    private static void test5() {
        Lock lock = new ReentrantLock();

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                lock.lock();
                try {
                    while (!flag) {
                        c1.await();
                    }
                    System.out.println(a++);
                    flag = false;
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                lock.lock();
                try {
                    while (flag) {
                        c2.await();
                    }
                    System.out.println(b);
                    b = (char) (b + 1);
                    flag = true;
                    c1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();
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
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                    log.info("res : {}", list);
                    //System.out.println(list); // String.valueOf(list)包装后不会出现异常
                } finally {
                    lock.unlock();
                }

            }).start();
        }
    }
}
