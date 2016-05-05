package hu.cewi.client.user.mock;

import java.util.ArrayList;
import java.util.List;

import hu.cewi.client.user.mock.model.Device;
import hu.cewi.client.user.network.DeviceApi;

/**
 * Created by Bence on 2016.05.05..
 */
public class MockDeviceApi implements DeviceApi {

    public MockDeviceApi() {
        Device device = new Device("Device1", "Lamp");

    }
}
