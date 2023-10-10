package processor.interpreter;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class InterpreterPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public InterpreterPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Interpreter");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int abstractExpressionCounter = 0;
        int terminalExpressionCounter = 0;
        int nonTerminalExpressionCounter = 0;
        int contextCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(InterpreterPattern.AbstractExpression.class)) {
            utils.validateHasElement(e, InterpreterPattern.InterpretMethod.class, "interpret method");
            utils.validateIsInterfaceOrAbstractClass(e, "AbstractExpression");
            abstractExpressionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(InterpreterPattern.TerminalExpression.class)) {
            utils.validateHasElement(e, InterpreterPattern.InterpretMethod.class, "interpret method");
            utils.validateSomeSuperclassHasAnnotation(e, "TerminalExpression", "AbstractExpression", InterpreterPattern.AbstractExpression.class, InterpreterPattern.TerminalExpression.class);
            utils.validateIsConcreteClass(e, "TerminalExpression");
            terminalExpressionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(InterpreterPattern.NonTerminalExpression.class)) {
            utils.validateHasElement(e, InterpreterPattern.InterpretMethod.class, "interpret method");
            utils.validateSomeSuperclassHasAnnotation(e, "NonTerminalExpression", "AbstractExpression", InterpreterPattern.AbstractExpression.class, InterpreterPattern.NonTerminalExpression.class);
            utils.validateIsConcreteClass(e, "NonTerminalExpression");
            nonTerminalExpressionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(InterpreterPattern.Context.class)) {
            contextCounter++;
        }

        boolean anyOfClassesExists = abstractExpressionCounter > 0 || terminalExpressionCounter > 0 || nonTerminalExpressionCounter > 0 || contextCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(abstractExpressionCounter,"AbstractExpression");
            utils.assertClassExists(terminalExpressionCounter,"TerminalExpression");
            utils.assertClassExists(nonTerminalExpressionCounter,"NonTerminalExpression");
        }
    }
}
