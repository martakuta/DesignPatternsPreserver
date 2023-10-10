package examples.templateMethod;

import processor.templateMethod.TemplateMethodPattern;

@TemplateMethodPattern.AbstractClass
public abstract class GamePlayer {
    @TemplateMethodPattern.TemplateMethod
    public void takeTurn() {
        collectResources();
        buildStructures();
        attack();
    }

    abstract public void collectResources();
    abstract public void buildStructures();
    public void attack() {}
}
