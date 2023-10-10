package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteProduct
public class WindowsCheckbox extends Checkbox {

    @Override
    public String getPressEffect() {
        return "windows effect";
    }
}
