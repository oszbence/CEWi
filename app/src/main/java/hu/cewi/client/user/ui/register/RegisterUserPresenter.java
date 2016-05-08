package hu.cewi.client.user.ui.register;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.interactor.account.event.RegisterUserResponseEvent;
import hu.cewi.client.user.ui.Presenter;

/**
 * Created by Bence on 2016.05.05..
 */
public class RegisterUserPresenter extends Presenter<RegisterUserScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    Context ctx;

    @Inject
    AccountInteractor accountInteractor;

    @Override
    public void attachScreen(RegisterUserScreen screen) {
        super.attachScreen(screen);
        CEWiApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void registerUser(final String name, final String email, final String password) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                accountInteractor.registerUser(email, name, password);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RegisterUserResponseEvent event) {
        if(event.isSuccessful()){
            screen.onRegisterUserSuccess();
        } else {
            screen.onRegisterUserFailure(event.getMessage());
        }
    }
}
