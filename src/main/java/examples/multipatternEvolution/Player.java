package examples.multipatternEvolution;

import processor.memento.MementoPattern;
import processor.state.StatePattern;

import java.util.ArrayList;

@MementoPattern.Originator
@StatePattern.Context
public class Player {
    @StatePattern.StateField
    private State state;

    private final ArrayList<SongInterface> songs;

    private int currentSong;

    public Player() {
        state = new ReadyState(this);
        songs = new ArrayList<>();
        MusicAlbum musicAlbum = new MusicAlbum("Album cover picture");
        songs.add(new SongAdapter(new SongFromMusicAlbum("Perfect", "Na na na na na", musicAlbum)));
        songs.add(new SongAdapter(new SongFromMusicAlbum("Happier", "Na na na na na", musicAlbum)));
        songs.add(new Song("Hello", "Na na na na na", "Adele photography"));
        songs.add(new Song("Skyfall", "Na na na na na", "Another Adele photography"));
        currentSong = 0;
    }

    public void startPlaying() {
        SongInterface song = songs.get(currentSong);
        System.out.println(song.getName() + ", [" + song.getGraphic() + "]: " + song.getMusic());}
    public void stopPlaying() {System.out.println("---silence---");}

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

    @MementoPattern.Memento
    public static class PlayerMemento {
        private final State state;
        private final int currentSong;

        PlayerMemento(State state, int currentSong) {
            this.state = state;
            this.currentSong = currentSong;
        }
    }

    @MementoPattern.CreateMementoMethod
    public PlayerMemento saveMemento() {return new PlayerMemento(state, currentSong);}

    @MementoPattern.RestoreMethod
    public void restoreFromMemento(PlayerMemento m) {
        state = m.state;
        currentSong = m.currentSong;
        startPlaying();
    }
}
