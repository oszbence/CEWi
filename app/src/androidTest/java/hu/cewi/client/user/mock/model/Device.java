package hu.cewi.client.user.mock.model;

import com.orm.dsl.Table;

/**
 * Created by Bence on 2016.05.05..
 */
@Table
public class Device {
    private Long id;

    String deviceID;
    String deviceName;
    public User owner;

    public Device() {

    }

    public Device(String deviceID, String deviceName) {

    }

    public Long getId() {
        return id;
    }
}
