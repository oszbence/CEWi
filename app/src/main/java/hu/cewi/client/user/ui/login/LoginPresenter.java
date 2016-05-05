package hu.cewi.client.user.ui.login;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.ui.Presenter;
import hu.cewi.client.user.ui.main.MainScreen;

/**
 * Created by Bence on 2016.05.05..
 */
public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    Context ctx;

    @Inject
    AccountInteractor accountInteractor;

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        CEWiApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void login() {
        // TODO
    }

    public void showRegisterScreen() {
        screen.showRegisterScreen();
    }
}
