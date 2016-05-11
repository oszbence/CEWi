package hu.cewi.client.user;

import javax.inject.Singleton;

import dagger.Component;
import hu.cewi.client.user.interactor.InteractorModule;
import hu.cewi.client.user.mock.MockNetworkModule;

/**
 * Created by Bence on 2016.05.11..
 */
@Singleton
@Component(modules = {MockNetworkModule.class, AndroidTestModule.class, InteractorModule.class})
public interface AndroidTestComponent extends CEWiApplicationComponent {
}
