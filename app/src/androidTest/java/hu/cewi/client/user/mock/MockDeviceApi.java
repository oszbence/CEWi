package hu.cewi.client.user.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.cewi.client.user.mock.model.MockDevice;
import hu.cewi.client.user.model.Device;
import hu.cewi.client.user.network.DeviceApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * Created by Bence on 2016.05.05..
 */
public class MockDeviceApi implements DeviceApi {

    private Device coffeMachine = new Device("Coffee Machine","COFFEE-01");
    private Device lamp = new Device("Lamp","LIGHT-01");
    private Device teapot = new Device("Smart Teapot","TEA-01");

    private Map<String, Device> devices = new HashMap<>();

    public MockDeviceApi() {
        // User has these devices on start
        devices.put(coffeMachine.id, coffeMachine);
        devices.put(lamp.id, lamp);
    }

    @Override
    public Call<List<Device>> getDevices() {
        return new Call<List<Device>>() {
            @Override
            public Response<List<Device>> execute() throws IOException {
                List<Device> list = new ArrayList<Device>(devices.values());
                return Response.success(list);
            }

            @Override
            public void enqueue(Callback<List<Device>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Device>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    @Override
    public Call<Void> addDeviceAccess(@Query("deviceID") String deviceID,
                                      @Query("deviceKey") String deviceKey) {
        // User now has access to a smart teapot
        devices.put(teapot.id, teapot);
        return new Call<Void>() {
            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    @Override
    public Call<Void> removeDeviceAccess(@Query("deviceID") String deviceID) {
        devices.remove(deviceID);
        return new Call<Void>() {
            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    @Override
    public Call<Boolean> getDeviceState(@Query("deviceID") final String deviceID) {
        return new Call<Boolean>() {
            @Override
            public Response<Boolean> execute() throws IOException {
                return Response.success(devices.get(deviceID).state);
            }

            @Override
            public void enqueue(Callback<Boolean> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Boolean> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    @Override
    public Call<Void> setDeviceState(@Query("deviceID") String deviceID,
                                     @Query("state") Boolean state) {
        devices.get(deviceID).state = state;
        return new Call<Void>() {
            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }
}