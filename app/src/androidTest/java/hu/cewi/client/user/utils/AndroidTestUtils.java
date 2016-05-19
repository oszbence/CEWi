package hu.cewi.client.user.utils;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import hu.cewi.client.user.AndroidTestComponent;
import hu.cewi.client.user.AndroidTestModule;
import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.CEWiApplicationComponent;
import hu.cewi.client.user.DaggerCEWiApplicationComponent;
import hu.cewi.client.user.ui.UIModule;

/**
 * Created by Bence on 2016.05.19..
 */
public class AndroidTestUtils {

    public static void setTestInjector() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        CEWiApplication app = (CEWiApplication) instrumentation.getTargetContext()
                .getApplicationContext();

        // TODO
        /*
        AndroidTestComponent androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(new AndroidTestModule(app)).build();
        app.injector = androidTestComponent;
        */
    }

    public static void setProdutionInjector() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        CEWiApplication app = (CEWiApplication) instrumentation.getTargetContext()
                .getApplicationContext();

        CEWiApplicationComponent androidTestComponent = DaggerCEWiApplicationComponent.builder().uIModule(new UIModule(app)).build();
        app.injector = androidTestComponent;
    }
}
