package com.dpgv1.trackme.api;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MessageAPI {
    @POST("message")
    Call<LoginSignUpResponse> sendMessage(
            @Header("Authorization") String token,
            @Body Message message
    );

    @GET("message")
    Call<List<Message>> getMessage(@Header("Authorization") String token);
}
