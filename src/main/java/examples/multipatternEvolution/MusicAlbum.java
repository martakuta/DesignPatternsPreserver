package examples.multipatternEvolution;

import java.util.ArrayList;

public class MusicAlbum {
    private ArrayList<Song> songs;
    private final String coverGraphic;

    MusicAlbum(String g) {
        coverGraphic = g;
    }

    public String getCoverGraphic() {
        return coverGraphic;
    }
}
