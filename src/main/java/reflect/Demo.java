package reflect;

import common.annotation.AnnotationDemo;
import common.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class Demo {
    public static void main(String[] args) {

        getClassDemo();

        getConstructorDemo();

        getMethodDemo();

        annotationDemo();
    }

    public static void annotationDemo() {
        // 1.获取注解定义位置的对象
        Class<?> clazz = Person.class;

        // 2.判断是否使用了注解
        boolean isPresent = clazz.isAnnotationPresent(AnnotationDemo.class);
        if (isPresent) {
            AnnotationDemo annotation = clazz.getAnnotation(AnnotationDemo.class);
            int age = annotation.age();
            log.info("get value from annotation: {}", age);

        }
    }

    public static void getMethodDemo() {
        Class<?> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        if (methods.length == 0) {
            log.warn("get method number is 0!");
        }

        for (var method : methods) {
            log.info("get method, method: {}", method);
        }

        try {
            Method method = personClass.getMethod("askName", String.class);
            log.info("get method of setName, result: {}", method);
            method.invoke(personClass.newInstance(), "xiao hu");
        } catch (NoSuchMethodException e) {
            log.error("get method failed, error msg: {}", e.getMessage());
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            log.error("invoke method failed, error msg: {}", e.getMessage());
        }
    }

    public static void getConstructorDemo() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();

        if (constructors.length == 0) {
            log.warn("get declared constructors number is 0!");
        }

        for (var constructor : constructors) {
            log.info("get declared constructor, constructor: {}", constructor);
        }

        try {
            // 获取无参构造
            // TODO 验证私有构造是否能创建实例
            Constructor<?> constructor = personClass.getConstructor();
            log.info("get special constructor: {}", constructor);


            // 使用无参构造创建实例
            Object object = constructor.newInstance();
            log.info("new instance is : {}", object);

            // 使用无参构造函数创建实例，可以不用先获取构造函数
            Object object2 = personClass.newInstance();

        } catch (NoSuchMethodException e) {
            log.error("get constructor failed! error msg: {}", e.getMessage());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.error("get new instance failed! error msg: {}", e.getMessage());
        }
    }

    /**
     * 反射机制Demo
     */
    public static void getClassDemo() {
        // 获取Person的Class对象
        Class<Person> clazz = Person.class;

        // 获取所有的public声明的成员变量， protected也无法获取
        Field[] fields = clazz.getFields();

        if (fields.length == 0) {
            log.warn("class field number is 0!");
        }

        for (Field field : fields) {
            log.info("get class field, field name: {}", field.getName());
        }

        // 获取所有的成员变量，包括private
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            log.info("get class declared field, field name: {}", field.getName());
        }

        String money = "money";
        String name = "name";
        try {
            // 获取指定名称的成员变量，没有则异常
            Field field1 = clazz.getDeclaredField(name);

            // 给成员变量赋值，私有变量无法赋值
            // 给变量设置忽略私有声明, 不设置则给私有变量赋值会抛异常
            field1.setAccessible(true);
            Person person = new Person();
            field1.set(person, "xiao ming");
            Field field2 = clazz.getField(money);
        } catch (NoSuchFieldException e) {
            log.error("get field failed, field name: {}, error msg: {}", money, e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("set field failed, field name: {}, error msg: {}", name, e.getMessage());
        }
    }

}
