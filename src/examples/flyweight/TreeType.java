package examples.flyweight;

import processor.flyweight.FlyweightPattern;

@FlyweightPattern.ConcreteFlyweight
public class TreeType implements Tree {
    @FlyweightPattern.IntrinsicStateField
    private String name;

    TreeType(String name) {
        this.name = name;
    }
    @FlyweightPattern.OperationOnExtrinsicState
    public String draw(int x, int y) {
        return "I'm a " + name + ". I'm growing at (" + x + "," + y + ").";
    }
}
