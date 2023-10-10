package processor.memento;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface MementoPattern {

//    ORIGINATOR

    @Target(ElementType.TYPE)
    @interface Originator {}

    @Target(ElementType.TYPE)
    @interface Memento {}

    @Target(ElementType.TYPE)
    @interface Caretaker {}

    @Target(ElementType.METHOD)
    @interface CreateMementoMethod {}

    @Target(ElementType.METHOD)
    @interface RestoreMethod {}

    @Target(ElementType.FIELD)
    @interface HistoryField {}
}
