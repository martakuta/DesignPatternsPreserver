package examples.bridge;

import processor.bridge.BridgePattern;

@BridgePattern.IImplementation
public interface Device {
    public boolean isEnabled();
    public void enable();
    public void disable();
    public int getVolume();
    public void setVolume(int volume);
}
