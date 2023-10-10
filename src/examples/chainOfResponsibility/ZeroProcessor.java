package examples.chainOfResponsibility;

import processor.chainOfResponsibility.ChainOfResponsibilityPattern;

@ChainOfResponsibilityPattern.ConcreteHandler
class ZeroProcessor extends Processor
{
    public ZeroProcessor(Processor nextProcessor){
        super(nextProcessor);
    }

    @ChainOfResponsibilityPattern.HandleMethod
    public void process(Number request)
    {
        if (request.getNumber() == 0)
        {
            System.out.println("ZeroProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}
