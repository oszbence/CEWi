package hu.cewi.client.user;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.ui.UIModule;
import hu.cewi.client.user.ui.devicecontent.DeviceContentPresenter;
import hu.cewi.client.user.ui.devices.DevicePresenter;
import hu.cewi.client.user.ui.login.LoginPresenter;
import hu.cewi.client.user.ui.main.MainPresenter;
import hu.cewi.client.user.ui.register.RegisterUserPresenter;

/**
 * Created by Bence on 2016.05.11..
 */
@Module
public class AndroidTestModule {

    private final UIModule UIModule;

    public AndroidTestModule(Context context) {

        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }

    @Provides
    @Singleton
    public RegisterUserPresenter provideRegisterUserPresenter() {
        return UIModule.provideRegisterUserPresenter();
    }

    @Provides
    @Singleton
    public DevicePresenter provideDevicePresenter() {
        return UIModule.provideDevicePresenter();
    }

    @Provides
    @Singleton
    public DeviceContentPresenter provideDeviceContentPresenter() {
        return UIModule.provideDeviceContentPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return UIModule.provideNetworkExecutor();
    }
}
