package hu.cewi.client.user.interactor;

import dagger.Module;
import dagger.Provides;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.interactor.device.DeviceInteractor;

/**
 * Created by Bence on 2016.04.09..
 */
@Module
public class InteractorModule {

    @Provides
    AccountInteractor provideAccountInteractor() {
        return new AccountInteractor();
    }

    @Provides
    DeviceInteractor provideDeviceInteractor() {
        return new DeviceInteractor();
    }
}
