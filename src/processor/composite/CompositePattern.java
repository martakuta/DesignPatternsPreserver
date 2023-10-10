package processor.composite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface CompositePattern {

    @Target(ElementType.TYPE)
    @interface IComponent {}

    @Target(ElementType.TYPE)
    @interface Composite {}

    @Target(ElementType.TYPE)
    @interface Leaf {}

    @Target(ElementType.METHOD)
    @interface ExecuteMethod {}

    @Target(ElementType.FIELD)
    @interface ComponentsListField {}

    @Target(ElementType.METHOD)
    @interface AddComponentMethod {}

    @Target(ElementType.METHOD)
    @interface RemoveComponentMethod {}

    @Target(ElementType.METHOD)
    @interface GetComponentMethod {}
}
