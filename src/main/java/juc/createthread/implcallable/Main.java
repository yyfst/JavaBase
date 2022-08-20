package juc.createthread.implcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableImpl callable = new CallableImpl();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        log.info("main thread end!");

        log.info("result of new thread: {}", futureTask.get());
    }

    public static void runnableDemo() {
        Thread thread = new Thread(() -> log.info("new thread!"));
        thread.start();
    }
}
