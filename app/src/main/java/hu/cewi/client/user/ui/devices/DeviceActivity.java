package hu.cewi.client.user.ui.devices;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;

public class DeviceActivity extends Activity implements DeviceScreen {

    @Inject
    DevicePresenter devicePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        CEWiApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        devicePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        devicePresenter.detachScreen();
    }

    @Override
    public void showGetDeviceContentResponse() {

    }

    @Override
    public void showAddDeviceAccessResponse(String response) {
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRemoveDeviceAccessResponse(String response) {
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
