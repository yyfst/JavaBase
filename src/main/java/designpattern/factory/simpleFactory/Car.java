package designpattern.factory.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car implements Product {
    @Override
    public void selectProduct() {
        log.info("select car product!");
    }
}