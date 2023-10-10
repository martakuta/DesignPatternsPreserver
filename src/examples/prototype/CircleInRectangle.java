package examples.prototype;

import processor.prototype.PrototypePattern;

@PrototypePattern.ConcretePrototype
public class CircleInRectangle extends Shape {
    private Circle circle;
    private Rectangle rectangle;

    @PrototypePattern.PrototypeConstructor
    CircleInRectangle(CircleInRectangle src) {
        super(src);
        this.circle = src.circle;
        this.rectangle = src.rectangle;
    }

    @PrototypePattern.CloneMethod
    public Shape clone() {
        return new CircleInRectangle(this);
    }

}
