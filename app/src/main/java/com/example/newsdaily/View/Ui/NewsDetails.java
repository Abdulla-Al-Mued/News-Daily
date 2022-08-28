package com.example.newsdaily.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newsdaily.R;
import com.example.newsdaily.Service.Model.Article;

public class NewsDetails extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    Article ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        setSupportActionBar(toolbar);

        ob = (Article) getIntent().getSerializableExtra("News");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(ob.getUrl());

    }
}