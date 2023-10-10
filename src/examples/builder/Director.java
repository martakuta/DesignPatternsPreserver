package examples.builder;

import processor.builder.BuilderPattern;

@BuilderPattern.Director
public class Director {

    @BuilderPattern.MakeMethod
    public void makeSUV(Builder builder) {
        builder.setSeats(5);
        builder.setEngine("2.0");
    }

    @BuilderPattern.MakeMethod
    public void makeSportCar(Builder builder) {
        builder.setSeats(2);
        builder.setEngine("3.0");
    }
}
