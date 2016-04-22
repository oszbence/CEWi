package hu.cewi.client.user.interactor.account;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.interactor.account.event.LogoutResponseEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Bence on 2016.04.09..
 */
public class AccountInteractor {

    public AccountInteractor() {
        CEWiApplication.injector.inject(this);
    }

    public void loginUser(String userID, String passwd) {
        // TODO
    }

    public void logoutUser(String userID, String passwd) {
        // TODO
        EventBus.getDefault().post(new LogoutResponseEvent(false));
    }

    public void registerUser(String userID, String userName, String passwd) {
        // TODO
    }
}
