package designpattern.factory.simpleFactory;

public class Main {
    public static void main(String[] args) {
        Product product = SimpleFactory.getProduct("car");

        if (product != null) {
            product.selectProduct();
        }

    }

}
