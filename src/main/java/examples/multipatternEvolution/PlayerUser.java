package examples.multipatternEvolution;

import processor.memento.MementoPattern;

import java.util.ArrayList;

@MementoPattern.Caretaker
public class PlayerUser {

    private final Player player;

    @MementoPattern.HistoryField
    ArrayList<Player.PlayerMemento> history;

    public PlayerUser(Player player) {
        this.player = player;
        history = new ArrayList<>();
    }

    @MementoPattern.CreateMementoMethod
    public void saveMemento() {
        history.add(player.saveMemento());
    }

    @MementoPattern.RestoreMethod
    public void restoreMemento() {
        player.restoreFromMemento(history.get(history.size()-1));
    }

    public void listenToMusic() {
        Player player = new Player();
        player.clickPlay();
        saveMemento();
        player.clickPlay();
        player.clickNext();
        player.clickPlay();
        player.clickNext();
        player.clickLock();
        player.clickPlay();
        player.clickLock();
        player.clickPlay();
        restoreMemento();
    }
}
