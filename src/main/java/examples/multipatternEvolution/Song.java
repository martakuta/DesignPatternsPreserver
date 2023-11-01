package examples.multipatternEvolution;

public class Song implements SongInterface {
    private final String name;
    private final String music;
    private final String graphic;

    Song(String n, String m, String g) {
        name = n;
        music = m;
        graphic = g;
    }

    public String getName() {
        return name;
    }
    public String getMusic() {
        return music;
    }

    public String getGraphic() {
        return graphic;
    }
}
