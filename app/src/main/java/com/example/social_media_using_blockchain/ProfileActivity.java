package com.example.social_media_using_blockchain;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
public class ProfileActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerProfileUIAdapter adapter = new ViewPagerProfileUIAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);
        tab.getTabAt(0).setIcon(R.drawable.reels_ic);
        tab.getTabAt(1).setIcon(R.drawable.ic_favorite);
    }
}

