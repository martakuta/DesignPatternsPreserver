package processor.facade;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class FacadePatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public FacadePatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Facade");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int facadeCounter = 0;
        int additionalFacadeCounter = 0;
        int subsystemClassCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(FacadePattern.Facade.class)) {
            utils.validateHasElement(e, FacadePattern.SubsystemObjectField.class, "subsystem object field");
            utils.validateHasElement(e, FacadePattern.SubsystemMethod.class, "subsystem method");
            utils.validateIsConcreteClass(e, "Facade");
            facadeCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FacadePattern.AdditionalFacade.class)) {
            utils.validateHasElement(e, FacadePattern.SubsystemObjectField.class, "subsystem object field");
            utils.validateHasElement(e, FacadePattern.SubsystemMethod.class, "subsystem method");
            utils.validateIsConcreteClass(e, "AdditionalFacade");
            additionalFacadeCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FacadePattern.SubsystemClass.class)) {
            subsystemClassCounter++;
        }

        boolean anyOfClassesExists = facadeCounter > 0 || additionalFacadeCounter > 0 || subsystemClassCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(facadeCounter,"Facade");
            // SubsystemClass also must be implemented, but often it is impossible to annotate it (change its code anyway)
        }
    }
}
