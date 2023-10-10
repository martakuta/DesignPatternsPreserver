package processor.mediator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface MediatorPattern {

    @Target(ElementType.TYPE)
    @interface Component {}

    @Target(ElementType.TYPE)
    @interface IMediator {}

    @Target(ElementType.TYPE)
    @interface ConcreteMediator {}

    @Target(ElementType.METHOD)
    @interface NotifyMethod {}
}
