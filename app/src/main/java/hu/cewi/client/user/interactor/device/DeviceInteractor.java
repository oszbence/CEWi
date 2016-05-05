package hu.cewi.client.user.interactor.device;

import hu.cewi.client.user.CEWiApplication;

/**
 * Created by Bence on 2016.04.09..
 */
public class DeviceInteractor {

    public DeviceInteractor() {
        CEWiApplication.injector.inject(this);
    }

    public void getDevices() {
        // TODO
    }

    public void addDeviceAccess(String deviceID, String deviceKey) {
        // TODO
    }

    public void removeDeviceAccess(String deviceID) {
        // TODO
    }

    public void getDeviceState(String deviceID) {
        // TODO
    }

    public void setDeviceState(String deviceID, boolean state) {
        // TODO
    }
}
