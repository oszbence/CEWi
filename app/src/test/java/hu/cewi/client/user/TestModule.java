package hu.cewi.client.user;

/**
 * Created by Bence on 2016.05.19..
 */

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.ui.devicecontent.DeviceContentPresenter;
import hu.cewi.client.user.ui.devices.DevicePresenter;
import hu.cewi.client.user.ui.login.LoginPresenter;
import hu.cewi.client.user.ui.main.MainPresenter;
import hu.cewi.client.user.ui.register.RegisterUserPresenter;
import hu.cewi.client.user.utils.UiExecutor;


/**
 * Created by Bence on 2016.05.11..
 */
@Module
public class TestModule {

    Context context;

    public TestModule(Context context) {

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
        return new UiExecutor();
    }
}
