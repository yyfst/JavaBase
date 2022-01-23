package designpattern.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {
    @Test
    public void innerClasSingletonTest() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        Assert.assertSame(instance1, instance2);

        // 反射机制，破坏单例
        Class<InnerClassSingleton> clazz = InnerClassSingleton.class;
        Constructor<InnerClassSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        InnerClassSingleton instance3 = constructor.newInstance();

        Assert.assertNotSame(instance1, instance3);

    }

}