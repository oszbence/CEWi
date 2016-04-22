package hu.cewi.client.user.interactor.account.event;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public class LogoutResponseEvent {

    private boolean successful;

    public LogoutResponseEvent(boolean success) {
        successful = success;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
