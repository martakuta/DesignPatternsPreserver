package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.IAbstractFactory
public interface GUIFactory {

    @AbstractFactoryPattern.CreateProductMethod
    public Button createButton();

    @AbstractFactoryPattern.CreateProductMethod
    public Checkbox createCheckbox();
}
