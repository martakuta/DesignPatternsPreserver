package processor.singleton;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class SingletonPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public SingletonPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Singleton");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        for(Element e : roundEnv.getElementsAnnotatedWith(SingletonPattern.Singleton.class)) {
            utils.validateHasStaticElement(e, SingletonPattern.InstanceField.class, "instance field");
            utils.validateHasElement(e, SingletonPattern.GetInstanceMethod.class, "get instance method");
            utils.validateHasPrivateElement(e, SingletonPattern.SingletonConstructor.class, "singleton constructor");
            utils.validateIsConcreteClass(e, "Singleton");
        }
    }
}
