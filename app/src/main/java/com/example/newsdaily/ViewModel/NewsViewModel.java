package com.example.newsdaily.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.newsdaily.Service.Model.Article;
import com.example.newsdaily.Service.Repository.NewsRepository;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {

    private NewsRepository newsRepository;


    public NewsViewModel(@NonNull Application application) {
        super(application);

        newsRepository = NewsRepository.getNewsRepositoryInstance(application);
    }

    public LiveData<List<Article>> getNews(){

        return newsRepository.getAllNews();
    }

    public LiveData<List<Article>> getNewsSports(){

        return newsRepository.getSportsNews();
    }

    public LiveData<List<Article>> getNewsHealth(){

        return newsRepository.getHealthNews();
    }

    public LiveData<List<Article>> getNewsScience(){

        return newsRepository.getScienceNews();
    }

    public LiveData<List<Article>> getNewsEntertainment(){

        return newsRepository.getEntertainmentNews();
    }

    public LiveData<List<Article>> getNewsTechnology(){

        return newsRepository.getTechnologyNews();
    }
}
