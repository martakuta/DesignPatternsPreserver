package examples.visitor;

import processor.visitor.VisitorPattern;

@VisitorPattern.IElement
public interface Shape {
    void draw();
    @VisitorPattern.AcceptMethod
    void accept(Visitor visitor);
}
