package examples.multipatternEvolution;

import processor.adapter.AdapterPattern;

@AdapterPattern.AdapteeService
public class SongFromMusicAlbum {
    private final String name;
    private final String music;
    private final MusicAlbum musicAlbum;

    SongFromMusicAlbum(String n, String m, MusicAlbum ma) {
        name = n;
        music = m;
        musicAlbum = ma;
    }

    @AdapterPattern.ServiceMethod
    public String getName() {
        return name;
    }
    @AdapterPattern.ServiceMethod
    public String getMusic() {
        return music;
    }

    @AdapterPattern.ServiceMethod
    public MusicAlbum getMusicAlbum() {
        return musicAlbum;
    }
}
