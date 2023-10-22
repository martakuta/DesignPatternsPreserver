package examples.multipatternEvolution;

import processor.state.StatePattern;

@StatePattern.IState
public abstract class State {
    protected Player player;

    State(Player p) {
        player = p;
    }
    @StatePattern.Operation
    public abstract void clickPlay();
    @StatePattern.Operation
    public abstract void clickLock();
    @StatePattern.Operation
    public abstract void clickNext();
    @StatePattern.Operation
    public abstract void clickPrevious();
}
