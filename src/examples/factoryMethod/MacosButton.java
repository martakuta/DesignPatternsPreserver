package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.ConcreteProduct
public class MacosButton implements Button {

    @Override
    public void render() {
        System.out.println("render macos button");
    }

    @Override
    public void onClick() {
        System.out.println("macos button has been clicked");
    }
}
