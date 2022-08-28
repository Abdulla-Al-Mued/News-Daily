package com.example.newsdaily.Service.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static Retrofit retrofit;
    public static String BASE_URL = "https://newsapi.org/v2/";//"top-headlines?country=us&apiKey=a604cd395f394578b5e83601fbc228f4";

    public static ApiService getRetroInstance(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiService.class);
    }


}
