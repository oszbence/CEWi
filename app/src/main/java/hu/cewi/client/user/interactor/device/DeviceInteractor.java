package hu.cewi.client.user.interactor.device;

import hu.cewi.client.user.CEWiApplication;

/**
 * Created by Bence on 2016.04.09..
 */
public class DeviceInteractor {

    public DeviceInteractor() {
        CEWiApplication.injector.inject(this);
    }
}
