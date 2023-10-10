package processor.prototype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface PrototypePattern {

    @Target(ElementType.TYPE)
    @interface IPrototype {}

    @Target(ElementType.TYPE)
    @interface ConcretePrototype {}

    @Target(ElementType.TYPE)
    @interface SubclassPrototype {}

    @Target(ElementType.METHOD)
    @interface CloneMethod {}

    @Target(ElementType.CONSTRUCTOR)
    @interface PrototypeConstructor {}
}
