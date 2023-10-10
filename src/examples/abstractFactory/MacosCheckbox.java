package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteProduct
public class MacosCheckbox extends Checkbox {

    @Override
    public String getPressEffect() {
        return "MacOS effect";
    }
}
