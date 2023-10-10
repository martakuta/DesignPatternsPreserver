package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.ConcreteCreator
public class WindowsDialog extends Dialog {
    @Override
    @FactoryMethodPattern.CreateProductMethod
    public Button createButton() {
        return new WindowsButton();
    }
}
