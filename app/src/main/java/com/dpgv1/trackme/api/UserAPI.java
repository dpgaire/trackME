package com.dpgv1.trackme.api;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.model.UserLogin;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserAPI {


    @POST("user/signup")
    Call<LoginSignUpResponse> registerUser(@Body User user);


    @FormUrlEncoded
    @POST("user/login")
    Call<LoginSignUpResponse> loginUser(@Field("username") String username, @Field("password") String password);


    @GET("user/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

    @PUT("user/me")
    Call<LoginSignUpResponse> getAlluserDetails(@Header("Authorization") String token, @Body User user);


}
