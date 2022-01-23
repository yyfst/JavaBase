package designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

public class HungerSingletonTest {

    @Test
    public void hungerSingletonTest() {
        HungerSingleton instance1 = HungerSingleton.getInstance();
        HungerSingleton instance2 = HungerSingleton.getInstance();
        Assert.assertSame(instance1, instance2);
    }

}