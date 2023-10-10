package examples.state;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class PlayingState extends State {
    @StatePattern.Operation
    @Override
    public void clickPlay() {
        player.stopPlaying();
        player.changeState(new ReadyState());
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.stopPlaying();
        player.changeState(new LockedState());
    }
}
