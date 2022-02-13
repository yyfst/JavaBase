package juc.sync;

import common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class Demo {
    static final Object lock = new Object();
    static int cnt1 = 0;
    static int cnt2 = 0;
    static String traceId;
    static String str = "hello";

    public static void main(String[] args) throws InterruptedException {
        traceId = TraceUtil.putTraceIdToMdcAndGet();

//        test1();
//
//        test2();

//        test3();

//        test4();

        test5();



    }

    // park
    private static void test5() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                synchronized (lock) {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (lock) {
                            cnt2++;
                        }
                    }
                    str = str + 101;

                    // waiting
                    LockSupport.park();
                    log.info("thread1 unpark!");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    TraceUtil.putTraceIdToMdc(traceId);
                    str = str + 100;
                    log.info("thread2!");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    LockSupport.unpark(thread1);

                    log.info("ending of thread2! ");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    // 测试wait释放锁
    private static void test4() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                synchronized (lock) {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (lock) {
                            cnt2++;
                        }
                    }
                    str = str + 101;

                    try {
                        lock.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("thread1!");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    TraceUtil.putTraceIdToMdc(traceId);
                    str = str + 100;
                    log.info("thread2!");
                    lock.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }


    // 测试sleep释放锁
    private static void test3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                synchronized (lock) {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (lock) {
                            cnt2++;
                        }
                    }
                    str = str + 101;

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("thread1!");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    TraceUtil.putTraceIdToMdc(traceId);
                    str = str + 100;
                    log.info("thread2!");
                }
            }
        });

        thread1.start();
        thread2.start();
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
                str = str + 101;
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
                str = str + 100;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("result of cnt with synchronized is {}", cnt2);
        log.info("result of str is {}", str);

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
