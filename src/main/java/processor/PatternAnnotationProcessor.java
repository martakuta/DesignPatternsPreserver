package processor;

import processor.abstractFactory.AbstractFactoryPatternProcessor;
import processor.adapter.AdapterPatternProcessor;
import processor.bridge.BridgePatternProcessor;
import processor.builder.BuilderPatternProcessor;
import processor.chainOfResponsibility.ChainOfResponsibilityPatternProcessor;
import processor.command.CommandPatternProcessor;
import processor.composite.CompositePatternProcessor;
import processor.decorator.DecoratorPatternProcessor;
import processor.facade.FacadePatternProcessor;
import processor.factoryMethod.FactoryMethodPatternProcessor;
import processor.flyweight.FlyweightPatternProcessor;
import processor.interpreter.InterpreterPatternProcessor;
import processor.iterator.IteratorPatternProcessor;
import processor.mediator.MediatorPatternProcessor;
import processor.memento.MementoPatternProcessor;
import processor.observer.ObserverPatternProcessor;
import processor.prototype.PrototypePatternProcessor;
import processor.proxy.ProxyPatternProcessor;
import processor.singleton.SingletonPatternProcessor;
import processor.state.StatePatternProcessor;
import processor.strategy.StrategyPatternProcessor;
import processor.templateMethod.TemplateMethodPatternProcessor;
import processor.visitor.VisitorPatternProcessor;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class PatternAnnotationProcessor implements Processor {
    private ArrayList<PatternProcessorInterface> patternProcessors;

    @Override
    public Set<String> getSupportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton("*");
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_17;
    }

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        patternProcessors = new ArrayList<>();
        patternProcessors.add(new AbstractFactoryPatternProcessor(processingEnv));
        patternProcessors.add(new AdapterPatternProcessor(processingEnv));
        patternProcessors.add(new BridgePatternProcessor(processingEnv));
        patternProcessors.add(new BuilderPatternProcessor(processingEnv));
        patternProcessors.add(new ChainOfResponsibilityPatternProcessor(processingEnv));
        patternProcessors.add(new CommandPatternProcessor(processingEnv));
        patternProcessors.add(new CompositePatternProcessor(processingEnv));
        patternProcessors.add(new DecoratorPatternProcessor(processingEnv));
        patternProcessors.add(new FacadePatternProcessor(processingEnv));
        patternProcessors.add(new FactoryMethodPatternProcessor(processingEnv));
        patternProcessors.add(new FlyweightPatternProcessor(processingEnv));
        patternProcessors.add(new InterpreterPatternProcessor(processingEnv));
        patternProcessors.add(new IteratorPatternProcessor(processingEnv));
        patternProcessors.add(new MediatorPatternProcessor(processingEnv));
        patternProcessors.add(new MementoPatternProcessor(processingEnv));
        patternProcessors.add(new ObserverPatternProcessor(processingEnv));
        patternProcessors.add(new PrototypePatternProcessor(processingEnv));
        patternProcessors.add(new ProxyPatternProcessor(processingEnv));
        patternProcessors.add(new SingletonPatternProcessor(processingEnv));
        patternProcessors.add(new StatePatternProcessor(processingEnv));
        patternProcessors.add(new StrategyPatternProcessor(processingEnv));
        patternProcessors.add(new TemplateMethodPatternProcessor(processingEnv));
        patternProcessors.add(new VisitorPatternProcessor(processingEnv));
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (PatternProcessorInterface processor : patternProcessors) {
            processor.process(roundEnv);
        }
        return false;
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return Collections.emptySet();
    }
}
