package examples.visitor;

import processor.visitor.VisitorPattern;

@VisitorPattern.ConcreteElement
public class Rectangle implements Shape{
    @Override
    public void draw() {}

    @VisitorPattern.AcceptMethod
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
