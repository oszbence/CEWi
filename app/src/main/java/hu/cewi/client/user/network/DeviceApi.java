package hu.cewi.client.user.network;

import java.util.List;

import hu.cewi.client.user.model.Device;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Bence on 2016.05.05..
 */
public interface DeviceApi {

    /**
     *
     * Get devices of a user
     */

    @GET("devices/access")
    Call<List<Device>> getDevices();



    /**
     *
     * Add device access
     * @param deviceID device id
     * @param deviceKey device key
     * @return Call<Void>
     */

    @PUT("devices/access")
    Call<Void> addDeviceAccess(
            @Query("deviceID") String deviceID, @Query("deviceKey") String deviceKey
    );


    /**
     *
     * Remove device access
     * @param deviceID device id
     * @return Call<Void>
     */

    @DELETE("devices/access")
    Call<Void> removeDeviceAccess(
            @Query("deviceID") String deviceID
    );


    /**
     *
     * Get state of a device
     * @param deviceID device id
     * @return Call<Boolean>
     */

    @GET("devices/access/state")
    Call<Boolean> getDeviceState(
            @Query("deviceID") String deviceID
    );


    /**
     *
     * Set device state
     * @param deviceID device id
     * @param state device state
     * @return Call<Void>
     */

    @POST("devices/access/state")
    Call<Void> setDeviceState(
            @Query("deviceID") String deviceID, @Query("state") Boolean state
    );
}
