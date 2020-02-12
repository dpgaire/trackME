package com.example.trackmewear.Bll;

import com.example.trackmewear.API.UserAPI;
import com.example.trackmewear.Url.Url;
import com.example.trackmewear.serverResponse.LoginResposne;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

        // Login login= new Login(username,password);
        UserAPI userapi= Url.getInstance().create(UserAPI.class);
        Call<LoginResposne> usersCall = userapi.loginUser(username,password);

        try {
            Response<LoginResposne> loginResponse = usersCall.execute();
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
