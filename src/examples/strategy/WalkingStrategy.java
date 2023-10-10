package examples.strategy;

import processor.strategy.StrategyPattern;

import java.util.ArrayList;

@StrategyPattern.ConcreteStrategy
public class WalkingStrategy implements RouteStrategy {
    @StrategyPattern.StrategyOperation
    @Override
    public ArrayList<Location> buildRoute(Location locationA, Location locationB) {
        ArrayList<Location> route = new ArrayList<>();
        // add points of the best route for walking people
        return route;
    }
}
