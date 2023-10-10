package examples.abstractFactory;

import processor.abstractFactory.AbstractFactoryPattern;

@AbstractFactoryPattern.AbstractProduct
public abstract class Checkbox {
    String pressEffect;

    public abstract String getPressEffect();
}
