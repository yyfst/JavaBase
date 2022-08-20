package juc.threadstatus.statusnew;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->
        {
            // 获取当前线程的状态
            Thread.State state = Thread.currentThread().getState();
            log.info("new thread running, status: {}", state);
        });

        log.info("new thread status before start: {}", thread.getState());


        // 启动线程
        thread.start();

        log.info("new thread status after start: {}", thread.getState());


        log.info("--------------------------------");

        TimeUnit.SECONDS.sleep(1);

        Test test = new Test();
        test.test1();
        test.test2();
    }
}
