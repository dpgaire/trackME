package com.dpgv1.trackme.api;

import com.dpgv1.trackme.ServerResponse.LoginSignUpResponse;
import com.dpgv1.trackme.model.AddFriend;
import com.dpgv1.trackme.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AddFriendAPI {
    @POST("addfriend")
    Call<LoginSignUpResponse> addFriend(@Header( "Authorization" ) String token, @Body AddFriend addFriend);

    @GET("addfriend")
    Call<List<AddFriend>> getFriend(@Header( "Authorization" ) String token);

    @DELETE("/addfriend/{addfriendId}")
    Call<LoginSignUpResponse> deletefriend(@Header( "Authorization" ) String token, @Path( "addfriendId" ) String addfriendid);

}
