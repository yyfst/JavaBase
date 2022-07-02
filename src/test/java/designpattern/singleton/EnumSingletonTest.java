package designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

public class EnumSingletonTest {

    @Test
    public void testInstance() {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;

        Assert.assertEquals(instance1, instance2);
    }
}
