package examples.command;

import processor.command.CommandPattern;

@CommandPattern.Invoker
public class RestaurantClient {

    private SoupWithoutOnionOrder soupWithoutOnionOrder;
    private VeggieSoupOrder veggieSoupOrder;
    public void orderVeggieSoup() {
        veggieSoupOrder.order();
    }

    public void orderSoupWithoutOnion() {
        soupWithoutOnionOrder.order();
    }
}
