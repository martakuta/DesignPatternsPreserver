import examples.multipatternEvolution.Player;
import examples.multipatternEvolution.PlayerUser;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerUser alice = new PlayerUser(player);
        alice.listenToMusic();
    }
}