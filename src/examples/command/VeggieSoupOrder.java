package examples.command;

import processor.command.CommandPattern;

@CommandPattern.ConcreteCommand
public class VeggieSoupOrder implements OrderInterface {

    private KitchenChef kitchenChef;
    private int vegetables;
    private boolean meat;
    private boolean onion;

    VeggieSoupOrder(int vegetables, boolean meat, boolean onion) {
        this.vegetables = vegetables;
        this.meat = meat;
        this.onion = onion;
    }
    @CommandPattern.ExecuteMethod
    @Override
    public void order() {
        kitchenChef.cookSoup(vegetables,meat,onion);
    }
}
