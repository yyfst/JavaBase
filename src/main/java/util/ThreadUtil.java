package util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadUtil {
    private ThreadUtil() {

    }

    public static void sleep(long millions) {
        try {
            Thread.sleep(millions);
        } catch (InterruptedException e) {
            log.error("thread interrupted, error:{}", e.getMessage());
        }
    }

}
