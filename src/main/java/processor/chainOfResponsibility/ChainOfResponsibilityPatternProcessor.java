package processor.chainOfResponsibility;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class ChainOfResponsibilityPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public ChainOfResponsibilityPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Chain of responsibility");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int iHandlerCounter = 0;
        int baseHandlerCounter = 0;
        int concreteHandlerCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(ChainOfResponsibilityPattern.IHandler.class)) {
            utils.validateHasElement(e, ChainOfResponsibilityPattern.HandleMethod.class, "handle method");
            utils.validateIsInterfaceOrAbstractClass(e, "IComponent");
            iHandlerCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(ChainOfResponsibilityPattern.BaseHandler.class)) {
            utils.validateHasElement(e, ChainOfResponsibilityPattern.HandleMethod.class, "handle method");
            utils.validateSomeSuperclassHasAnnotation(e, "BaseHandler", "IHandler", ChainOfResponsibilityPattern.IHandler.class, ChainOfResponsibilityPattern.BaseHandler.class);
            utils.validateIsConcreteClass(e, "BaseHandler");
            baseHandlerCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(ChainOfResponsibilityPattern.ConcreteHandler.class)) {
            utils.validateHasElement(e, ChainOfResponsibilityPattern.HandleMethod.class, "handle method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteHandler", "IHandler", ChainOfResponsibilityPattern.IHandler.class, ChainOfResponsibilityPattern.ConcreteHandler.class);
            utils.validateIsConcreteClass(e, "ConcreteHandler");
            concreteHandlerCounter++;
        }

        boolean anyOfClassesExists = iHandlerCounter > 0 || baseHandlerCounter > 0 || concreteHandlerCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iHandlerCounter,"IHandler");
            utils.assertClassExists(concreteHandlerCounter,"ConcreteHandler");
        }
    }
}
