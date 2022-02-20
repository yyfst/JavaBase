package juc.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        test1();

//        test3();

//        test5();

        test6();
    }

    // shutdown 等所有线程执行完
    private static void test6() {

    }

    // invoke
    private static void test5() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<String>> list = new ArrayList<>();
        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("call 1");
                return "1";
            }
        });

        executorService.shutdown();

        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("call 2");
                return "2";
            }
        });

        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("call 2");
                return "2";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(list);
        futures.forEach(f->{
            try {
                log.info("invokeAll result: {}", f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        String s = executorService.invokeAny(list);
        log.info("invokeAny result: {}", s);



    }

    // 提交任务.submit(Callable)
    private static void test4() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> submit = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("begin execute thread");
                return "OK!";
            }
        });
        log.info("result: {}", submit.get());

    }


    private static void test3() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {
            final int index = i;
            // 执行任务
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        int i1 = index / index;
                        log.info(" newSingleThreadExecutor.execute, number: {}", index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    private static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 20; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);

                        log.info(" newCachedThreadPool.execute, number: {}", index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                log.info("put begin!");
                synchronousQueue.put(100);
                log.info("put finished!");
            } catch (InterruptedException e) {
                log.error("put data int to synchronousQueue failed :{}", e.getMessage());
            }
        }).start();

        new Thread(() -> {
            try {
//                Thread.sleep(10000);
                log.info("get begin!");
                Integer take = synchronousQueue.take();
                log.info("get finished: {}", take);
            } catch (InterruptedException e) {
                log.error("take from synchronousQueue failed: {}", e.getMessage());
            }
        }).start();
    }

    private static void test1() {
        // 固定线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info(" newFixedThreadPool.execute, number: {}", index);
                }
            });
        }
    }
}
