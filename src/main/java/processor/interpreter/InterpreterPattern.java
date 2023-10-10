package processor.interpreter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface InterpreterPattern {

//    EXPRESSION

    @Target(ElementType.TYPE)
    @interface AbstractExpression {}

    @Target(ElementType.TYPE)
    @interface TerminalExpression {}

    @Target(ElementType.TYPE)
    @interface NonTerminalExpression {}

    @Target(ElementType.METHOD)
    @interface InterpretMethod {}

//    CONTEXT

    @Target(ElementType.TYPE)
    @interface Context {}
}
