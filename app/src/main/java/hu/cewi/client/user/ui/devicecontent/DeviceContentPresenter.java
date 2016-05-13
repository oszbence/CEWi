package hu.cewi.client.user.ui.devicecontent;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.device.DeviceInteractor;
import hu.cewi.client.user.interactor.device.event.GetDeviceStateResponseEvent;
import hu.cewi.client.user.interactor.device.event.SetDeviceStateResponseEvent;
import hu.cewi.client.user.ui.Presenter;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void getDeviceState(final String deviceID) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                deviceInteractor.getDeviceState(deviceID);
            }
        });
    }

    public void setDeviceState(final String deviceID, final boolean state) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                deviceInteractor.setDeviceState(deviceID, state);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDeviceStateResponseEvent event) {
        if(event.isSuccessful()){
            screen.showState(event.getState());
        } else {
            screen.showError(event.getMessage());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final SetDeviceStateResponseEvent event) {
        if(event.isSuccessful()){
            screen.onSetDeviceStateSuccessful();
        } else {
            screen.showError(event.getMessage());
        }
    }
}
