package hu.cewi.client.user;

import javax.inject.Singleton;

import dagger.Component;
import hu.cewi.client.user.ui.UIModule;
import hu.cewi.client.user.ui.main.MainActivity;

/**
 * Created by Bence on 2016.04.08..
 */
@Singleton
@Component(modules = {UIModule.class})
public interface CEWiApplicationComponent {
    void inject(MainActivity mainActivity);
}
