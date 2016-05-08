package hu.cewi.client.user.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.ui.Validator;
import hu.cewi.client.user.ui.main.MainActivity;
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
        String email, passwd;
        // Get data from form
        email = ((EditText)findViewById(R.id.loginMailET)).getText().toString();
        passwd = ((EditText)findViewById(R.id.loginPasswordET)).getText().toString();
        // Validate input TODO
        if(!Validator.isValidEmail(email)){
            Toast.makeText(this, getString(R.string.invalidEmail), Toast.LENGTH_LONG)
                    .show();
        }
        else if(passwd.isEmpty()){
            Toast.makeText(this, getString(R.string.passwordMissing), Toast.LENGTH_LONG)
                    .show();
        }
        // All input is valid
        else {
            loginPresenter.login(email, passwd);
        }
    }

    public void onRegisterUser(View v) {
        loginPresenter.showRegisterScreen();
    }

    @Override
    public void showRegisterScreen() {
        startActivity(new Intent(this, RegisterUserActivity.class));
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, getString(R.string.loginSuccess), Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onLoginFailure(String cause) {
        // Toast failure cause
        String response = getString(R.string.registerUserFailed) + "! " +
                getString(R.string.cause) + ": " + cause;
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

}
