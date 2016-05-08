package hu.cewi.client.user.ui.login;

/**
 * Created by Bence on 2016.05.05..
 */
public interface LoginScreen {

    void showRegisterScreen();

    void onLoginSuccess();

    void onLoginFailure(String cause);
}
