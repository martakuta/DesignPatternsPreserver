package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteProduct
public class MacosButton extends Button {

    @Override
    public String getPressEffect() {
        return "MacOS effect";
    }
}
