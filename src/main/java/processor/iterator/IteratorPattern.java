package processor.iterator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface IteratorPattern {

//    COLLECTION

    @Target(ElementType.TYPE)
    @interface ICollection {}

    @Target(ElementType.TYPE)
    @interface ConcreteCollection {}

    @Target(ElementType.METHOD)
    @interface CreateIteratorMethod {}

//    ITERATOR

    @Target(ElementType.TYPE)
    @interface IIterator {}

    @Target(ElementType.TYPE)
    @interface ConcreteIterator {}

    @Target(ElementType.METHOD)
    @interface HasNextMethod {}

    @Target(ElementType.METHOD)
    @interface NextMethod {}

}
