package examples.interpreter;

import processor.interpreter.InterpreterPattern;

@InterpreterPattern.TerminalExpression
public class Number implements Expression{
    private Integer value;

    @InterpreterPattern.InterpretMethod
    @Override
    public Integer evaluate(Context context) {
        return value;
    }
}
