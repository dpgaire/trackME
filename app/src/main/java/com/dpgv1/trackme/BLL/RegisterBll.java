package com.dpgv1.trackme.BLL;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.api.UserAPI;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class RegisterBll {
    boolean isSuccess = false;

    public boolean RegisterBll(User user) {

        UserAPI userapi = Url.getInstance().create( UserAPI.class );
        Call<LoginSignUpResponse> usersCall = userapi.registerUser( user);

        try {
            Response<LoginSignUpResponse> registerResponse = usersCall.execute();
            if (registerResponse.isSuccessful() ) {

//                Url.token += registerResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}
