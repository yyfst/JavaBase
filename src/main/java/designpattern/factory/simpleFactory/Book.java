package designpattern.factory.simpleFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Book implements Product{
    @Override
    public void selectProduct() {
        log.info("select book product!");
    }
}
