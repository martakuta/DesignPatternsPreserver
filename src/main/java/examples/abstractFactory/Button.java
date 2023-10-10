package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.AbstractProduct
public abstract class Button {
    String pressEffect;

    public abstract String getPressEffect();
}
