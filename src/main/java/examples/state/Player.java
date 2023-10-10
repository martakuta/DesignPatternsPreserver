package examples.state;

import processor.state.StatePattern;

@StatePattern.Context
public class Player {
    @StatePattern.StateField
    private State state;

    public void startPlaying() {}
    public void stopPlaying() {}
    @StatePattern.Operation
    public void clickPlay() {state.clickPlay();}
    @StatePattern.Operation
    public void clickLock() {state.clickLock();}
    @StatePattern.ChangeStateMethod
    public void changeState(State s) {
        state = s;
    }
}
