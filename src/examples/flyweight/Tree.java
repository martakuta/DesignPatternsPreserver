package examples.flyweight;

import processor.flyweight.FlyweightPattern;

@FlyweightPattern.IFlyweight
public interface Tree {
    @FlyweightPattern.OperationOnExtrinsicState
    String draw(int x, int y);
}
