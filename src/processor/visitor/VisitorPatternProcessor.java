package processor.visitor;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class VisitorPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public VisitorPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Visitor");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int iVisitorCounter = 0;
        int concreteVisitorCounter = 0;
        int iElementCounter = 0;
        int concreteElementCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(VisitorPattern.IVisitor.class)) {
            utils.validateHasElement(e, VisitorPattern.VisitMethod.class, "visit method");
            utils.validateIsInterfaceOrAbstractClass(e, "IVisitor");
            iVisitorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(VisitorPattern.ConcreteVisitor.class)) {
            utils.validateHasElement(e, VisitorPattern.VisitMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteVisitor", "IVisitor", VisitorPattern.IVisitor.class, VisitorPattern.ConcreteVisitor.class);
            utils.validateIsConcreteClass(e, "ConcreteVisitor");
            concreteVisitorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(VisitorPattern.IElement.class)) {
            utils.validateHasElement(e, VisitorPattern.AcceptMethod.class, "accept method");
            utils.validateIsInterfaceOrAbstractClass(e, "IElement");
            iElementCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(VisitorPattern.ConcreteElement.class)) {
            utils.validateHasElement(e, VisitorPattern.AcceptMethod.class, "execute method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteElement", "IElement", VisitorPattern.IElement.class, VisitorPattern.ConcreteElement.class);
            utils.validateIsConcreteClass(e, "ConcreteElement");
            concreteElementCounter++;
        }

        boolean anyOfClassesExists = iVisitorCounter > 0 || concreteVisitorCounter > 0 || iElementCounter > 0 || concreteElementCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iVisitorCounter,"IVisitor");
            utils.assertClassExists(concreteVisitorCounter,"ConcreteVisitor");
            utils.assertClassExists(iElementCounter,"IElement");
            utils.assertClassExists(concreteElementCounter,"ConcreteElement");
        }
    }
}
