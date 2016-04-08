package hu.cewi.client.user;

import android.app.Application;
import android.util.Log;

import hu.cewi.client.user.ui.UIModule;

/**
 * Created by Bence on 2016.04.08..
 *
 * Application component MUST BE REGISTERED by name in MANIFEST file!!!
 */
public class CEWiApplication extends Application {

    public static CEWiApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("CEWiApplication","onCreate started");
        injector = DaggerCEWiApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).build();
        Log.d("CEWiApplication","injector inited");
    }

}
