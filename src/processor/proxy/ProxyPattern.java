package processor.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface ProxyPattern {

    @Target(ElementType.TYPE)
    @interface IService {}

    @Target(ElementType.TYPE)
    @interface Service {}

    @Target(ElementType.TYPE)
    @interface Proxy {}

    @Target(ElementType.FIELD)
    @interface RealServiceField {}
}
