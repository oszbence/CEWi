package hu.cewi.client.user;

import javax.inject.Singleton;

import dagger.Component;
import hu.cewi.client.user.interactor.InteractorModule;

/**
 * Created by Bence on 2016.05.19..
 */
@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends CEWiApplicationComponent {
}
