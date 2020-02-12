package com.example.trackmewear.API;

import com.example.trackmewear.model.User;
import com.example.trackmewear.serverResponse.LoginResposne;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResposne> loginUser(User user);

}
