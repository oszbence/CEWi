package hu.cewi.client.user.interactor.device.event;

import hu.cewi.client.user.interactor.event.ResponseEvent;

/**
 * Created by Bence on 2016.05.08..
 */
public class AddDeviceAccessResponseEvent extends ResponseEvent {
    public AddDeviceAccessResponseEvent(boolean success, String msg) {
        super(success, msg);
    }
}
