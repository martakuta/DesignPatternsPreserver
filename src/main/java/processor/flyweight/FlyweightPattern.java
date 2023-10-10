package processor.flyweight;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface FlyweightPattern {

//    FLYWEIGHT

    @Target(ElementType.TYPE)
    @interface IFlyweight {}

    @Target(ElementType.TYPE)
    @interface ConcreteFlyweight {}

    @Target(ElementType.FIELD)
    @interface IntrinsicStateField {}

    @Target(ElementType.METHOD)
    @interface OperationOnExtrinsicState {}

//    FLYWEIGHT FACTORY

    @Target(ElementType.TYPE)
    @interface FlyweightFactory {}

    @Target(ElementType.METHOD)
    @interface GetFlyweightMethod {}
}
