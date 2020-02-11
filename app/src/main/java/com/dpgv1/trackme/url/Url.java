package com.dpgv1.trackme.url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {


//    public static final String Base_Url="http://10.0.2.2:3008/";
    public static final String Base_Url="http://192.168.1.108:3008/";
    public static String token="Bearer ";
    public static String imagePath=Base_Url + "uploads/";

    public static Retrofit getInstance()
    {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
