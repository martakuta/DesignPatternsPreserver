package examples.multipatternEvolution;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class LockedState extends State {
    LockedState(Player p) {
        super(p);
    }

    @StatePattern.Operation
    @Override
    public void clickPlay() {
        System.out.println("Warning, it is impossible to click any player button when device is locked.");
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.changeState(new ReadyState(player));
    }

    @StatePattern.Operation
    @Override
    public void clickNext() {
        System.out.println("Warning, it is impossible to click any player button when device is locked.");
    }

    @StatePattern.Operation
    @Override
    public void clickPrevious() {
        System.out.println("Warning, it is impossible to click any player button when device is locked.");
    }
}
