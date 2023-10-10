package examples.interpreter;

import processor.interpreter.InterpreterPattern;

@InterpreterPattern.NonTerminalExpression
public class AddExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    @InterpreterPattern.InterpretMethod
    @Override
    public Integer evaluate(Context context) {
        return expr1.evaluate(context) + expr2.evaluate(context);
    }
}
