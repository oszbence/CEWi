package hu.cewi.client.user.mock.model;

import com.orm.dsl.Table;

/**
 * Created by Bence on 2016.05.05..
 */
@Table
public class MockDevice {
    private Long id;

    String deviceID;
    String deviceName;
    public MockUser owner;

    public MockDevice() {

    }

    public MockDevice(String deviceID, String deviceName) {

    }

    public Long getId() {
        return id;
    }
}
