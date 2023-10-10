package processor.proxy;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class ProxyPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public ProxyPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Proxy");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iServiceCounter = 0;
        int serviceCounter = 0;
        int proxyCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(ProxyPattern.IService.class)) {
            utils.validateIsInterfaceOrAbstractClass(e, "IService");
            iServiceCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(ProxyPattern.Service.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "Service", "IService", ProxyPattern.IService.class, ProxyPattern.Service.class);
            serviceCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(ProxyPattern.Proxy.class)) {
            utils.validateHasElement(e, ProxyPattern.RealServiceField.class, "real service field");
            utils.validateSomeSuperclassHasAnnotation(e, "Proxy", "IService", ProxyPattern.IService.class, ProxyPattern.Proxy.class);
            proxyCounter++;
        }

        boolean anyOfClassesExists = iServiceCounter > 0 || serviceCounter > 0 || proxyCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iServiceCounter,"IService");
            utils.assertClassExists(proxyCounter,"Proxy");
            // Service also must be implemented, but often it is impossible to annotate it (change its code anyway)
        }
    }
}
