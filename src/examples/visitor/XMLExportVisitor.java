package examples.visitor;

import processor.visitor.VisitorPattern;

@VisitorPattern.ConcreteVisitor
public class XMLExportVisitor implements Visitor{
    @VisitorPattern.VisitMethod
    @Override
    public void visit(Dot dot) {
        // export Dot to XML
    }
    @VisitorPattern.VisitMethod
    @Override
    public void visit(Circle circle) {
        // export Circle to XML
    }
    @VisitorPattern.VisitMethod
    @Override
    public void visit(Rectangle rectangle) {
        // export Rectangle to XML
    }
}
