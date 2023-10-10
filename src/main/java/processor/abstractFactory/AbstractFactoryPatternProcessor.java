package processor.abstractFactory;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class AbstractFactoryPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public AbstractFactoryPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Abstract Factory");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int iAbstractFactoryCounter = 0;
        int concreteFactoryCounter = 0;
        int abstractProductCounter = 0;
        int concreteProductCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(AbstractFactoryPattern.IAbstractFactory.class)) {
            utils.validateHasElement(e, AbstractFactoryPattern.CreateProductMethod.class, "create product method");
            iAbstractFactoryCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(AbstractFactoryPattern.ConcreteFactory.class)) {
            utils.validateHasElement(e, AbstractFactoryPattern.CreateProductMethod.class, "create product method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteFactory", "IAbstractFactory", AbstractFactoryPattern.IAbstractFactory.class, AbstractFactoryPattern.ConcreteFactory.class);
            concreteFactoryCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(AbstractFactoryPattern.AbstractProduct.class)) {
            abstractProductCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(AbstractFactoryPattern.ConcreteProduct.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteProduct", "AbstractProduct", AbstractFactoryPattern.AbstractProduct.class, AbstractFactoryPattern.ConcreteProduct.class);
            concreteProductCounter++;
        }

        boolean anyOfClassesExists = iAbstractFactoryCounter > 0 || concreteFactoryCounter > 0 || abstractProductCounter > 0 || concreteProductCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iAbstractFactoryCounter,"IAbstractFactory");
            utils.assertClassExists(concreteFactoryCounter,"ConcreteFactory");
            utils.assertClassExists(abstractProductCounter,"AbstractProduct");
            utils.assertClassExists(concreteProductCounter,"ConcreteProduct");
        }
    }
}
