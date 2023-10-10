package processor.strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface StrategyPattern {

    @Target(ElementType.TYPE)
    @interface Context {}

    @Target(ElementType.TYPE)
    @interface IStrategy {}

    @Target(ElementType.TYPE)
    @interface ConcreteStrategy {}

    @Target(ElementType.FIELD)
    @interface StrategyField {}

    @Target(ElementType.METHOD)
    @interface SetStrategyMethod {}

    @Target(ElementType.METHOD)
    @interface ContextOperation {}

    @Target(ElementType.METHOD)
    @interface StrategyOperation {}
}
