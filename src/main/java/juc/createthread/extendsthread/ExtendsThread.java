package juc.createthread.extendsthread;

import lombok.extern.slf4j.Slf4j;

/**
 * 创建线程的方法之一：继承Thread类
 */
@Slf4j
public class ExtendsThread extends Thread{
    @Override
    public void run() {
        log.info("create a new thread!");
    }
}
