package designpattern.factory.factoryMethod;

public class RouterProductFactory implements ProductFactory{
    @Override
    public Product getProduct() {
        return new RouterProductImpl();
    }
}
