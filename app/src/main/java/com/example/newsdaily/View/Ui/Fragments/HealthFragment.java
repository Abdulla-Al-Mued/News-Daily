package com.example.newsdaily.View.Ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsdaily.R;
import com.example.newsdaily.Service.Model.Article;
import com.example.newsdaily.Service.Model.NewsModel;
import com.example.newsdaily.Service.Network.RetroInstance;
import com.example.newsdaily.View.Adapter.NewsAdapter;
import com.example.newsdaily.ViewModel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    NewsAdapter adapter;
    private RecyclerView recyclerView;
    private NewsViewModel newsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.healthfragment, null);

        recyclerView = view.findViewById(R.id.healthRecview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        findNews();

        return view;
    }

    private void findNews() {

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.getNewsHealth().observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                adapter = new NewsAdapter(getContext(), articles);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
