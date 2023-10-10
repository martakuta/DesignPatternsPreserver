package processor.command;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class CommandPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public CommandPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Command");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int invokerCounter = 0;
        int iCommandCounter = 0;
        int concreteCommandCounter = 0;
        int receiverCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(CommandPattern.Invoker.class)) {
            invokerCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(CommandPattern.ICommand.class)) {
            utils.validateHasElement(e, CommandPattern.ExecuteMethod.class, "execute method");
            utils.validateIsInterfaceOrAbstractClass(e, "ICommand");
            iCommandCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(CommandPattern.ConcreteCommand.class)) {
            utils.validateHasElement(e, CommandPattern.ExecuteMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteCommand", "ICommand", CommandPattern.ICommand.class, CommandPattern.ConcreteCommand.class);
            utils.validateIsConcreteClass(e,"ConcreteCommand");
            concreteCommandCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(CommandPattern.Receiver.class)) {
            utils.validateHasElement(e, CommandPattern.ActionMethod.class, "action method");
            receiverCounter++;
        }

        boolean anyOfClassesExists = invokerCounter > 0 || iCommandCounter > 0 || concreteCommandCounter > 0 || receiverCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(invokerCounter,"Invoker");
            utils.assertClassExists(iCommandCounter,"ICommand");
            utils.assertClassExists(concreteCommandCounter,"ConcreteCommand");
            utils.assertClassExists(receiverCounter,"Receiver");
        }
    }
}
