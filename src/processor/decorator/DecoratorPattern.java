package processor.decorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface DecoratorPattern {

//    CLASSES

    @Target(ElementType.TYPE)
    @interface IComponent {}

    @Target(ElementType.TYPE)
    @interface ConcreteComponent {}

    @Target(ElementType.TYPE)
    @interface BaseDecorator {}

    @Target(ElementType.TYPE)
    @interface ConcreteDecorator {}

//    METHODS & ATTRIBUTES

    @Target(ElementType.METHOD)
    @interface ExecuteMethod {}

    @Target(ElementType.FIELD)
    @interface WrappeeField {}

}
