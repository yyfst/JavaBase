package juc.reentrant;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以中断
 * 可以设置超时时间
 */
@Slf4j
public class ReentrantLockDemo {
    public static void main(String[] args) {
//        test1();

        test2();


    }




    private static void test2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 不加锁有线程安全问题
                    synchronized (simpleDateFormat) {
                        try {
                            log.info("date of simpleDateFormat: {}", simpleDateFormat.parse("1999-09-12").toString());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }


        // 线程安全，不可变对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info("date of dateTimeFormatter: {}", dateTimeFormatter.parse("1999-09-12").toString());
                }
            }).start();
        }
    }

    private static void test1() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            log.info("code for reentrantLock");
        } finally {
            reentrantLock.unlock();
        }
    }

}
