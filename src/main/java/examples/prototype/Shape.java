package examples.prototype;

import processor.prototype.PrototypePattern;

@PrototypePattern.IPrototype
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    @PrototypePattern.PrototypeConstructor
    Shape(Shape src) {
        this.x = src.x;
        this.y = src.y;
        this.color = src.color;
    }
    @PrototypePattern.CloneMethod
    public abstract Shape clone();

}
