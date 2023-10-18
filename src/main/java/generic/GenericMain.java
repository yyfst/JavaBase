package generic;

import common.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class GenericMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        test1();

//        test2();
//
//        test3();
//
//        test4(1);
//        test4("2");
//        test4(new Person());

//        test5(Collections.singletonList(123));
//
//        test5(Collections.singletonList("hello"));
//        test6(Collections.singletonList(123));
//        test6(Collections.singletonList(123.9));
    }

    private static void test6(List<? extends Number> list) {
        list.forEach(new Consumer<Number>() {
            @Override
            public void accept(Number number) {
                System.out.println(number.doubleValue());
            }
        });
    }

    private static void test5(List<?> list) {
        list.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    private static <T> void test4(T t) {
        System.out.println(t);
    }

    // 类型擦除，字节码强制类型转换
    private static void test3() {
        List<String> list = new ArrayList<>();
        list.add("hello");

        String s = list.get(0);
    }

    // 通过反射，list插入不同类型的元素
    private static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();

        Class<? extends ArrayList> aClass = strings.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(strings, 1.2);
        add.invoke(strings, 999);
        add.invoke(strings, "test");
        log.info("values of strings: {}", strings);

        log.info("class of strings: {}", strings.getClass());
        log.info("strings equals doubles: {}", strings.getClass() == doubles.getClass());
    }

    private static void test1() {
        // 数组支持向上转型，但容易出现运行时错误
        Number[] numbers = new Integer[10]; // 编译通过
        numbers[0] = 1.1; // 编译通过，运行时出错

        // Java 泛型的引入就是为了编译期类型安全检查，这种方式比数组安全，但限制了向上转型
        ArrayList<Number> numArr1 = new ArrayList<>();
        ArrayList<Integer> intArr1 = new ArrayList<>();
//        numArr1 = intArr1; // 编译错误

        // 通配符支持向上转型，通配符本身有使用限制来保证安全，完美解决了上面的两个问题
        ArrayList<? extends Number> numArr2 = new ArrayList<>();
        ArrayList<? extends Integer> intArr2 = new ArrayList<>();
        numArr2 = intArr2; // 编译通过
    }

    // 只能写入，不能读出
    private static void testGenericSuper(List<? super Integer> list) {
        for (int i = 0; i < 3; i++) {
            list.add(i + 1);
//            Integer integer1 = list.get(i); //编译错误
            Integer integer2 = (Integer) list.get(i);
        }
    }

    // 只能读出，不能写入
    private static void testGenericExtends(List<? extends Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
//        list.add(123); //编译错误
    }

    // 只能读出 Object，不能写入
    public static void func(List<?> list) {
        for (int i = 0; i < 3; i++) {
//            list.add(i); //编译错误
        }
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
