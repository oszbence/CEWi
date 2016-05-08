package hu.cewi.client.user.mock;

import java.io.IOException;

import hu.cewi.client.user.model.LoginResponse;
import hu.cewi.client.user.model.RegisterParams;
import hu.cewi.client.user.network.AccountApi;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;

/**
 * Created by Bence on 2016.05.05..
 */
public class MockAccountApi implements AccountApi {

    @Override
    public Call<Void> registerUser(@Body RegisterParams params) {
        return new Call<Void>() {
            @Override
            public Response<Void> execute() throws IOException {
                return Response.success(null);
            }

            @Override
            public void enqueue(Callback<Void> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Void> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }

    @Override
    public Call<LoginResponse> loginUser(@Field("grant_type") String grantType,
                                         @Field("username") String email,
                                         @Field("password") String pass) {
        return new Call<LoginResponse>() {
            @Override
            public Response<LoginResponse> execute() throws IOException {
                LoginResponse resp = new LoginResponse();
                resp.access_token = "granted";
                resp.expires = "never";
                resp.issued = "to you";
                return Response.success(resp);
            }

            @Override
            public void enqueue(Callback<LoginResponse> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<LoginResponse> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }
}
