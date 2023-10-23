package examples.multipatternEvolution;

import processor.state.StatePattern;

@StatePattern.ConcreteState
public class PlayingState extends State {
    PlayingState(Player p) {
        super(p);
    }

    @StatePattern.Operation
    @Override
    public void clickPlay() {
        player.stopPlaying();
        player.changeState(new ReadyState(player));
    }
    @StatePattern.Operation
    @Override
    public void clickLock() {
        player.stopPlaying();
        player.changeState(new LockedState(player));
    }

    @StatePattern.Operation
    @Override
    public void clickNext() {
        player.nextSong();
        player.startPlaying();
    }

    @StatePattern.Operation
    @Override
    public void clickPrevious() {
        player.previousSong();
        player.startPlaying();
    }
}
