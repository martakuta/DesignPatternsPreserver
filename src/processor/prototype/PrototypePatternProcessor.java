package processor.prototype;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class PrototypePatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public PrototypePatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Prototype");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iPrototypeCounter = 0;
        int concretePrototypeCounter = 0;
        int subclassPrototypeCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(PrototypePattern.IPrototype.class)) {
            utils.validateHasElement(e, PrototypePattern.CloneMethod.class, "clone method");
            utils.validateIsInterfaceOrAbstractClass(e, "IPrototype");
            iPrototypeCounter++;
        }

        for(Element e : roundEnv.getElementsAnnotatedWith(PrototypePattern.ConcretePrototype.class)) {
            utils.validateHasElement(e, PrototypePattern.CloneMethod.class, "clone method");
            utils.validateHasElement(e, PrototypePattern.PrototypeConstructor.class, "prototype constructor");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcretePrototype", "IPrototype", PrototypePattern.IPrototype.class, PrototypePattern.ConcretePrototype.class);
            utils.validateIsConcreteClass(e, "ConcretePrototype");
            concretePrototypeCounter++;
        }

        for(Element e : roundEnv.getElementsAnnotatedWith(PrototypePattern.SubclassPrototype.class)) {
            utils.validateHasElement(e, PrototypePattern.CloneMethod.class, "clone method");
            utils.validateHasElement(e, PrototypePattern.PrototypeConstructor.class, "prototype constructor");
            utils.validateIsConcreteClass(e, "SubclassPrototype");
            subclassPrototypeCounter++;
        }

        boolean anyOfClassesExists = iPrototypeCounter > 0 || concretePrototypeCounter > 0 || subclassPrototypeCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iPrototypeCounter,"IPrototype");
            utils.assertClassExists(concretePrototypeCounter,"ConcretePrototype");
        }
    }
}
