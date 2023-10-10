package processor.chainOfResponsibility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface ChainOfResponsibilityPattern {

//    CLASSES

    @Target(ElementType.TYPE)
    @interface IHandler {}

    @Target(ElementType.TYPE)
    @interface BaseHandler {}

    @Target(ElementType.TYPE)
    @interface ConcreteHandler {}

//    METHODS & ATTRIBUTES

    @Target(ElementType.FIELD)
    @interface NextField {}

    @Target(ElementType.METHOD)
    @interface SetNextMethod {}

    @Target(ElementType.METHOD)
    @interface HandleMethod {}

}
