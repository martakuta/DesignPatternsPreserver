package examples.command;

import processor.command.CommandPattern;

import java.util.ArrayList;

@CommandPattern.Receiver
public class KitchenChef {
    private ArrayList<String> soup;
    private ArrayList<String> vegetablesInTheKitchen;

    KitchenChef(ArrayList<String> vegetables) {
        vegetablesInTheKitchen = vegetables;
    }
    @CommandPattern.ActionMethod
    public void cookSoup(int vegetables, boolean meat, boolean onion) {
        if (meat)
            soup.add("meat");
        if (onion)
            soup.add("onion");
        for (int i=0;i<vegetables;i++){
            soup.add(vegetablesInTheKitchen.get(i));
        }
    }
}
