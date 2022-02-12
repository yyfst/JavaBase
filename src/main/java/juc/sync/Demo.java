package juc.sync;

import common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
    static Object lock = new Object();
    static int cnt1 = 0;
    static int cnt2 = 0;
    static String traceId;

    public static void main(String[] args) throws InterruptedException {
        traceId = TraceUtil.putTraceIdToMdcAndGet();

        test1();

        test2();


    }

    private static void test2() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                for (int i = 0; i < 10000; i++) {
                    synchronized (lock) {
                        cnt2++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                for (int i = 0; i < 10000; i++) {
                    synchronized (lock) {
                        cnt2--;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("result of cnt with synchronized is {}", cnt2);

    }

    private static void test1() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                for (int i = 0; i < 10000; i++) {
                    cnt1++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                for (int i = 0; i < 10000; i++) {
                    cnt1--;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("result of cnt is {}", cnt1);

    }
}
