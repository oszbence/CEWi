package hu.cewi.client.user.interactor.device.event;

import hu.cewi.client.user.interactor.event.ResponseEvent;

/**
 * Created by Bence on 2016.05.08..
 */
public class GetDeviceStateResponseEvent extends ResponseEvent {

    private final boolean state;

    public GetDeviceStateResponseEvent(boolean success, String msg, boolean state) {
        super(success, msg);
        this.state = state;
    }
}
