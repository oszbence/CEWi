package hu.cewi.client.user.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.Module;
import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.ui.devices.DeviceActivity;
import hu.cewi.client.user.ui.login.LoginActivity;

@Module
public class MainActivity extends Activity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CEWiApplication.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    public void onShowDevices(View v){
        mainPresenter.showDevices();
    }

    public void onShowAccounts(View v){
        mainPresenter.showLogin();
    }

    public void onLogoutClicked(View v){
        mainPresenter.logout();
    }

    @Override
    public void showDevices() {
        startActivity(new Intent(this, DeviceActivity.class));
    }

    @Override
    public void showLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void showLogoutResponse(final String response) {
        // runOnUiThread is not required as
        // @Subscribe(threadMode = ThreadMode.MAIN) of EventBus
        // has switched back to UI thread in the Presenter
        /*
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
            }
        });
        */
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
