package examples.chainOfResponsibility;

import processor.chainOfResponsibility.ChainOfResponsibilityPattern;

@ChainOfResponsibilityPattern.ConcreteHandler
class PositiveProcessor extends Processor
{

    public PositiveProcessor(Processor nextProcessor){
        super(nextProcessor);
    }

    @ChainOfResponsibilityPattern.HandleMethod
    public void process(Number request)
    {
        if (request.getNumber() > 0)
        {
            System.out.println("PositiveProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}