package processor.templateMethod;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class TemplateMethodPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public TemplateMethodPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Template Method");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int abstractClassCounter = 0;
        int concreteClassCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(TemplateMethodPattern.AbstractClass.class)) {
            utils.validateHasElement(e, TemplateMethodPattern.TemplateMethod.class, "template method");
            abstractClassCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(TemplateMethodPattern.ConcreteClass.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteClass", "AbstractClass", TemplateMethodPattern.AbstractClass.class, TemplateMethodPattern.ConcreteClass.class);
            utils.validateIsConcreteClass(e, "ConcreteClass");
            concreteClassCounter++;
        }

        boolean anyOfClassesExists = abstractClassCounter > 0 || concreteClassCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(abstractClassCounter,"AbstractClass");
            utils.assertClassExists(concreteClassCounter,"ConcreteClass");
        }
    }
}
