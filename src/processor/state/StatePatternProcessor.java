package processor.state;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class StatePatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public StatePatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "State");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int contextCounter = 0;
        int iStateCounter = 0;
        int concreteStateCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(StatePattern.Context.class)) {
            utils.validateHasElement(e, StatePattern.StateField.class, "state field");
            utils.validateHasElement(e, StatePattern.ChangeStateMethod.class, "change state method");
            utils.validateHasElement(e, StatePattern.Operation.class, "operation method");
            utils.validateIsConcreteClass(e, "Context");
            contextCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(StatePattern.IState.class)) {
            utils.validateHasElement(e, StatePattern.Operation.class, "operation method");
            utils.validateIsInterfaceOrAbstractClass(e, "IState");
            iStateCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(StatePattern.ConcreteState.class)) {
            utils.validateHasElement(e, StatePattern.Operation.class, "operation method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteState", "IState", StatePattern.IState.class, StatePattern.ConcreteState.class);
            utils.validateIsConcreteClass(e,"ConcreteState");
            concreteStateCounter++;
        }

        boolean anyOfClassesExists = contextCounter > 0 || iStateCounter > 0 || concreteStateCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(contextCounter,"Context");
            utils.assertClassExists(iStateCounter,"IState");
            utils.assertClassExists(concreteStateCounter,"ConcreteState");
        }
    }
}
