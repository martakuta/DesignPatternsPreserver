package examples.strategy;

import processor.strategy.StrategyPattern;

import java.util.ArrayList;

@StrategyPattern.Context
public class Navigator {
    @StrategyPattern.StrategyField
    private RouteStrategy routeStrategy;

    Navigator() {
        routeStrategy = new CarStrategy();
    }

    @StrategyPattern.SetStrategyMethod
    public void setStrategy(RouteStrategy rs) {
        routeStrategy = rs;
    }

    @StrategyPattern.ContextOperation
    public ArrayList<Location> buildRoute(Location locationA, Location locationB) {
        return routeStrategy.buildRoute(locationA,locationB);
    }
}
