package examples.facade;

import processor.facade.FacadePattern;

@FacadePattern.Facade
public class VideoConverter {
    @FacadePattern.SubsystemObjectField
    private AudioMixer audioMixer;
    @FacadePattern.SubsystemObjectField
    private CodecFactory codecFactory;
    @FacadePattern.SubsystemObjectField
    private MPEG4CompressionCodec mpeg4CompressionCodec;

    @FacadePattern.SubsystemMethod
    public Video convertVideo(Video video) {
        // do some complicated things using above libraries to edit video
        return video;
    }

}
