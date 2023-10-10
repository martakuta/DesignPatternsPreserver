package examples.state;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class ReadyState extends State {
    @StatePattern.Operation
    @Override
    public void clickPlay() {
        player.startPlaying();
        player.changeState(new PlayingState());
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.changeState(new LockedState());
    }
}
