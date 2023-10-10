package examples.prototype;

import processor.prototype.PrototypePattern;

@PrototypePattern.ConcretePrototype
@PrototypePattern.SubclassPrototype
public class Rectangle extends Shape {
    private int width;
    private int height;
    @PrototypePattern.PrototypeConstructor
    Rectangle (Rectangle src) {
        super(src);
        this.width = src.width;
        this.height = src.height;
    }
    @PrototypePattern.CloneMethod
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}
