package hu.cewi.client.user.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.cewi.client.user.ui.main.MainPresenter;
import hu.cewi.client.user.ui.main.MainScreen;
import hu.cewi.client.user.utils.RobolectricDaggerTestRunner;

/**
 * Created by Bence on 2016.05.19..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void test() {

    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}