package processor.visitor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface VisitorPattern {

//    VISITOR

    @Target(ElementType.TYPE)
    @interface IVisitor {}

    @Target(ElementType.TYPE)
    @interface ConcreteVisitor {}

    @Target(ElementType.METHOD)
    @interface VisitMethod {}

//    ELEMENT

    @Target(ElementType.TYPE)
    @interface IElement {}

    @Target(ElementType.TYPE)
    @interface ConcreteElement {}

    @Target(ElementType.METHOD)
    @interface AcceptMethod {}

}
