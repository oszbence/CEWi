package hu.cewi.client.user.ui.devices;

/**
 * Created by Bence on 2016.05.05..
 */
public interface DeviceScreen {

    void showGetDeviceContentResponse();

    void showAddDeviceAccessResponse(String response);

    void showRemoveDeviceAccessResponse(String response);
}
