package examples.bridge;

import processor.bridge.BridgePattern;

@BridgePattern.Abstraction
public class Remote {
    @BridgePattern.ImplementationField
    private Device device;

    public void togglePower() {
        if (device.isEnabled())
            device.disable();
        else
            device.enable();
    }

    public void volumeUp() {
        int v = device.getVolume();
        device.setVolume(v+1);
    }

    public void volumeDown() {
        int v = device.getVolume();
        device.setVolume(v-1);
    }
}
