package com.dpgv1.trackme.api;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.model.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {

    @FormUrlEncoded
    @POST("user/signup")
    Call<RequestBody> registerUser(@Body User user);


//    @FormUrlEncoded
//    @POST("user/login")
//    Call<LoginSignUpResponse> checkUser(@Field("username") String username, @Field("password") String password);
//
////    @Multipart
////    @POST("upload")
////    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);
////
////    @GET("user/me")
////    Call<User> getUserDetails(@Header("Authorization") String token);
}
