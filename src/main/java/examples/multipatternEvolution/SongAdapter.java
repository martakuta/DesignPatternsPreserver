package examples.multipatternEvolution;

import processor.adapter.AdapterPattern;

@AdapterPattern.Adapter
public class SongAdapter implements SongInterface {
    @AdapterPattern.AdapteeServiceField
    private final SongFromMusicAlbum song;

    SongAdapter(SongFromMusicAlbum s) {
        song = s;
    }

    @AdapterPattern.AdapterMethod
    public String getName() {
        return song.getName();
    }
    @AdapterPattern.AdapterMethod
    public String getMusic() {
        return song.getMusic();
    }
    @AdapterPattern.AdapterMethod
    public String getGraphic() {
        return song.getMusicAlbum().getCoverGraphic();
    }

}
