package examples.chainOfResponsibility;

import processor.chainOfResponsibility.ChainOfResponsibilityPattern;

@ChainOfResponsibilityPattern.IHandler
abstract class Processor
{
    private Processor nextProcessor;

    public Processor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    @ChainOfResponsibilityPattern.HandleMethod
    public void process(Number request){
        if(nextProcessor != null)
            nextProcessor.process(request);
    };
}