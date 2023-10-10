package examples.interpreter;

import processor.interpreter.InterpreterPattern;

@InterpreterPattern.AbstractExpression
public interface Expression {
    @InterpreterPattern.InterpretMethod
    Integer evaluate(Context context);
}
