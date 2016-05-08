package hu.cewi.client.user.interactor.device;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.interactor.device.event.AddDeviceAccessResponseEvent;
import hu.cewi.client.user.interactor.device.event.GetDeviceStateResponseEvent;
import hu.cewi.client.user.interactor.device.event.GetDevicesResponseEvent;
import hu.cewi.client.user.interactor.device.event.RemoveDeviceAccessResponseEvent;
import hu.cewi.client.user.interactor.device.event.SetDeviceStateResponseEvent;
import hu.cewi.client.user.model.Device;
import hu.cewi.client.user.network.DeviceApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Bence on 2016.04.09..
 */
public class DeviceInteractor {

    @Inject
    DeviceApi deviceApi;

    public DeviceInteractor() {
        CEWiApplication.injector.inject(this);
    }

    public void getDevices() {
        Call<List<Device>> call = deviceApi.getDevices();
        boolean success = false;
        String message = "Client error";
        List<Device> devices = null;
        try {
            Response<List<Device>> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
            devices = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new GetDevicesResponseEvent(success, message, devices));
    }

    public void addDeviceAccess(String deviceID, String deviceKey) {
        Call<Void> call = deviceApi.addDeviceAccess(deviceID, deviceKey);
        boolean success = false;
        String message = "Client error";
        try {
            Response<Void> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new AddDeviceAccessResponseEvent(success, message));
    }

    public void removeDeviceAccess(String deviceID) {
        Call<Void> call = deviceApi.removeDeviceAccess(deviceID);
        boolean success = false;
        String message = "Client error";
        try {
            Response<Void> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new RemoveDeviceAccessResponseEvent(success, message));
    }

    public void getDeviceState(String deviceID) {
        Call<Boolean> call = deviceApi.getDeviceState(deviceID);
        boolean success = false;
        String message = "Client error";
        boolean state = false;
        try {
            Response<Boolean> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
            state = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new GetDeviceStateResponseEvent(success, message, state));
    }

    public void setDeviceState(String deviceID, boolean state) {
        Call<Void> call = deviceApi.setDeviceState(deviceID, state);
        boolean success = false;
        String message = "Client error";
        try {
            Response<Void> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new SetDeviceStateResponseEvent(success, message));
    }
}
