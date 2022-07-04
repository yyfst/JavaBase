package designpattern.factory.simpleFactory;

public class SimpleFactory {
    public static Product getProduct(String type) {
        if (type.equals("car")) {
            return new Car();
        }

        if (type.equals("book")) {
            return new Book();
        }

        return null;
    }
}
