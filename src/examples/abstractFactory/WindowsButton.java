package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteProduct
public class WindowsButton extends Button {

    @Override
    public String getPressEffect() {
        return "windows effect";
    }
}
