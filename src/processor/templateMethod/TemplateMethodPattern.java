package processor.templateMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface TemplateMethodPattern {

//    CLASSES

    @Target(ElementType.TYPE)
    @interface AbstractClass {}

    @Target(ElementType.TYPE)
    @interface ConcreteClass {}

    @Target(ElementType.METHOD)
    @interface TemplateMethod {}
}
