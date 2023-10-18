package juc.thread;

import common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;
import util.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadDemo {
    static String traceId;

    static int a = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        traceId = TraceUtil.putTraceIdToMdcAndGet();
        test8();
    }

    private static void test8() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadUtil.sleep(100);
                int count = 0;
                while (true) {
                    count++;
//                    log.debug("print count, thread:{}, count:{}", Thread.currentThread().getName(), count);
                }
            }
        }, "thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadUtil.sleep(100);
                int count = 0;
                while (true) {
//                    count++;
//                    Thread.yield();
//                    log.error("print count, thread:{}, count:{}", Thread.currentThread().getName(), count);
//                    if (count == 1000000) {
//                        break;
//                    }
                }
            }
        }, "thread2");

//        thread2.setPriority(1);
        thread2.start();
//        thread1.start();
        thread2.join();
//        Thread.currentThread().interrupt();
        log.info("run end.");

    }


    // setPriority
    private static void test7() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                int cnt = 0;
                while (true) {
                    cnt++;
                    log.error("data in {} is {}", Thread.currentThread().getName(), cnt);
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                int cnt = 0;
                while (true) {
                    cnt++;
                    log.info("data in {} is {}", Thread.currentThread().getName(), cnt);
                }

            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }


    // join
    private static void test6() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                a += 10;
                log.info("state of running: {}", Thread.currentThread().getState());
            }
        });

        thread.start();

        log.info("a value before join: {}", a);
        thread.join();
        log.info("a value after join: {}", a);

    }

    // yield
    private static void test5() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                int cnt = 0;
                while (true) {
                    cnt++;
                    log.error("data in {} is {}", Thread.currentThread().getName(), cnt);
                    Thread.yield();
                }

            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                int cnt = 0;
                while (true) {
                    cnt++;
                    log.info("data in {} is {}", Thread.currentThread().getName(), cnt);
//                    Thread.yield();
                }

            }
        });
        thread2.start();

    }

    // interrupt
    private static void test4() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                String name = Thread.currentThread().getName();
                log.info("thread in test4: {}", name);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ignored) {
                    log.error("InterruptedException in {}", name);
                }

                log.info("end of running in {}", name);
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();

        // 可读性较好，区分时间单位
        TimeUnit.SECONDS.sleep(2);
    }

    // 创建线程的方式3 FutureTask
    private static void test3() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TraceUtil.putTraceIdToMdc(traceId);
                log.info("new thread in thread3: {}", Thread.currentThread().getName());
                return "success!";
            }
        });

        Thread thread3 = new Thread(futureTask);
        thread3.start();
        String res = futureTask.get();
        log.info("result of thread: {}", res);

    }

    // 创建线程的方式2
    private static void test2() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                log.info("new thread2: {}", Thread.currentThread().getName());
            }
        });

        thread2.start();

    }

    // 创建线程的方式1
    private static void test1() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                log.info("new thread: {}", Thread.currentThread().getName());
                log.info("time in new thread: {}", System.currentTimeMillis());

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ignored) {
                }
            }
        };

        // NEW
        Thread.State state1 = thread1.getState();
        log.info("thread state before start: {}", state1);
        thread1.start();

        // RUNNABLE
        Thread.State state2 = thread1.getState();
        log.info("thread state after start: {}", state2);

        Thread.sleep(2000);
        // TIMED_WAITING
        Thread.State state3 = thread1.getState();
        log.info("thread state after sleep: {}", state3);

    }

}