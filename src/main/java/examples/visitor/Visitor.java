package examples.visitor;

import processor.visitor.VisitorPattern;

@VisitorPattern.IVisitor
public interface Visitor {
    @VisitorPattern.VisitMethod
    void visit(Dot dot);
    @VisitorPattern.VisitMethod
    void visit(Circle circle);
    @VisitorPattern.VisitMethod
    void visit(Rectangle rectangle);
}
