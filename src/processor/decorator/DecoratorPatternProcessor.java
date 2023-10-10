package processor.decorator;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class DecoratorPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public DecoratorPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Decorator");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int iComponentCounter = 0;
        int concreteComponentCounter = 0;
        int baseDecoratorCounter = 0;
        int concreteDecoratorCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(DecoratorPattern.IComponent.class)) {
            utils.validateHasElement(e, DecoratorPattern.ExecuteMethod.class, "execute method");
            utils.validateIsInterfaceOrAbstractClass(e, "IComponent");
            iComponentCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(DecoratorPattern.ConcreteComponent.class)) {
            utils.validateHasElement(e, DecoratorPattern.ExecuteMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteComponent", "IComponent", DecoratorPattern.IComponent.class, DecoratorPattern.ConcreteComponent.class);
            utils.validateIsConcreteClass(e, "ConcreteComponent");
            concreteComponentCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(DecoratorPattern.BaseDecorator.class)) {
            utils.validateHasElement(e, DecoratorPattern.WrappeeField.class, "wrappee field");
            utils.validateHasElement(e, DecoratorPattern.ExecuteMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "BaseDecorator", "IComponent", DecoratorPattern.IComponent.class, DecoratorPattern.BaseDecorator.class);
            baseDecoratorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(DecoratorPattern.ConcreteDecorator.class)) {
            utils.validateHasElement(e, DecoratorPattern.ExecuteMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteDecorator", "BaseDecorator", DecoratorPattern.BaseDecorator.class, DecoratorPattern.ConcreteDecorator.class);
            utils.validateIsConcreteClass(e, "ConcreteDecorator");
            concreteDecoratorCounter++;
        }

        boolean anyOfClassesExists = iComponentCounter > 0 || concreteComponentCounter > 0 || baseDecoratorCounter > 0 || concreteDecoratorCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iComponentCounter,"IComponent");
            utils.assertClassExists(concreteComponentCounter,"ConcreteComponent");
            utils.assertClassExists(baseDecoratorCounter,"BaseDecorator");
        }
    }
}
