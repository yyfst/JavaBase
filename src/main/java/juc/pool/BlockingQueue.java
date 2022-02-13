package juc.pool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue <T>{
    // 1.任务队列
    private Deque<T> deque = new ArrayDeque<>();

    // 2.锁保护队列
    private ReentrantLock lock = new ReentrantLock();
}
