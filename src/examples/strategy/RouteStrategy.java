package examples.strategy;

import processor.strategy.StrategyPattern;

import java.util.ArrayList;

@StrategyPattern.IStrategy
public interface RouteStrategy {
    @StrategyPattern.StrategyOperation
    ArrayList<Location> buildRoute(Location locationA, Location locationB);
}
