package common.entity;

import common.annotation.AnnotationDemo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AnnotationDemo(age = 1111)
public class Person {
    private static final int id = 100;

    private String name = "default";

    protected int age;

    public int height;

    public Person() {

    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String askName(String str) {
        log.info("test info. {} ask name.", str);
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}
