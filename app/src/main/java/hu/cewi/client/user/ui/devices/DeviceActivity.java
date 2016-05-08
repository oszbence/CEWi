package hu.cewi.client.user.ui.devices;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.model.Device;
import hu.cewi.client.user.ui.devicecontent.DeviceContentActivity;

public class DeviceActivity extends Activity implements DeviceScreen {

    private ListView deviceListView;

    private ArrayAdapter<Device> deviceListAdapter;

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
    public void showDevices(List<Device> devices) {
        // TODO optimize
        deviceListAdapter = new ArrayAdapter<Device>(this, R.layout.list_item,  devices);

        deviceListView = (ListView) findViewById(R.id.deviceListView);
        deviceListView.setAdapter(deviceListAdapter);
        deviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final Device item = (Device) parent.getItemAtPosition(position);
                // Start device control activity of selected device
                Intent intent = new Intent(DeviceActivity.this, DeviceContentActivity.class);
                // Pass ID of selected device
                intent.putExtra("deviceID", item.id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onAddDeviceAccessSuccess() {

    }

    @Override
    public void onRemoveDeviceAccessSuccess() {

    }

    @Override
    public void showError(String cause) {
        // Toast failure cause
        String response = getString(R.string.error) + "! " +
                getString(R.string.cause) + ": " + cause;
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

    // TODO set menu
}
