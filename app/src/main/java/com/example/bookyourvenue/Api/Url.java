package com.example.bookyourvenue.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    //this is the URL to connect with the API
public static String BASE_URL="http://192.168.137.52:3000/";

    API api;
//this method will return API with Base URL
    public API createInstanceofRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
        return api;
    }
}
