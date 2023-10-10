package examples.prototype;

import processor.prototype.PrototypePattern;

@PrototypePattern.ConcretePrototype
@PrototypePattern.SubclassPrototype
public class Circle extends Shape {
    private int radius;
    @PrototypePattern.PrototypeConstructor
    Circle(Circle src) {
        super(src);
        this.radius = src.radius;
    }
    @PrototypePattern.CloneMethod
    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
