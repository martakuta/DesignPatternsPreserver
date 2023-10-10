package processor.strategy;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class StrategyPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public StrategyPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Strategy");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int contextCounter = 0;
        int iStrategyCounter = 0;
        int concreteStrategyCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(StrategyPattern.Context.class)) {
            utils.validateHasElement(e, StrategyPattern.StrategyField.class, "strategy field");
            utils.validateHasElement(e, StrategyPattern.SetStrategyMethod.class, "set strategy method");
            utils.validateHasElement(e, StrategyPattern.ContextOperation.class, "context operation");
            utils.validateIsConcreteClass(e, "Context");
            contextCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(StrategyPattern.IStrategy.class)) {
            utils.validateHasElement(e, StrategyPattern.StrategyOperation.class, "strategy operation");
            utils.validateIsInterfaceOrAbstractClass(e, "IStrategy");
            iStrategyCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(StrategyPattern.ConcreteStrategy.class)) {
            utils.validateHasElement(e, StrategyPattern.StrategyOperation.class, "strategy operation");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteStrategy", "IStrategy", StrategyPattern.IStrategy.class, StrategyPattern.ConcreteStrategy.class);
            utils.validateIsConcreteClass(e,"ConcreteStrategy");
            concreteStrategyCounter++;
        }

        boolean anyOfClassesExists = contextCounter > 0 || iStrategyCounter > 0 || concreteStrategyCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(contextCounter,"Context");
            utils.assertClassExists(iStrategyCounter,"IStrategy");
            utils.assertClassExists(concreteStrategyCounter,"ConcreteStrategy");
        }
    }
}
