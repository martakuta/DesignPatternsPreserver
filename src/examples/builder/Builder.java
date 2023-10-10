package examples.builder;

import processor.builder.BuilderPattern;

@BuilderPattern.IBuilder
public interface Builder {

    @BuilderPattern.BuildStepMethod
    void setSeats(int seats);

    @BuilderPattern.BuildStepMethod
    void setEngine(String type);
}
