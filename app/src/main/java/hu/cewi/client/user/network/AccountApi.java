package hu.cewi.client.user.network;

import hu.cewi.client.user.model.LoginResponse;
import hu.cewi.client.user.model.RegisterParams;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AccountApi {

    @POST("/account/register")
    public Call<Void> registerUser(@Body RegisterParams params);

    /**
     * @param grantType must be "password"
     */
    @FormUrlEncoded
    @POST("/token")
    public Call<LoginResponse> loginUser(
            @Field("grant_type") String grantType,
            @Field("username") String email,
            @Field("password") String pass
    );

}