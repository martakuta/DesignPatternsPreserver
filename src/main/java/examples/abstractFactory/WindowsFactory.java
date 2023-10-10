package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.ConcreteFactory
public class WindowsFactory implements GUIFactory {

    @AbstractFactoryPattern.CreateProductMethod
    public Button createButton() {
        return new WindowsButton();
    }

    @AbstractFactoryPattern.CreateProductMethod
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
