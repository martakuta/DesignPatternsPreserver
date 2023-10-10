package processor.facade;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface FacadePattern {

    @Target(ElementType.TYPE)
    @interface Facade {}

    @Target(ElementType.TYPE)
    @interface AdditionalFacade {}

    @Target(ElementType.TYPE)
    @interface SubsystemClass {}

    @Target(ElementType.FIELD)
    @interface SubsystemObjectField {}

    @Target(ElementType.FIELD)
    @interface AdditionalFacadeField {}

    @Target(ElementType.METHOD)
    @interface SubsystemMethod {}
}
