package designpattern.singleton;

import common.utils.TraceUtil;
import designpattern.singleton.LazySingleton;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class LazySingletonTest {

    @Test
    public void lazeSingletonTest() {
        TraceUtil.putTraceIdToMdc();

        singleThread();

//        multiThread();

    }

    private void singleThread() {
        // 单线程
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        Assert.assertSame(lazySingleton1, lazySingleton2);
    }

    private void multiThread() {
        // 多线程,junit不支持,

        new Thread(() -> {
            LazySingleton instance1 = LazySingleton.getInstance();
        }).start();

        new Thread(() -> {
            LazySingleton instance2 = LazySingleton.getInstance();
        }).start();

    }


}