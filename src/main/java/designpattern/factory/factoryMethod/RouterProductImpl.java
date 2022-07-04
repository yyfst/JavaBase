package designpattern.factory.factoryMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RouterProductImpl implements Product{
    @Override
    public void showProduct() {
        log.info("product is router!");
    }
}
