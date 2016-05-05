package hu.cewi.client.user.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.ui.register.RegisterUserActivity;

public class LoginActivity extends Activity implements LoginScreen {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CEWiApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginPresenter.detachScreen();
    }

    public void onLogin(View v) {
        loginPresenter.login();
    }

    public void onRegisterUser(View v) {
        loginPresenter.showRegisterScreen();
    }

    @Override
    public void showRegisterScreen() {
        startActivity(new Intent(this, RegisterUserActivity.class));
    }

    @Override
    public void showLoginResponse(String response) {
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
