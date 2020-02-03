package com.dpgv1.trackme.api;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.model.User;
import com.dpgv1.trackme.model.UserLogin;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {


    @POST("user/signup")
    Call<LoginSignUpResponse> registerUser(@Body User user);



    @POST("user/login")
    Call<LoginSignUpResponse> loginUser(@Body UserLogin userLogin);

////    @Multipart
////    @POST("upload")
////    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);
////
////    @GET("user/me")
////    Call<User> getUserDetails(@Header("Authorization") String token);
}
