package examples.factoryMethod;

import processor.factoryMethod.FactoryMethodPattern;

@FactoryMethodPattern.Creator
public abstract class Dialog {

    public void render() {
        //render dialog and do important things
    }

    @FactoryMethodPattern.CreateProductMethod
    public abstract Button createButton();
}
