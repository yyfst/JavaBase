package designpattern.factory.factoryMethod;

public class PhoneProductFactory implements ProductFactory{
    @Override
    public Product getProduct() {
        return new PhoneProductImpl();
    }
}
