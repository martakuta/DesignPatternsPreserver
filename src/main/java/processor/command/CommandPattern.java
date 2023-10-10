package processor.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface CommandPattern {

//    CLASSES

    @Target(ElementType.TYPE)
    @interface Invoker {}

    @Target(ElementType.TYPE)
    @interface ICommand {}

    @Target(ElementType.TYPE)
    @interface ConcreteCommand {}

    @Target(ElementType.TYPE)
    @interface Receiver {}

//    METHODS & ATTRIBUTES

    @Target(ElementType.METHOD)
    @interface ExecuteMethod {}

    @Target(ElementType.METHOD)
    @interface ActionMethod {}

}
