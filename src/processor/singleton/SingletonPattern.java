package processor.singleton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface SingletonPattern {

    @Target(ElementType.TYPE)
    @interface Singleton {}

    @Target(ElementType.FIELD)
    @interface InstanceField {}

    @Target(ElementType.METHOD)
    @interface GetInstanceMethod {}

    @Target(ElementType.CONSTRUCTOR)
    @interface SingletonConstructor {}
}
