package hu.cewi.client.user.ui.register;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;

public class RegisterUserActivity extends Activity implements RegisterUserScreen {

    @Inject
    RegisterUserPresenter registerUserPresenter;

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
        // TODO
    }

    @Override
    public void showRegisterUserResponse(String response) {
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
