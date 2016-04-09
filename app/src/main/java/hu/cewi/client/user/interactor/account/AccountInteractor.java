package hu.cewi.client.user.interactor.account;

import hu.cewi.client.user.CEWiApplication;

/**
 * Created by Bence on 2016.04.09..
 */
public class AccountInteractor {

    public AccountInteractor() {
        CEWiApplication.injector.inject(this);
    }

    /**
     * Synchronous call to server
     * @return true upon success
     */
    public boolean loginUser(String userID, String passwd) {
        // TODO
        return false;
    }

    /**
     * Synchronous call to server
     * @return true upon success
     */
    public boolean logoutUser(String userID, String passwd) {
        // TODO
        return false;
    }

    /**
     * Synchronous call to server
     * @return true upon success
     */
    public boolean registerUser(String userID, String userName, String passwd) {
        // TODO
        return false;
    }
}
