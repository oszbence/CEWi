package hu.cewi.client.user.model;

/**
 * Created by Bence on 2016.05.06..
 */
public class Device {

    public String name;
    public String id;
    public boolean state;

    public Device(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return name;
    }
}
