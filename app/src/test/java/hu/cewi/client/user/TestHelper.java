package hu.cewi.client.user;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by Bence on 2016.05.19..
 */
public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        CEWiApplication application = (CEWiApplication) RuntimeEnvironment.application;
        CEWiApplicationComponent injector = DaggerTestComponent.builder().testModule(
                new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
    }
}
