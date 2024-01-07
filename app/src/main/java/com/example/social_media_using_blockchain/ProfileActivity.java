package com.example.social_media_using_blockchain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerProfileUIAdapter adapter = new ViewPagerProfileUIAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        tab.setupWithViewPager(viewPager);
        tab.getTabAt( 0).setIcon(R.drawable.reels_ic);
        tab.getTabAt(1).setIcon(R.drawable.ic_favorite);
    }
}
