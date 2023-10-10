package processor.factoryMethod;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class FactoryMethodPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public FactoryMethodPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Factory Method");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int creatorCounter = 0;
        int concreteCreatorCounter = 0;
        int iProductCounter = 0;
        int concreteProductCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(FactoryMethodPattern.Creator.class)) {
            utils.validateHasElement(e, FactoryMethodPattern.CreateProductMethod.class, "create product method");
            creatorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FactoryMethodPattern.ConcreteCreator.class)) {
            utils.validateHasElement(e, FactoryMethodPattern.CreateProductMethod.class, "create product method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteCreator", "Creator", FactoryMethodPattern.Creator.class, FactoryMethodPattern.ConcreteCreator.class);
            utils.validateIsConcreteClass(e, "ConcreteCreator");
            concreteCreatorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FactoryMethodPattern.IProduct.class)) {
            utils.validateIsInterfaceOrAbstractClass(e, "IProduct");
            iProductCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FactoryMethodPattern.ConcreteProduct.class)) {
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteProduct", "IProduct", FactoryMethodPattern.IProduct.class, FactoryMethodPattern.ConcreteProduct.class);
            utils.validateIsConcreteClass(e, "ConcreteProduct");
            concreteProductCounter++;
        }

        boolean anyOfClassesExists = creatorCounter > 0 || concreteCreatorCounter > 0 || iProductCounter > 0 || concreteProductCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(creatorCounter,"Creator");
            utils.assertClassExists(concreteCreatorCounter,"ConcreteCreator");
            utils.assertClassExists(iProductCounter,"IProduct");
            utils.assertClassExists(concreteProductCounter,"ConcreteProduct");
        }
    }
}
