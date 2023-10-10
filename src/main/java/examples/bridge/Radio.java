package examples.bridge;

import processor.bridge.BridgePattern;

@BridgePattern.ConcreteImplementation
public class Radio implements Device {

    private boolean enabled;
    private int volume;

    Radio() {
        enabled = false;
        volume = 5;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
