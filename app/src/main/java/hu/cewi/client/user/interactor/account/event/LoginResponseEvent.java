package hu.cewi.client.user.interactor.account.event;

import hu.cewi.client.user.interactor.event.ResponseEvent;

/**
 * Created by Bence on 2016.05.08..
 */
public class LoginResponseEvent extends ResponseEvent {
    public LoginResponseEvent(boolean success, String msg) {
        super(success, msg);
    }
}
