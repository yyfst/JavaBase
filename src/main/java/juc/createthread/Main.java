package juc.createthread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        thread.start();

        log.info("main thread end!");
    }
}
