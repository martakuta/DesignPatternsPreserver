package examples.strategy;

import java.util.ArrayList;

public class Client {
    private Navigator navigator;

    public void go() {
        Location locationA = new Location("home", 0,0);
        Location locationB = new Location("parents home", 1,1);

        ArrayList<Location> route1 = navigator.buildRoute(locationA, locationB);

        WalkingStrategy walkingStrategy = new WalkingStrategy();
        navigator.setStrategy(walkingStrategy);

        ArrayList<Location> route2 = navigator.buildRoute(locationA, locationB);


    }
}
