package hu.cewi.client.user.interactor.event;

/**
 * Created by mobsoft on 2016. 04. 22..
 */
public abstract class ResponseEvent {

    private boolean successful;
    private String message;

    public ResponseEvent(boolean success, String msg) {
        successful = success;
        message = msg;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
