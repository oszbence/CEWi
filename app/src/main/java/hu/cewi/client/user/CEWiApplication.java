package hu.cewi.client.user;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

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

    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
