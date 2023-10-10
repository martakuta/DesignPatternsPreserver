package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.IProduct
public interface Button {
    void render();
    void onClick();
}
