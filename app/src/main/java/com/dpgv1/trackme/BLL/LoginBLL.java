package com.dpgv1.trackme.BLL;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.Login;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {
    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        com.dpgv1.trackme.api.UserAPI usersAPI = Url.getInstance().create(UserAPI.class);
        Call<LoginSignUpResponse> usersCall = usersAPI.loginUser(username, password);

        try {
            Response<LoginSignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
