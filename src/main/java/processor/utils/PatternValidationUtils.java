package processor.utils;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.lang.annotation.Annotation;
import java.util.List;

public class PatternValidationUtils {

    private final Messager messager;
    private final Types types;

    private final String patternName;

    public PatternValidationUtils(ProcessingEnvironment processingEnv, String patternName) {
        messager = processingEnv.getMessager();
        types = processingEnv.getTypeUtils();
        this.patternName = patternName;
    }

    public final void validateHasElement(Element srcClass, Class<? extends Annotation> annotation, String elementName) {
        List<? extends Element> enclosedElements = srcClass.getEnclosedElements();

        boolean elementFound = false;

        for (Element e : enclosedElements) {
            if (e.getAnnotationsByType(annotation).length > 0)
                elementFound = true;
        }

        if (!elementFound)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + srcClass.getSimpleName() + " does not contain any " + elementName + ".");
    }

    public final void validateHasStaticElement(Element srcClass, Class<? extends Annotation> annotation, String elementName) {
        List<? extends Element> enclosedElements = srcClass.getEnclosedElements();

        boolean elementFound = false;
        boolean isStatic = true;

        for (Element e : enclosedElements) {
            if (e.getAnnotationsByType(annotation).length > 0) {
                elementFound = true;
                if (!e.getModifiers().contains(Modifier.STATIC))
                    isStatic = false;
            }
        }

        if (!elementFound)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + srcClass.getSimpleName() + " does not contain any " + elementName + ".");
        if (!isStatic)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + srcClass.getSimpleName() + " contains " + elementName + ", but it is not static.");
    }

    public final void validateHasPrivateElement(Element srcClass, Class<? extends Annotation> annotation, String elementName) {
        List<? extends Element> enclosedElements = srcClass.getEnclosedElements();

        boolean elementFound = false;
        boolean isPrivate = true;

        for (Element e : enclosedElements) {
            if (e.getAnnotationsByType(annotation).length > 0) {
                elementFound = true;
                if (!e.getModifiers().contains(Modifier.PRIVATE))
                    isPrivate = false;
            }
        }

        if (!elementFound)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + srcClass.getSimpleName() + " does not contain any " + elementName + ".");
        if (!isPrivate)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + srcClass.getSimpleName() + " contains " + elementName + ", but it is not private.");
    }

    public final void validateIsInterfaceOrAbstractClass(Element e, String annotation) {
        if (!e.getKind().isInterface() && !e.getModifiers().contains(Modifier.ABSTRACT))
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + e.getSimpleName() + " is annotated with '" + annotation + "' so should be an interface or an abstract class.");
    }

    public final void validateIsConcreteClass(Element e, String annotation) {
        if (!e.getKind().isClass() || e.getModifiers().contains(Modifier.ABSTRACT))
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + e.getSimpleName() + " is annotated with '" + annotation + "' so should be a concrete class.");
    }

    @SafeVarargs
    public final void validateSomeSuperclassHasAnnotation(Element e, String classAnnotation, String superclassAnnotation, Class<? extends Annotation>... annotations) {
        boolean someSupertypeHasAnnotation = false;
        for (Class<? extends Annotation> annotation : annotations) {
            for (TypeMirror t : types.directSupertypes(e.asType())) {
                if (types.asElement(t).getAnnotationsByType(annotation).length > 0)
                    someSupertypeHasAnnotation = true;
            }
        }
        if (!someSupertypeHasAnnotation)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. Class " + e.getSimpleName()
                    + " is annotated as '" + classAnnotation + "', but none of its superclasses is annotated as '" + superclassAnnotation + "'.");

    }

    public void assertClassExists(int classCounter, String className) {
        if (classCounter == 0)
            messager.printMessage(Diagnostic.Kind.ERROR, patternName + " design pattern error. There is no '" + className + "' class.");
    }
}
