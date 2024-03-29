package common.entity;

import common.annotation.AnnotationDemo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AnnotationDemo(age = 1111)
public class Person {
    private static final int id = 100;

    private String name;

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
}
