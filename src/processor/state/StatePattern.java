package processor.state;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface StatePattern {

    @Target(ElementType.TYPE)
    @interface Context {}

    @Target(ElementType.TYPE)
    @interface IState {}

    @Target(ElementType.TYPE)
    @interface ConcreteState {}

    @Target(ElementType.FIELD)
    @interface StateField {}

    @Target(ElementType.METHOD)
    @interface ChangeStateMethod {}

    @Target(ElementType.METHOD)
    @interface Operation {}
}
