package hu.cewi.client.user.model;

/**
 * Created by Bence on 2016.05.06..
 */
public class RegisterParams {
    public String email;
    public String displayName;
    public String password;

    public RegisterParams(String email, String name, String pass) {
        this.email = email;
        displayName = name;
        password = pass;
    }
}
