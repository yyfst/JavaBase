package inherit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Man extends People {
    public Man(int age, String name) {
        super(age, name);
        log.info("constructor with parameter of Man");
        log.info("value in Man: {}", this);
    }


    {
        log.info("Man code");
    }
    private String manName = initFiled("filed for man name.");

    private static String manAddress = initFiled("static filed for man address.");

    static {
        log.info("Man static");
    }



    public Man() {
        log.info("constructor of Man");
    }



    @Override
    public void print() {
        log.info("print for man");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Man{");
        sb.append('}');
        return sb.toString();
    }
}
