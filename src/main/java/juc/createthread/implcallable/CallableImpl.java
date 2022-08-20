package juc.createthread.implcallable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * 创建线程的方法之一：实现Callable接口
 */
@Slf4j
public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        log.info("run in new thread.");
        return "hello!";
    }
}
