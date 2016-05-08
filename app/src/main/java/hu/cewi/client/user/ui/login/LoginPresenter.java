package hu.cewi.client.user.ui.login;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.interactor.account.event.LoginResponseEvent;
import hu.cewi.client.user.ui.Presenter;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void login(final String email, final String pass) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                accountInteractor.loginUser(email, pass);
            }
        });
    }

    public void showRegisterScreen() {
        screen.showRegisterScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final LoginResponseEvent event) {
        if(event.isSuccessful()){
            screen.onLoginSuccess();
        } else {
            screen.onLoginFailure(event.getMessage());
        }
    }
}
