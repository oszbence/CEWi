package hu.cewi.client.user.ui.devices;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.device.DeviceInteractor;
import hu.cewi.client.user.interactor.device.event.AddDeviceAccessResponseEvent;
import hu.cewi.client.user.interactor.device.event.GetDevicesResponseEvent;
import hu.cewi.client.user.interactor.device.event.RemoveDeviceAccessResponseEvent;
import hu.cewi.client.user.ui.Presenter;

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
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void getDeviceContent(String deviceID) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                deviceInteractor.getDevices();
            }
        });
    }

    public void addDeviceAccess(final String deviceID, final String deviceKey) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                deviceInteractor.addDeviceAccess(deviceID, deviceKey);
            }
        });
    }

    public void removeDeviceAccess(final String deviceID) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                deviceInteractor.removeDeviceAccess(deviceID);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetDevicesResponseEvent event) {
        if(event.isSuccessful()){

        } else {

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final AddDeviceAccessResponseEvent event) {
        if(event.isSuccessful()){

        } else {

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final RemoveDeviceAccessResponseEvent event) {
        if(event.isSuccessful()){

        } else {

        }
    }
}
