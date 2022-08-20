package juc.threadstatus.statusnew;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public void test1() {
        Thread thread = new Thread(() ->
        {
            log.info("this in new thread: {}", this.getClass());
        });


        // 启动线程
        thread.start();

        log.info("this in main thread: {}", this.getClass());
    }


    public void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("this in new thread: {}", this.getClass());
            }
        }).start();

        log.info("this in main thread: {}", this.getClass());
    }
}
