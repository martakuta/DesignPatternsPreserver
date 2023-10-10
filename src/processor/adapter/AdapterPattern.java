package processor.adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface AdapterPattern {

    @Target(ElementType.TYPE)
    @interface IClient {}

    @Target(ElementType.TYPE)
    @interface Adapter {}

    @Target(ElementType.FIELD)
    @interface AdapteeServiceField {}

    @Target(ElementType.METHOD)
    @interface AdapterMethod {}

//    SERVICE

    @Target(ElementType.TYPE)
    @interface Service {}

    @Target(ElementType.METHOD)
    @interface ServiceMethod {}
}
