package examples.strategy;

import processor.strategy.StrategyPattern;

import java.util.ArrayList;

@StrategyPattern.ConcreteStrategy
public class CarStrategy implements RouteStrategy {
    @StrategyPattern.StrategyOperation
    @Override
    public ArrayList<Location> buildRoute(Location locationA, Location locationB) {
        ArrayList<Location> route = new ArrayList<>();
        // add points of the best route for drivers
        return route;
    }
}
