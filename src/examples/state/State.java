package examples.state;

import processor.state.StatePattern;

@StatePattern.IState
public abstract class State {
    protected Player player;
    @StatePattern.Operation
    public abstract void clickPlay();
    @StatePattern.Operation
    public abstract void clickLock();
}
