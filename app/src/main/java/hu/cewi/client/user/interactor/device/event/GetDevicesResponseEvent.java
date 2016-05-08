package hu.cewi.client.user.interactor.device.event;

import java.util.List;

import hu.cewi.client.user.interactor.event.ResponseEvent;
import hu.cewi.client.user.model.Device;

/**
 * Created by Bence on 2016.05.08..
 */
public class GetDevicesResponseEvent extends ResponseEvent {

    private final List<Device> devices;

    public GetDevicesResponseEvent(boolean success, String msg, List<Device> deviceList) {
        super(success, msg);
        devices = deviceList;
    }

    public List<Device> getDevices() {
        return devices;
    }
}
