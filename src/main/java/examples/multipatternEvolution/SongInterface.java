package examples.multipatternEvolution;

import processor.adapter.AdapterPattern;

@AdapterPattern.ITarget
public interface SongInterface {
    @AdapterPattern.AdapterMethod
    String getName();
    @AdapterPattern.AdapterMethod
    String getMusic();
    @AdapterPattern.AdapterMethod
    String getGraphic();
}
