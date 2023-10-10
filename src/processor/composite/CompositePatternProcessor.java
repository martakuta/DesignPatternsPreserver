package processor.composite;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class CompositePatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public CompositePatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Composite");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iComponentCounter = 0;
        int leafCounter = 0;
        int compositeCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(CompositePattern.IComponent.class)) {
            utils.validateHasElement(e, CompositePattern.ExecuteMethod.class, "execute method");
            utils.validateIsInterfaceOrAbstractClass(e, "IComponent");
            iComponentCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(CompositePattern.Leaf.class)) {
            utils.validateHasElement(e, CompositePattern.ExecuteMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "Leaf", "IComponent", CompositePattern.IComponent.class, CompositePattern.Leaf.class);
            leafCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(CompositePattern.Composite.class)) {
            utils.validateHasElement(e, CompositePattern.ComponentsListField.class, "components list field");
            utils.validateHasElement(e, CompositePattern.ExecuteMethod.class, "execute method");
            utils.validateHasElement(e, CompositePattern.AddComponentMethod.class, "add component method");
            utils.validateHasElement(e, CompositePattern.RemoveComponentMethod.class, "remove component method");
            utils.validateHasElement(e, CompositePattern.GetComponentMethod.class, "get component method");
            utils.validateSomeSuperclassHasAnnotation(e, "Composite", "IComponent", CompositePattern.IComponent.class, CompositePattern.Composite.class);
            utils.validateIsConcreteClass(e, "Composite");
            compositeCounter++;
        }

        boolean anyOfClassesExists = iComponentCounter > 0 || leafCounter > 0 || compositeCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iComponentCounter,"IComponent");
            utils.assertClassExists(leafCounter,"Leaf");
            utils.assertClassExists(compositeCounter,"Composite");
        }
    }
}
