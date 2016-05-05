package hu.cewi.client.user.ui.devices;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import hu.cewi.client.user.R;

public class DeviceActivity extends Activity implements DeviceScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
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
