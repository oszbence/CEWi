package hu.cewi.client.user.ui.devices;

import java.util.List;

import hu.cewi.client.user.model.Device;

/**
 * Created by Bence on 2016.05.05..
 */
public interface DeviceScreen {

    void showDevices(List<Device> devices);

    void onAddDeviceAccessSuccess();

    void onRemoveDeviceAccessSuccess();

    void showError(String cause);
}
