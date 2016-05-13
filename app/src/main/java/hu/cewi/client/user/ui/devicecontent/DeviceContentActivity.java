package hu.cewi.client.user.ui.devicecontent;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;

public class DeviceContentActivity extends Activity implements DeviceContentScreen {

    private TextView deviceNameTV;

    private RadioButton deviceStateRB;

    private Switch setDeviceStateSW;

    @Inject
    DeviceContentPresenter deviceContentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_content);

        CEWiApplication.injector.inject(this);

        deviceNameTV = (TextView) findViewById(R.id.deviceNameTV);
        deviceStateRB = (RadioButton) findViewById(R.id.deviceStateRB);
        setDeviceStateSW = (Switch) findViewById(R.id.setDeviceStateSW);
    }

    @Override
    protected void onStart() {
        super.onStart();
        deviceContentPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Get parent device ID
        String parentDeviceID = this.getIntent().getStringExtra("deviceID");
        // Get parent device ID
        String parentDeviceName = this.getIntent().getStringExtra("deviceName");
        // If we got a new parent device ID from devices activity
        if(parentDeviceID!=null){
            // Save parent device ID
            SharedPreferences prefs = getSharedPreferences("UIActivityPrefs", 0);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("parentDeviceID", parentDeviceID);
            // Save parent device name
            editor.putString("parentDeviceName", parentDeviceName);

            editor.commit();
        }
        else {
            // Load parent device ID
            parentDeviceID = getSharedPreferences("UIActivityPrefs", 0).getString("parentDeviceID", null);
            // Load parent device name
            parentDeviceName = getSharedPreferences("UIActivityPrefs", 0).getString("parentDeviceName", null);
        }
        // Show device name on ui
        deviceNameTV.setText(parentDeviceName);
        // Get device state from server
        deviceContentPresenter.getDeviceState(parentDeviceID);
    }

    @Override
    protected void onStop() {
        super.onStop();
        deviceContentPresenter.detachScreen();
    }


    @Override
    public void showState(boolean state) {
        // Show state info coming from the server
        if(state) {
            deviceStateRB.setText(getText(R.string.on));
        } else {
            deviceStateRB.setText(getText(R.string.off));
        }
        deviceStateRB.setChecked(state);
        setDeviceStateSW.setChecked(state);
    }

    @Override
    public void onSetDeviceStateSuccessful() {
        // Load parent device ID
        String parentDeviceID = getSharedPreferences("UIActivityPrefs", 0).getString("parentDeviceID", null);
        deviceContentPresenter.getDeviceState(parentDeviceID);
    }

    @Override
    public void showError(String cause) {
        // Toast failure cause
        String response = getString(R.string.error) + "! " +
                getString(R.string.cause) + ": " + cause;
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

    public void onStateSwitched(View v) {
        // Load parent device ID
        String parentDeviceID = getSharedPreferences("UIActivityPrefs", 0).getString("parentDeviceID", null);
        // Get state from switch set by user
        boolean state = setDeviceStateSW.isChecked();
        deviceContentPresenter.setDeviceState(parentDeviceID, state);
    }
}
