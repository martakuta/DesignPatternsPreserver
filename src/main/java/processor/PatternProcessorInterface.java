package processor;

import javax.annotation.processing.RoundEnvironment;

public interface PatternProcessorInterface {

    void process(RoundEnvironment roundEnv);
}
