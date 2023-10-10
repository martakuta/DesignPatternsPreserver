package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.ConcreteProduct
public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("render windows button");
    }

    @Override
    public void onClick() {
        System.out.println("windows button has been clicked");
    }
}
