package examples.interpreter;

import processor.interpreter.InterpreterPattern;

@InterpreterPattern.TerminalExpression
public class Variable implements Expression {
    private String name;

    @InterpreterPattern.InterpretMethod
    @Override
    public Integer evaluate(Context context) {
        return context.getVar(name);
    }
}
