package hu.cewi.client.user.interactor.account;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.interactor.account.event.LoginResponseEvent;
import hu.cewi.client.user.interactor.account.event.RegisterUserResponseEvent;
import hu.cewi.client.user.model.LoginResponse;
import hu.cewi.client.user.model.RegisterParams;
import hu.cewi.client.user.network.AccountApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Bence on 2016.04.09..
 */
public class AccountInteractor {

    @Inject
    AccountApi accountApi;

    public AccountInteractor() {
        CEWiApplication.injector.inject(this);
    }

    public void loginUser(String userID, String passwd) {
        // TODO save user auth data
        Call<LoginResponse> call = accountApi.loginUser("password", userID, passwd);
        boolean success = false;
        String message = "Client error";
        try {
            Response<LoginResponse> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new LoginResponseEvent(success, message));

    }

    public void registerUser(String userID, String userName, String passwd) {
        Call<Void> call = accountApi.registerUser(new RegisterParams(userID, userName, passwd));
        boolean success = false;
        String message = "Client error";
        try {
            Response<Void> response = call.execute();
            success = response.isSuccessful();
            message = response.message();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new RegisterUserResponseEvent(success, message));
    }
}
