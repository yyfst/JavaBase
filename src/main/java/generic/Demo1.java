package generic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo1<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void printClass(T t) {
        Class<?> clazz = t.getClass();
        log.info("class of t: {}", clazz);
    }

    public void printThis() {
        Class<?> clazz = this.getClass();
        log.info("class of this: {}", clazz);
    }

    public void instance(T t) throws InstantiationException, IllegalAccessException {
        Class<?> clazz = t.getClass();
        T newInstance = (T) clazz.newInstance();
        log.info("class of new instance: {}", newInstance.getClass());
    }
}
