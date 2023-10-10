package processor.memento;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class MementoPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public MementoPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Memento");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int originatorCounter = 0;
        int mementoCounter = 0;
        int caretakerCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(MementoPattern.Originator.class)) {
            utils.validateHasElement(e, MementoPattern.CreateMementoMethod.class, "save memento method");
            utils.validateHasElement(e, MementoPattern.RestoreMethod.class, "restore method");
            originatorCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(MementoPattern.Memento.class)) {
            mementoCounter++;
        }
        for(Element e : roundEnv.getElementsAnnotatedWith(MementoPattern.Caretaker.class)) {
            utils.validateHasElement(e, MementoPattern.HistoryField.class, "history field");
            utils.validateHasElement(e, MementoPattern.CreateMementoMethod.class, "save memento method");
            utils.validateHasElement(e, MementoPattern.RestoreMethod.class, "restore method");
            caretakerCounter++;
        }

        boolean anyOfClassesExists = originatorCounter > 0 || mementoCounter > 0 || caretakerCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(originatorCounter,"Originator");
            utils.assertClassExists(mementoCounter,"Memento");
            utils.assertClassExists(caretakerCounter,"Caretaker");
        }
    }
}
