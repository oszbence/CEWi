package hu.cewi.client.user.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bence on 2016.05.06..
 */
public class LoginResponse {

    public String access_token;

    public String token_type;

    public int expires_in;

    public String userName;

    @SerializedName(".issued")
    public String issued;

    @SerializedName(".expires")
    public String expires;
}
