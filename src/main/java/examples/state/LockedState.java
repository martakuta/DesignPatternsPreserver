package examples.state;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class LockedState extends State {
    @StatePattern.Operation
    @Override
    public void clickPlay() {
        // nothing
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.changeState(new ReadyState());
    }
}
