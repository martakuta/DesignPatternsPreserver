package processor.mediator;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class MediatorPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public MediatorPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Mediator");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iMediatorCounter = 0;
        int concreteMediatorCounter = 0;
        int componentCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(MediatorPattern.IMediator.class)) {
            utils.validateHasElement(e, MediatorPattern.NotifyMethod.class, "notify method");
            utils.validateIsInterfaceOrAbstractClass(e, "IMediator");
            iMediatorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(MediatorPattern.ConcreteMediator.class)) {
            utils.validateHasElement(e, MediatorPattern.NotifyMethod.class, "notify method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteMediator", "IMediator", MediatorPattern.IMediator.class, MediatorPattern.ConcreteMediator.class);
            utils.validateIsConcreteClass(e, "ConcreteMediator");
            concreteMediatorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(MediatorPattern.Component.class)) {
            componentCounter++;
        }

        boolean anyOfClassesExists = iMediatorCounter > 0 || concreteMediatorCounter > 0 || componentCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iMediatorCounter,"IMediator");
            utils.assertClassExists(concreteMediatorCounter,"ConcreteMediator");
            utils.assertClassExists(componentCounter,"Component");
        }
    }
}
