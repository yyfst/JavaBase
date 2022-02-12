package juc.thread;

import common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CreateThread {
    static String traceId;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        traceId = TraceUtil.putTraceIdToMdcAndGet();
        test1();
        test2();
        test3();


        log.info("thread in main: {}", Thread.currentThread().getName());
        log.info("time in main: {}", System.currentTimeMillis());


    }

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

    private static void test1() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                TraceUtil.putTraceIdToMdc(traceId);
                log.info("new thread: {}", Thread.currentThread().getName());
                log.info("time in new thread: {}", System.currentTimeMillis());
            }
        };
        thread1.start();
    }

}