package examples.builder;

import processor.builder.BuilderPattern;

@BuilderPattern.ConcreteBuilder
public class CarManualBuilder implements Builder {

    @BuilderPattern.ResultField
    private int seats;
    @BuilderPattern.ResultField
    private String engineType;

    @BuilderPattern.BuildStepMethod
    public void setSeats(int seats) {
        this.seats = seats;
    }
    @BuilderPattern.BuildStepMethod
    public void setEngine(String type) {
        this.engineType = type;
    }

    @BuilderPattern.GetResultMethod
    public Manual getResult() {
        return new Manual(seats, engineType);
    }
}
