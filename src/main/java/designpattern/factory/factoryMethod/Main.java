package designpattern.factory.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Product phone = new PhoneProductFactory().getProduct();
        phone.showProduct();

        Product router = new RouterProductFactory().getProduct();
        router.showProduct();
    }
}
