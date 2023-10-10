package processor.factoryMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface FactoryMethodPattern {

//    CREATOR

    @Target(ElementType.TYPE)
    @interface Creator {}

    @Target(ElementType.TYPE)
    @interface ConcreteCreator {}

    @Target(ElementType.METHOD)
    @interface CreateProductMethod {}

//    PRODUCT

    @Target(ElementType.TYPE)
    @interface IProduct {}

    @Target(ElementType.TYPE)
    @interface ConcreteProduct {}
}
