package hu.cewi.client.user.interactor.account.event;

import hu.cewi.client.user.interactor.event.ResponseEvent;

/**
 * Created by Bence on 2016.05.08..
 */
public class RegisterUserResponseEvent extends ResponseEvent {
    public RegisterUserResponseEvent(boolean success, String msg) {
        super(success, msg);
    }
}
