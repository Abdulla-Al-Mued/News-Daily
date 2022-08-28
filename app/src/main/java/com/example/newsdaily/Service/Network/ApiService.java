package com.example.newsdaily.Service.Network;


import com.example.newsdaily.Service.Model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("top-headlines")
    Call<NewsModel> getNews(

            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    );

    @GET("top-headlines")
    Call<NewsModel> getCategoryNews(

            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey

    );


}
