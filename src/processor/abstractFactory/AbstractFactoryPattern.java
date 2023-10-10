package processor.abstractFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface AbstractFactoryPattern {

//    CLASSES

    @Target(ElementType.TYPE)
    @interface IAbstractFactory {}

    @Target(ElementType.TYPE)
    @interface ConcreteFactory {}

    @Target(ElementType.TYPE)
    @interface AbstractProduct {}

    @Target(ElementType.TYPE)
    @interface ConcreteProduct {}

//    METHODS & ATTRIBUTES

    @Target(ElementType.METHOD)
    @interface CreateProductMethod {}

}
