package hu.cewi.client.user.ui.devicecontent;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.device.DeviceInteractor;
import hu.cewi.client.user.ui.Presenter;
import hu.cewi.client.user.ui.devices.DeviceScreen;

/**
 * Created by Bence on 2016.05.05..
 */
public class DeviceContentPresenter extends Presenter<DeviceContentScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    Context ctx;

    @Inject
    DeviceInteractor deviceInteractor;

    @Override
    public void attachScreen(DeviceContentScreen screen) {
        super.attachScreen(screen);
        CEWiApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
