import examples.multipatternEvolution.Player;
import examples.multipatternEvolution.PlayerUser;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerUser alice = new PlayerUser(player);
        alice.listenToMusic();
    }
}