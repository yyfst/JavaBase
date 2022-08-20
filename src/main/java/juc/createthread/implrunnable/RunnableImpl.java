package juc.createthread.implrunnable;

import lombok.extern.slf4j.Slf4j;

/**
 * 创建线程的方法之一：实现Runnable接口
 */
@Slf4j
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        log.info("run in new thread!");
    }
}
