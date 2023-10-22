package examples.multipatternEvolution;

import processor.state.StatePattern;

import java.util.ArrayList;

@StatePattern.Context
public class Player {
    @StatePattern.StateField
    private State state;

    private final ArrayList<Song> songs;

    private int currentSong;

    Player() {
        state = new ReadyState(this);
        songs = new ArrayList<>();
        songs.add(new Song("Perfect"));
        songs.add(new Song("Nancy Mulligan"));
        songs.add(new Song("Happier"));
        songs.add(new Song("Supermarket flowers"));
        songs.add(new Song("Galway girl"));
        songs.add(new Song("Shape of you"));
        currentSong = 0;
    }

    public void startPlaying() {System.out.println(songs.get(currentSong).getName());}
    public void stopPlaying() {System.out.println("---[silence]---");}

    public void nextSong() {
        currentSong++;
        if (currentSong == songs.size()) {
            currentSong = 0;
        }
    }

    public void previousSong() {
        currentSong--;
        if (currentSong == -1) {
            currentSong = songs.size() - 1;
        }
    }

    @StatePattern.Operation
    public void clickPlay() {state.clickPlay();}
    @StatePattern.Operation
    public void clickLock() {state.clickLock();}
    @StatePattern.Operation
    public void clickNext() {state.clickNext();}
    @StatePattern.Operation
    public void clickPrevious() {state.clickPrevious();}
    @StatePattern.ChangeStateMethod
    public void changeState(State s) {
        state = s;
    }
}