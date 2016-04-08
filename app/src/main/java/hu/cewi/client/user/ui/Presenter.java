package hu.cewi.client.user.ui;

/**
 * Created by Bence on 2016.04.08..
 */
public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}

