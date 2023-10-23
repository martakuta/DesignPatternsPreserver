package examples.multipatternEvolution;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class ReadyState extends State {
    ReadyState(Player p) {
        super(p);
    }

    @StatePattern.Operation
    @Override
    public void clickPlay() {
        player.startPlaying();
        player.changeState(new PlayingState(player));
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.changeState(new LockedState(player));
    }

    @StatePattern.Operation
    @Override
    public void clickNext() {
        player.nextSong();
    }

    @StatePattern.Operation
    @Override
    public void clickPrevious() {
        player.previousSong();
    }
}
