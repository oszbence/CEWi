package hu.cewi.client.user.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import dagger.Module;
import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.ui.devices.DeviceActivity;
import hu.cewi.client.user.ui.login.LoginActivity;

@Module
public class MainActivity extends Activity implements MainScreen {

    private Tracker mTracker;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CEWiApplication.injector.inject(this);

        // Obtain the shared Tracker instance.
        CEWiApplication application = (CEWiApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTracker.setScreenName("MainScreen");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
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

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Logout")
                .build());
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
    public void onLogoutSuccess() {
        Toast.makeText(this, getString(R.string.logoutSuccess), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLogoutError() {
        Toast.makeText(this, getString(R.string.logoutFailed), Toast.LENGTH_LONG).show();
    }

}
