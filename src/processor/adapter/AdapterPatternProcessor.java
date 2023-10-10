package processor.adapter;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class AdapterPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public AdapterPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Adapter");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int iClientCounter = 0;
        int adapterCounter = 0;
        int serviceCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(AdapterPattern.IClient.class)) {
            utils.validateHasElement(e, AdapterPattern.AdapterMethod.class, "adapter method");
            utils.validateIsInterfaceOrAbstractClass(e, "IClient");
            iClientCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(AdapterPattern.Adapter.class)) {
            utils.validateHasElement(e, AdapterPattern.AdapteeServiceField.class, "adaptee service field");
            utils.validateHasElement(e, AdapterPattern.AdapterMethod.class, "adapter method");
            utils.validateSomeSuperclassHasAnnotation(e, "Adapter", "IClient", AdapterPattern.IClient.class, AdapterPattern.Adapter.class);
            utils.validateIsConcreteClass(e, "Adapter");
            adapterCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(AdapterPattern.Service.class)) {
            utils.validateHasElement(e, AdapterPattern.ServiceMethod.class, "service method");
            serviceCounter++;
        }

        boolean anyOfClassesExists = iClientCounter > 0 || adapterCounter > 0 || serviceCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iClientCounter,"IClient");
            utils.assertClassExists(adapterCounter,"Adapter");
            // Service also must be implemented, but often it is impossible to annotate it (change its code anyway)
        }
    }
}
