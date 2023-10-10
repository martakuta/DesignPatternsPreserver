package examples.composite;

import processor.composite.CompositePattern;

@CompositePattern.IComponent
public interface Graphic {
    @CompositePattern.ExecuteMethod
    int[][] draw();
}
