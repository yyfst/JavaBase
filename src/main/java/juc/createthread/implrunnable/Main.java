package juc.createthread.implrunnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread thread = new Thread(runnable);

        thread.start();

        log.info("main thread end!");
    }
}
