package com.example.newsdaily.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.newsdaily.Service.Model.Article;
import com.example.newsdaily.Service.Model.NewsModel;
import com.example.newsdaily.Service.Network.RetroInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;
    private static Context ctx;
    private static MutableLiveData allNews, sports, health, science, entertainment, technology;
    String country="us";
    String api_key = "a604cd395f394578b5e83601fbc228f4";
    String category = "sports";

    public static NewsRepository getNewsRepositoryInstance(Context context){

        if(newsRepository==null){
            ctx = context;
            newsRepository = new NewsRepository();
        }

        return newsRepository;
    }


    public MutableLiveData<List<Article>> getAllNews(){

        if(allNews==null){
            allNews = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getNews(country, 100, api_key).enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                allNews.postValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });

        return allNews;

    }


    public MutableLiveData<List<Article>> getSportsNews(){

        if(sports==null){
            sports = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getCategoryNews(country, category, 100, api_key)
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        sports.postValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {

                    }
                });

        return sports;
    }


    public MutableLiveData<List<Article>> getHealthNews(){

        if(health==null){
            health = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getCategoryNews(country, "health", 100, api_key)
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        health.postValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {

                    }
                });

        return health;
    }


    public MutableLiveData<List<Article>> getScienceNews(){

        if(science==null){
            science = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getCategoryNews(country, "science", 100, api_key)
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        science.postValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {

                    }
                });

        return science;
    }


    public MutableLiveData<List<Article>> getEntertainmentNews(){

        if(entertainment==null){
            entertainment = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getCategoryNews(country, "entertainment", 100, api_key)
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        entertainment.postValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {

                    }
                });

        return entertainment;
    }


    public MutableLiveData<List<Article>> getTechnologyNews(){

        if(technology==null){
            technology = new MutableLiveData();
        }

        RetroInstance.getRetroInstance().getCategoryNews(country, "technology", 100, api_key)
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        technology.postValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {

                    }
                });

        return technology;
    }



}
