package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.ConcreteCreator
public class MacosDialog extends Dialog {
    @Override
    @FactoryMethodPattern.CreateProductMethod
    public Button createButton() {
        return new MacosButton();
    }
}
