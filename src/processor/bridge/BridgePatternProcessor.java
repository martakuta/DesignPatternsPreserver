package processor.bridge;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class BridgePatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public BridgePatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Bridge");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int abstractionCounter = 0;
        int refinedAbstractionCounter = 0;
        int iImplementationCounter = 0;
        int concreteImplementationCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(BridgePattern.Abstraction.class)) {
            utils.validateHasElement(e, BridgePattern.ImplementationField.class, "implementation field");
            abstractionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(BridgePattern.RefinedAbstraction.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "RefinedAbstraction", "Abstraction", BridgePattern.Abstraction.class, BridgePattern.RefinedAbstraction.class);
            refinedAbstractionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(BridgePattern.IImplementation.class)) {
            utils.validateIsInterfaceOrAbstractClass(e, "IImplementation");
            iImplementationCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(BridgePattern.ConcreteImplementation.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteImplementation", "IImplementation", BridgePattern.IImplementation.class, BridgePattern.ConcreteImplementation.class);
            utils.validateIsConcreteClass(e, "ConcreteImplementation");
            concreteImplementationCounter++;
        }

        boolean anyOfClassesExists = abstractionCounter > 0 || refinedAbstractionCounter > 0 || iImplementationCounter > 0 || concreteImplementationCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(abstractionCounter,"Abstraction");
            utils.assertClassExists(iImplementationCounter,"IImplementation");
            utils.assertClassExists(concreteImplementationCounter,"ConcreteImplementation");
        }
    }
}
