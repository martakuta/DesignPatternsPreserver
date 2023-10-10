package examples.interpreter;

import processor.interpreter.InterpreterPattern;

import java.util.Map;

@InterpreterPattern.Context
public class Context {
    private Map<String, Integer> vars;

    public void setVar(String name, Integer value) {
        vars.put(name, value);
    }

    public Integer getVar(String name) {
        return vars.get(name);
    }
}
