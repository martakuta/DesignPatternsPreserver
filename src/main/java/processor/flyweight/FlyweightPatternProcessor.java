package processor.flyweight;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class FlyweightPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public FlyweightPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Flyweight");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iFlyweightCounter = 0;
        int concreteFlyweightCounter = 0;
        int flyweightFactoryCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(FlyweightPattern.IFlyweight.class)) {
            utils.validateHasElement(e, FlyweightPattern.OperationOnExtrinsicState.class, "operation on extrinsic state");
            utils.validateIsInterfaceOrAbstractClass(e, "IFlyweight");
            iFlyweightCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FlyweightPattern.ConcreteFlyweight.class)) {
            utils.validateHasElement(e, FlyweightPattern.OperationOnExtrinsicState.class, "operation on extrinsic state");
            utils.validateHasElement(e, FlyweightPattern.IntrinsicStateField.class, "intrinsic state field");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteFlyweight", "IFlyweight", FlyweightPattern.IFlyweight.class, FlyweightPattern.ConcreteFlyweight.class);
            utils.validateIsConcreteClass(e, "ConcreteFlyweight");
            concreteFlyweightCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(FlyweightPattern.FlyweightFactory.class)) {
            utils.validateHasElement(e, FlyweightPattern.GetFlyweightMethod.class, "get flyweight method");
            flyweightFactoryCounter++;
        }

        boolean anyOfClassesExists = iFlyweightCounter > 0 || concreteFlyweightCounter > 0 || flyweightFactoryCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iFlyweightCounter,"IFlyweight");
            utils.assertClassExists(concreteFlyweightCounter,"ConcreteFlyweight");
            utils.assertClassExists(flyweightFactoryCounter,"FlyweightFactory");
        }
    }
}
