package examples.chainOfResponsibility;

import processor.chainOfResponsibility.ChainOfResponsibilityPattern;

@ChainOfResponsibilityPattern.ConcreteHandler
class NegativeProcessor extends Processor
{
    public NegativeProcessor(Processor nextProcessor){
        super(nextProcessor);

    }

    @ChainOfResponsibilityPattern.HandleMethod
    public void process(Number request)
    {
        if (request.getNumber() < 0)
        {
            System.out.println("NegativeProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}