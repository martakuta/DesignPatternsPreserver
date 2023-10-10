package processor.bridge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface BridgePattern {

    @Target(ElementType.TYPE)
    @interface Abstraction {}

    @Target(ElementType.TYPE)
    @interface RefinedAbstraction {}

    @Target(ElementType.FIELD)
    @interface ImplementationField {}

//    SERVICE

    @Target(ElementType.TYPE)
    @interface IImplementation {}

    @Target(ElementType.TYPE)
    @interface ConcreteImplementation {}
}
