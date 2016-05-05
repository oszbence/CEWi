package hu.cewi.client.user;

import javax.inject.Singleton;

import dagger.Component;
import hu.cewi.client.user.interactor.InteractorModule;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.interactor.device.DeviceInteractor;
import hu.cewi.client.user.ui.UIModule;
import hu.cewi.client.user.ui.devices.DeviceActivity;
import hu.cewi.client.user.ui.devices.DevicePresenter;
import hu.cewi.client.user.ui.login.LoginActivity;
import hu.cewi.client.user.ui.login.LoginPresenter;
import hu.cewi.client.user.ui.main.MainActivity;
import hu.cewi.client.user.ui.main.MainPresenter;

/**
 * Created by Bence on 2016.04.08..
 */
@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface CEWiApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(LoginActivity loginActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(DeviceActivity deviceActivity);

    void inject(DevicePresenter devicePresenter);

    void inject(AccountInteractor accountInteractor);

    void inject(DeviceInteractor deviceInteractor);
}
