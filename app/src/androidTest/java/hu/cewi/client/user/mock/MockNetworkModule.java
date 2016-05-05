package hu.cewi.client.user.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.cewi.client.user.network.AccountApi;
import hu.cewi.client.user.network.DeviceApi;
import hu.cewi.client.user.network.NetworkConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bence on 2016.05.05..
 */
@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public AccountApi provideAccountApi(Retrofit retrofit) {
        return new MockAccountApi();
    }

    @Provides
    @Singleton
    public DeviceApi provideDeviceApi(Retrofit retrofit) {
        return new MockDeviceApi();
    }
}
