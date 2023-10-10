package processor.builder;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class BuilderPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;
    public BuilderPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Builder");
    }

    @Override
    public void process(RoundEnvironment roundEnv) {

        int iBuilderCounter = 0;
        int concreteBuilderCounter = 0;
        int directorCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(BuilderPattern.IBuilder.class)) {
            utils.validateHasElement(e, BuilderPattern.BuildStepMethod.class, "build step method");
            utils.validateIsInterfaceOrAbstractClass(e, "IBuilder");
            iBuilderCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(BuilderPattern.ConcreteBuilder.class)) {
            utils.validateHasElement(e, BuilderPattern.BuildStepMethod.class, "build step method");
            utils.validateHasElement(e, BuilderPattern.GetResultMethod.class, "get result method");
            utils.validateHasElement(e, BuilderPattern.ResultField.class, "result field");
            utils.validateIsConcreteClass(e, "ConcreteBuilder");
            concreteBuilderCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(BuilderPattern.Director.class)) {
            utils.validateHasElement(e, BuilderPattern.MakeMethod.class, "make method");
            directorCounter++;
        }

        boolean anyOfClassesExists = iBuilderCounter > 0 || concreteBuilderCounter > 0 || directorCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(concreteBuilderCounter,"ConcreteBuilder");
        }
    }
}
