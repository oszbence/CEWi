package hu.cewi.client.user.ui.devices;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.model.Device;
import hu.cewi.client.user.ui.devicecontent.DeviceContentActivity;

public class DeviceActivity extends Activity implements DeviceScreen {

    private ListView deviceListView;

    private ArrayAdapter<Device> deviceListAdapter;

    private List<Device> deviceList;

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
        deviceList = devices;
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
                intent.putExtra("deviceName", item.name);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onAddDeviceAccessSuccess() {
        Toast.makeText(this, getString(R.string.device_added), Toast.LENGTH_LONG).show();
        devicePresenter.getDevices();
    }

    @Override
    public void onRemoveDeviceAccessSuccess() {
        Toast.makeText(this, getString(R.string.device_removed), Toast.LENGTH_LONG).show();
        devicePresenter.getDevices();
    }

    @Override
    public void showError(String cause) {
        // Toast failure cause
        String response = getString(R.string.error) + "! " +
                getString(R.string.cause) + ": " + cause;
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

    public void onAddDeviceAccessClicked(View v) {
        // Scan device data from QR code
        try {

            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes
            // Start scan here
            startActivityForResult(intent, 0);
            // Handle result at onActivityResult()
        } catch (Exception e) {

            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);

        }
    }

    public void onRemoveDeviceAccessClicked(View v) {
        try {
            // Let the user select device to remove from a list
            final ArrayAdapter<Device> devicesAdapter = new ArrayAdapter<Device>(this, R.layout.list_item,
                    new ArrayList<Device>(deviceList));
            final AlertDialog.Builder alert = new AlertDialog.Builder(DeviceActivity.this);
            alert.setTitle(getString(R.string.remove_device_access));
            alert.setAdapter(
                    devicesAdapter,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Device selected = devicesAdapter.getItem(which);
                            // Send request to server
                            devicePresenter.removeDeviceAccess(selected.id);
                        }
                    });
            alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            alert.show();
        } catch (NullPointerException e) {
            Toast.makeText(this, getString(R.string.nothingToRemove), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                String[] idAndKey = contents.split(",");
                // QR code must contain id and key split by a ','
                if(idAndKey.length < 2) {
                    Toast.makeText(DeviceActivity.this, getString(R.string.wrongQR), Toast.LENGTH_LONG).show();
                }
                else {
                    // Send request to server
                    devicePresenter.addDeviceAccess(idAndKey[0], idAndKey[1]);
                }
            }
            if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, getString(R.string.qrFailure), Toast.LENGTH_LONG).show();
            }
        }
    }
}
