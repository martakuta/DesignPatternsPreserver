package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteFactory
public class MacosFactory implements GUIFactory {

    @AbstractFactoryPattern.CreateProductMethod
    public Button createButton() {
        return new MacosButton();
    }

    @AbstractFactoryPattern.CreateProductMethod
    public Checkbox createCheckbox() {
        return new MacosCheckbox();
    }
}
