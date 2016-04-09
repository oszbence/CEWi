package hu.cewi.client.user.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.cewi.client.user.CEWiApplication;
import hu.cewi.client.user.R;
import hu.cewi.client.user.di.Network;
import hu.cewi.client.user.interactor.account.AccountInteractor;
import hu.cewi.client.user.ui.Presenter;

/**
 * Created by Bence on 2016.04.08..
 */
public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    Context ctx;

    @Inject
    AccountInteractor accountInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        CEWiApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showDevices() {
        screen.showDevices();
    }

    public void showLogin() {
        screen.showLogin();
    }

    public void logout() {
        try {
            // Get locally saved user data
            SharedPreferences userData = ctx.getSharedPreferences("userData", 0);
            final String userID = userData.getString("userID", null);
            final String pass = userData.getString("password", null);

            // Send logout request to server from background thread
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String response;
                    if(accountInteractor.logoutUser(userID, pass)){
                        response = ctx.getString(R.string.logoutSuccess);
                    } else {
                        response = ctx.getString(R.string.logoutFailed);
                    }
                    // Inform user
                    screen.showLogoutResponse(response);
                }
            });
        } catch (NullPointerException e) {
            Log.e("Logout failed", "Cause:");
            e.printStackTrace();
        }
    }
}