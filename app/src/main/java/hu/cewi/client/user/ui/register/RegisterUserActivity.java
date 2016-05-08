package hu.cewi.client.user.ui.register;

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
import hu.cewi.client.user.ui.login.LoginActivity;

public class RegisterUserActivity extends Activity implements RegisterUserScreen {

    @Inject
    RegisterUserPresenter registerUserPresenter;

    @Inject
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        CEWiApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerUserPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        registerUserPresenter.detachScreen();
    }

    public void onRegisterUser(View v) {
        String email, userName, passwd, confPasswd;
        // Get data from form
        email = ((EditText)findViewById(R.id.regMailET)).getText().toString();
        userName = ((EditText)findViewById(R.id.regNameET)).getText().toString();
        passwd = ((EditText)findViewById(R.id.regPassET)).getText().toString();
        confPasswd = ((EditText)findViewById(R.id.regConfPassET)).getText().toString();
        // Validate input TODO
        if(userName.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.nameIsMissing), Toast.LENGTH_LONG)
                    .show();
        }
        else if(!Validator.isValidEmail(email)){
            Toast.makeText(getApplicationContext(), getString(R.string.invalidEmail), Toast.LENGTH_LONG)
                    .show();
        }
        else if(passwd.isEmpty()){
            Toast.makeText(getApplicationContext(), getString(R.string.passwordMissing), Toast.LENGTH_LONG)
                    .show();
        }
        else if(!passwd.equals(confPasswd)){
            Toast.makeText(getApplicationContext(), getString(R.string.passwordsNotMatch), Toast.LENGTH_LONG)
                    .show();
        }
        // All input is valid
        else{
            registerUserPresenter.registerUser(userName, email, passwd);
        }
    }

    @Override
    public void onRegisterUserSuccess() {
        Toast.makeText(this, getString(R.string.registerUserSuccess), Toast.LENGTH_LONG).show();
        // Step back to login screen
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onRegisterUserFailure(String cause) {
        // Toast failure cause
        String response = ctx.getString(R.string.registerUserFailed) + "! " +
                ctx.getString(R.string.cause) + ": " + cause;
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
