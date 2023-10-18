package inherit;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class People {
    private int age;

    private String name = initFiled("filed for people name.");

    static {
        log.debug("people static");
    }

    private static String address = initFiled("static filed for people address.");

    public People() {
        log.debug("constructor of Person.");
    }

    {
        log.debug("people code");
    }

    public People(int age, String name) {
        log.debug("constructor with parameter of Person");
        this.age = age;
        this.name = name;
        log.debug("value in Person: {}", this);
    }

    public static String initFiled(String s) {
        log.error("init filed in people: {}", s);
        return s;
    }

    public void print() {
        log.debug("print for people");
    }

    public void printPeople() {
        log.debug("method only for people");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
