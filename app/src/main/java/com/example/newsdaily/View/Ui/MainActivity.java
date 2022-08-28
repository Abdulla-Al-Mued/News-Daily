package com.example.newsdaily.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.newsdaily.R;
import com.example.newsdaily.View.Adapter.PagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, mScience, mHealth, mTech, mEntertainment, mSports;
    PagerAdapter pagerAdapter;
    Toolbar mToolbar;

    String api_key = "a604cd395f394578b5e83601fbc228f4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mHome = findViewById(R.id.home);
        mScience = findViewById(R.id.science);
        mSports = findViewById(R.id.sports);
        mHealth = findViewById(R.id.health);
        mTech = findViewById(R.id.technology);
        mEntertainment = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5){

                    pagerAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}