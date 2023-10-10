package processor.observer;

import processor.PatternProcessorInterface;
import processor.utils.PatternValidationUtils;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;

public class ObserverPatternProcessor implements PatternProcessorInterface {

    private final PatternValidationUtils utils;

    public ObserverPatternProcessor(ProcessingEnvironment processingEnv) {
        utils = new PatternValidationUtils(processingEnv, "Observer");
    }

    @Override
    public void process( RoundEnvironment roundEnv) {

        int publisherCounter = 0;
        int iSubscriberCounter = 0;
        int concreteSubscriberCounter = 0;

        for(Element e : roundEnv.getElementsAnnotatedWith(ObserverPattern.Publisher.class)) {
            utils.validateHasElement(e, ObserverPattern.SubscribersField.class, "subscribers field");
            utils.validateHasElement(e, ObserverPattern.SubscribeMethod.class, "subscribe method");
            utils.validateHasElement(e, ObserverPattern.UnsubscribeMethod.class, "unsubscribe method");
            utils.validateHasElement(e, ObserverPattern.NotifyMethod.class, "notify method");
            publisherCounter++;
        }

        for(Element e : roundEnv.getElementsAnnotatedWith(ObserverPattern.ConcreteSubscriber.class)) {
            utils.validateHasElement(e, ObserverPattern.UpdateMethod.class, "update method");
            utils.validateSomeSuperclassHasAnnotation(e, "ConcreteSubscriber", "ISubscriber", ObserverPattern.ISubscriber.class, ObserverPattern.ConcreteSubscriber.class);
            utils.validateIsConcreteClass(e, "ConcreteSubscriber");
            concreteSubscriberCounter++;
        }

        for(Element e : roundEnv.getElementsAnnotatedWith(ObserverPattern.ISubscriber.class)) {
            utils.validateHasElement(e, ObserverPattern.UpdateMethod.class, "update method");
            utils.validateIsInterfaceOrAbstractClass(e, "ISubscriber");
            iSubscriberCounter++;
        }

        boolean anyOfClassesExists = iSubscriberCounter > 0 || concreteSubscriberCounter > 0 || publisherCounter > 0;
        if (anyOfClassesExists) {
            utils.assertClassExists(iSubscriberCounter,"ISubscriber");
            utils.assertClassExists(publisherCounter,"Publisher");
        }
    }
}
