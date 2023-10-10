package processor.iterator;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class IteratorPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public IteratorPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Iterator");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iIteratorCounter = 0;
        int concreteIteratorCounter = 0;
        int iCollectionCounter = 0;
        int concreteCollectionCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(IteratorPattern.IIterator.class)) {
            utils.validateHasElement(e, IteratorPattern.NextMethod.class, "next method");
            utils.validateHasElement(e, IteratorPattern.HasNextMethod.class, "has next method");
            utils.validateIsInterfaceOrAbstractClass(e, "IIterator");
            iIteratorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(IteratorPattern.ConcreteIterator.class)) {
            utils.validateHasElement(e, IteratorPattern.NextMethod.class, "next method");
            utils.validateHasElement(e, IteratorPattern.HasNextMethod.class, "has next method");
            utils.validateIsConcreteClass(e, "ConcreteIterator");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteIterator", "IIterator", IteratorPattern.IIterator.class, IteratorPattern.ConcreteIterator.class);
            concreteIteratorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(IteratorPattern.ICollection.class)) {
            utils.validateHasElement(e, IteratorPattern.CreateIteratorMethod.class, "create iterator method");
            utils.validateIsInterfaceOrAbstractClass(e, "ICollection");
            iCollectionCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(IteratorPattern.ConcreteCollection.class)) {
            utils.validateHasElement(e, IteratorPattern.CreateIteratorMethod.class, "create iterator method");
            utils.validateIsConcreteClass(e, "ConcreteCollection");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteCollection", "ICollection", IteratorPattern.ICollection.class, IteratorPattern.ConcreteCollection.class);
            concreteCollectionCounter++;
        }

        boolean anyOfClassesExists = iIteratorCounter > 0 || concreteIteratorCounter > 0 || iCollectionCounter > 0 || concreteCollectionCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iIteratorCounter,"IIterator");
            utils.assertClassExists(concreteIteratorCounter,"ConcreteIterator");
            utils.assertClassExists(iCollectionCounter,"ICollection");
            utils.assertClassExists(concreteCollectionCounter,"ConcreteCollection");
        }
    }
}
