package hu.cewi.client.user.ui.devices;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.interactor.device.DeviceInteractor;
import hu.cewi.client.user.ui.Presenter;
import hu.cewi.client.user.ui.login.LoginScreen;

/**
 * Created by Bence on 2016.05.05..
 */
public class DevicePresenter extends Presenter<DeviceScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    Context ctx;

    @Inject
    DeviceInteractor deviceInteractor;

    @Override
    public void attachScreen(DeviceScreen screen) {
        super.attachScreen(screen);
        CEWiApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getDeviceContent(String deviceID) {
        // TODO
    }

    public void addDeviceAccess(String deviceID, String deviceKey) {
        // TODO
    }

    public void removeDeviceAccess(String deviceID) {
        // TODO
    }
}
