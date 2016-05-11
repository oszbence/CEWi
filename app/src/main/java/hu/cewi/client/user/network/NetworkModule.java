package hu.cewi.client.user.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bence on 2016.05.11..
 */
@Module
public class NetworkModule {

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
        return retrofit.create(AccountApi.class);
    }

    @Provides
    @Singleton
    public DeviceApi provideDeviceApi(Retrofit retrofit) {
        return retrofit.create(DeviceApi.class);
    }
}