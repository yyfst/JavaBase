package reflect;

import common.annotation.AnnotationDemo;
import common.entity.Person;
import common.utils.TraceUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;

@Slf4j
public class Demo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        TraceUtil.putTraceIdToMdc();

        log.info("main execute......");

        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        System.out.println(name.get(personClass));

    }

    public static void fieldSetValue() throws NoSuchFieldException {
        Class<?> clazz = Person.class;
        Field field = clazz.getField("height");

        try {
            Object o = clazz.getConstructor().newInstance();
            field.set(o, 100);
            var res = field.get(o);
            log.info("field name: {}, field value: {}", field.getName(), res);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            log.error("set filed failed, error msg: {}", e.getMessage());
        }

    }

    /**
     * Class类的实例类型：
     * （1） 类：内部类，外部类
     * （2） 接口
     * （3） 注释
     * （4） 数组
     * （5) 基本数据类型
     * （6） void
     */
    public static void classInstanceTypes() {
        Class<?> class1 = Person.class;
        Class<?> class2 = Comparable.class;
        Class<?> class3 = Override.class;

        int[] arr = {1, 2, 3};
        Class<?> class4 = arr.getClass();

        Class<?> class5 = Integer.class;
        Class<?> class6 = void.class;

        log.info("different Class instance types: {},{},{},{},{},{}",
                class1, class2, class3, class4, class5, class6);
    }

    /**
     * 获取字节码的四种方式
     */
    public static void getByteCodeInfoDemo() {
        // 方式1.  不常用
        Person person = new Person();
        Class<?> class1 = person.getClass();
        log.info("get class 1, class: {}", class1);

        // 方式2.   不常用
        Class<?> class2 = Person.class;
        log.info("get class 2, class: {}", class2);

        // 方式3. 根据全限定名获取, 常用
        Class<?> class3;
        try {
            class3 = Class.forName("common.entity.Person");
            log.info("get class 3, class: {}", class3);
        } catch (ClassNotFoundException e) {
            log.error("get class failed, error msg: {}", e.getMessage());
        }

        // 方式4. 根据类加载器获取
        ClassLoader classLoader = Demo.class.getClassLoader();
        try {
            Class<?> class4 = classLoader.loadClass("common.entity.Person");
            log.info("get class 4, class: {}", class4);
        } catch (ClassNotFoundException e) {
            log.error("load class failed, error msg: {}", e.getMessage());
        }
    }

    /**
     * 注解
     */
    public static void annotationDemo() {
        // 1.获取注解定义位置的对象
        Class<?> clazz = Person.class;

        // 2.判断是否使用了注解
        boolean isPresent = clazz.isAnnotationPresent(AnnotationDemo.class);
        if (isPresent) {
            // 获取注解
            AnnotationDemo annotation = clazz.getAnnotation(AnnotationDemo.class);
            int age = annotation.age();
            log.info("get value from annotation: {}", age);

        }
    }

    /**
     * 方法反射
     */
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
            method.invoke(personClass.getConstructor().newInstance(), "xiao hu");
        } catch (NoSuchMethodException e) {
            log.error("get method failed, error msg: {}", e.getMessage());
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            log.error("invoke method failed, error msg: {}", e.getMessage());
        }
    }

    /**
     * 构造器反射
     */
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
            // 获取构造函数
            // TODO 验证私有构造是否能创建实例
            Constructor<?> constructor = personClass.getConstructor(String.class, int.class, int.class);
            log.info("get special constructor: {}", constructor);


            // 使用无参构造创建实例
            Object object = constructor.newInstance("xia p", 10, 100);
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
            log.info("get class field, field info: {}", field);
        }

        // 获取所有的成员变量，包括private，父类的也能获取
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            log.info("get class declared field, field name: {}", field.getName());

            // 获取修饰符，返回的int可以转为实际修饰符
            int modifiers = field.getModifiers();
            log.info("field modifiers: {}, describe msg: {}", modifiers, Modifier.toString(modifiers));
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
