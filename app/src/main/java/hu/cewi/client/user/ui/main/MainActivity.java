package hu.cewi.client.user.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import dagger.Module;
import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;

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
        //startActivity(new Intent(this, DeviceActivity.class));
    }

    public void onShowAccounts(View v){
        //startActivity(new Intent(this, LoginActivity.class));
    }

    public void onLogoutClicked(View v){

    }
}
