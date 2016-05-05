package hu.cewi.client.user.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.ui.devicecontent.DeviceContentPresenter;
import hu.cewi.client.user.ui.devices.DevicePresenter;
import hu.cewi.client.user.ui.login.LoginPresenter;
import hu.cewi.client.user.ui.main.MainPresenter;
import hu.cewi.client.user.ui.register.RegisterUserPresenter;

/**
 * Created by Bence on 2016.04.08..
 */
@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public RegisterUserPresenter provideRegisterUserPresenter() {
        return new RegisterUserPresenter();
    }

    @Provides
    @Singleton
    public DevicePresenter provideDevicePresenter() {
        return new DevicePresenter();
    }

    @Provides
    @Singleton
    public DeviceContentPresenter provideDeviceContentPresenter() {
        return new DeviceContentPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}