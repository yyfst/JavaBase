package juc.pool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    // 1.任务队列
    private Deque<T> deque = new ArrayDeque<>();

    // 2.锁保护队列
    private ReentrantLock lock = new ReentrantLock();

    private Condition fullWaitSet = lock.newCondition();

    private Condition emptyWaitSet = lock.newCondition();

    private int capacity;

    public T take() {
        lock.lock();
        T element = null;
        try {
            while (deque.isEmpty()) {
                emptyWaitSet.wait();
            }

            element = deque.removeFirst();
            fullWaitSet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return element;
    }

    public void put(T element) {
        lock.lock();
        try {
            while (deque.size() == capacity) {
                fullWaitSet.wait();
            }

            deque.addLast(element);
            emptyWaitSet.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }
}
