package processor.builder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface BuilderPattern {

//    BUILDER

    @Target(ElementType.TYPE)
    @interface IBuilder {}

    @Target(ElementType.TYPE)
    @interface ConcreteBuilder {}

    @Target(ElementType.METHOD)
    @interface BuildStepMethod {}

    @Target(ElementType.METHOD)
    @interface GetResultMethod {}

    @Target(ElementType.FIELD)
    @interface ResultField {}

//    DIRECTOR

    @Target(ElementType.TYPE)
    @interface Director {}

    @Target(ElementType.METHOD)
    @interface MakeMethod {}
}
